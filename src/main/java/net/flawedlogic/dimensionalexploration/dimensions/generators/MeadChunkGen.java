package net.flawedlogic.dimensionalexploration.dimensions.generators;

import java.util.List;
import java.util.Random;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldEntitySpawner;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.MapGenCaves;
import net.minecraftforge.event.terraingen.InitMapGenEvent.EventType;
import net.minecraftforge.event.terraingen.TerrainGen;

public class MeadChunkGen implements IChunkGenerator {
	private final World worldObj;
	private Random random;

	private List<Biome.SpawnListEntry> mobs = Lists
			.newArrayList(new Biome.SpawnListEntry(EntityZombie.class, 100, 2, 2));

	private MapGenBase caveGenerator = new MapGenCaves();
	private MeadTerrainGen terraingen = new MeadTerrainGen();

	public MeadChunkGen(World worldObj) {
		this.worldObj = worldObj;
		long seed = 0x1fff; // @todo
		this.random = new Random((seed + 516) * 314);
		terraingen.setup(worldObj, random, Blocks.DIRT.getDefaultState(), Biomes.ROOFED_FOREST);
		caveGenerator = TerrainGen.getModdedMapGen(caveGenerator, EventType.CAVE);
	}

	@Override
	public Chunk generateChunk(int x, int z) {
		
		
		ChunkPrimer chunkprimer = new ChunkPrimer();

		terraingen.generate(x, z, chunkprimer);
//System.out.println("attempting Gen");
		this.caveGenerator.generate(this.worldObj, x, z, chunkprimer);

		Chunk chunk = new Chunk(this.worldObj, chunkprimer, x, z);

		byte[] biomeArray = chunk.getBiomeArray();
		for (int i = 0; i < biomeArray.length; ++i) {
			biomeArray[i] = (byte) Biome.getIdForBiome(Biomes.ROOFED_FOREST);
		}

		chunk.generateSkylightMap();
		return chunk;
	}

	@Override
	public void populate(int x, int z) {
		int i = x * 16;
		int j = z * 16;
		BlockPos blockpos = new BlockPos(i, 0, j);
		Biome biome = this.worldObj.getBiome(blockpos.add(16, 0, 16));
		biome.decorate(this.worldObj, this.random, new BlockPos(i, 0, j));
		WorldEntitySpawner.performWorldGenSpawning(this.worldObj, biome, i + 8, j + 8, 16, 16, this.random);
	}

	@Override
	public boolean generateStructures(Chunk chunkIn, int x, int z) {
		return false;
	}

	@Override
	public List<Biome.SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
		if (creatureType == EnumCreatureType.MONSTER) {
			return mobs;
		}
		return ImmutableList.of();

	}

	@Override
	public void recreateStructures(Chunk chunkIn, int x, int z) {

	}

	@Override
	public BlockPos getNearestStructurePos(World worldIn, String structureName, BlockPos position,
			boolean findUnexplored) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isInsideStructure(World worldIn, String structureName, BlockPos pos) {
		// TODO Auto-generated method stub
		return false;
	}
}
