package net.flawedlogic.dimensionalexploration.init;

import net.flawedlogic.dimensionalexploration.Reference;
import net.flawedlogic.dimensionalexploration.dimensions.Dimensions;
import net.flawedlogic.dimensionalexploration.dimensions.providers.WorldProviderMeadevil;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class DimRegistry {
	 public static DimensionType meadevilDimensionType;
	

	    public static void init() {
	        registerDimensionTypes();
	        registerDimensions();
	    }

	    private static void registerDimensionTypes() {
	    	meadevilDimensionType = DimensionType.register(Reference.ID, "", Dimensions.MEDEVIL.getDimensionID(), WorldProviderMeadevil.class, false);
	            }

	    private static void registerDimensions() {
	        DimensionManager.registerDimension(Dimensions.MEDEVIL.getDimensionID(), meadevilDimensionType);
	         }
}
