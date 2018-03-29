package net.flawedlogic.dimensionalexploration.dimensions;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Random;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.google.common.collect.Maps;

import net.flawedlogic.dimensionalexploration.dimensions.providers.WorldProviderMeadevil;
import net.flawedlogic.dimensionalexploration.init.DEConfig;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;

public enum Dimensions implements IStringSerializable {
	MEDEVIL(200, "meadevil", "", WorldProviderMeadevil.class) {

		@Override
		public int getDimensionID() {
			return DEConfig.thisdimensionID;
		}

		@Override
		public String[] getTaskDescriptions() {
			return new String[] { "Kill dirt zombies for the first water rune part",
					"Find a dungeon for the second part", "Kill the boss at midnight for the last part" };
		}
	};

	public abstract int getDimensionID();

	public String[] getTaskDescriptions() {
		return null;
	}

	private final byte level;

	private final String name;
	private final String suffix;
	private final Class<? extends WorldProvider> clazz;

	private Dimensions(int level, String nameIn, String suffixIn, Class<? extends WorldProvider> clazzIn) {
		this.level = (byte) level;

		this.name = nameIn;
		this.suffix = suffixIn;
		this.clazz = clazzIn;

	}

	public byte getLevel() {
		return level;
	}

	public String getSuffix() {
		return this.suffix;
	}



	public BlockPos adjustHeight(int chunkX, int chunkZ, BlockPos pos, World world, Random random) {
		return pos;
	}

	@Nullable
	public static Dimensions findDimension(int id) {
		for (Dimensions dimension : Dimensions.values()) {
			if (dimension.getDimensionID() == id) {
				return dimension;
			}
		}
		return null;
	}

	@Nullable
	public static Dimensions findLevel(int level) {
		for (Dimensions dimension : Dimensions.values()) {
			if (dimension.getLevel() == level) {
				return dimension;
			}
		}
		return null;
	}

	@Override
	@Nonnull
	public String getName() {
		return name;
	}

	public static Dimensions getDimensionFromLevel(int level) {
		return LEVEL_MAP.get(level);
	}

	public static final Dimensions[] VALUES;
	private static final Map<Integer, Dimensions> LEVEL_MAP;

	static {
		VALUES = values();
		LEVEL_MAP = Maps.newHashMap();
		for (Dimensions dim : VALUES) {
			LEVEL_MAP.put((int) dim.getLevel(), dim);
		}
	}

}
