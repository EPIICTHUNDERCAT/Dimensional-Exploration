package net.flawedlogic.dimensionalexploration.dimensions.providers;

import javax.annotation.Nonnull;

import net.flawedlogic.dimensionalexploration.dimensions.generators.MeadChunkGen;
import net.flawedlogic.dimensionalexploration.init.DimRegistry;
import net.minecraft.init.Biomes;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.border.WorldBorder;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WorldProviderMeadevil extends WorldProvider {

	public void init() {
		this.biomeProvider = new BiomeProviderSingle(Biomes.ROOFED_FOREST);
		this.hasSkyLight = true;
	}

	@Override
	//@Nonnull
	public IChunkGenerator createChunkGenerator() {
		System.out.println("GenLoaded");
		return new MeadChunkGen(getWorld());
	}
	 public World getWorld() {
	        /** world object being used */
	        return world;
	    }
	@Override
	public double getHorizon() {
		return 0.0D;
	}

	/**
	 * Return Vec3D with biome specific fog color
	 */
	@SideOnly(Side.CLIENT)
	public Vec3d getFogColor(float p_76562_1_, float p_76562_2_) {
		return new Vec3d(0.20000000298023224D, 0.029999999329447746D, 0.029999999329447746D);
	}

	/**
	 * Calculates the angle of sun and moon in the sky relative to a specified time
	 * (usually worldTime)
	 */
	public float calculateCelestialAngle(long worldTime, float partialTicks) {
		return 0.5F;
	}

	/**
	 * True if the player can respawn in this dimension (true = overworld, false =
	 * nether).
	 */
	public boolean canRespawnHere() {
		return true;
	}

	/**
	 * Returns true if the given X,Z coordinate should show environmental fog.
	 */
	@SideOnly(Side.CLIENT)
	public boolean doesXZShowFog(int x, int z) {
		return true;
	}

	public WorldBorder createWorldBorder() {
		return new WorldBorder() {
			public double getCenterX() {
				return super.getCenterX() / 8.0D;
			}

			public double getCenterZ() {
				return super.getCenterZ() / 8.0D;
			}
		};
	}

	@Override
	public DimensionType getDimensionType() {
		return DimRegistry.meadevilDimensionType;
	}

	@Override
	@Nonnull
	public String getSaveFolder() {
		return "DEDIM_MEAD";
	}
}
