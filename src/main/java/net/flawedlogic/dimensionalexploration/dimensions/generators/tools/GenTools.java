package net.flawedlogic.dimensionalexploration.dimensions.generators.tools;

import net.minecraft.block.state.IBlockState;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraftforge.registries.GameData;

public class GenTools {
	  public final static char[] data = new char[65536];

    public static void setBlockState(ChunkPrimer primer, int index, IBlockState state) {
     data[index] = (char)GameData.getBlockStateIDMap().get(state);
    }

    public static IBlockState getBlockState(ChunkPrimer primer, int index) {
        return GameData.getBlockStateIDMap().getByValue(data[index]);
    }
    public static int floor(float value) {
        int i = (int) value;
        return value < i ? i - 1 : i;
    }

    public static int ceiling(float value) {
        int i = (int) value;
        return value > i ? i + 1 : i;
    }

    public static int floor(double value) {
        int i = (int) value;
        return value < i ? i - 1 : i;
    }

    public static int clamp(int num, int min, int max) {
        return num < min ? min : (num > max ? max : num);
    }

    public static double clamp(double lowerBnd, double upperBnd, double slide) {
        return slide < 0.0D ? lowerBnd : (slide > 1.0D ? upperBnd : lowerBnd + (upperBnd - lowerBnd) * slide);
    }

}
