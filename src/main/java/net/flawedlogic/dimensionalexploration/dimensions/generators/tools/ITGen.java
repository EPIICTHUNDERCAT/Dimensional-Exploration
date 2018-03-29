package net.flawedlogic.dimensionalexploration.dimensions.generators.tools;

import net.minecraft.world.chunk.ChunkPrimer;

public interface ITGen {
	 void generate(int chunkX, int chunkZ, ChunkPrimer primer);

}
