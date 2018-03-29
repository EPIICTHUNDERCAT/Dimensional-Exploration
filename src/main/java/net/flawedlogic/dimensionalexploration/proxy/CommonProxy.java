package net.flawedlogic.dimensionalexploration.proxy;

import net.flawedlogic.dimensionalexploration.init.DEBlocks;
import net.flawedlogic.dimensionalexploration.init.DEItems;
import net.flawedlogic.dimensionalexploration.init.DERecipes;
import net.flawedlogic.dimensionalexploration.init.DimRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	public void preInit(FMLPreInitializationEvent preEvent) {

		register(preEvent);
	}

	public void init(FMLInitializationEvent event) {
		// DEOreDictionary.init(event);
		registerRender(event);

	}

	public void register(FMLPreInitializationEvent preEvent) {
		DEBlocks.register(preEvent);
		DEItems.register(preEvent);
		DimRegistry.init();
		registerEntities(preEvent);
		DERecipes.registerRecipes(preEvent);
	}

	public void registerRender(FMLInitializationEvent event) {
	}

	public void registerEntities(FMLPreInitializationEvent preEvent) {
	}
}
