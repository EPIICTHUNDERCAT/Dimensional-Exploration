package net.flawedlogic.dimensionalexploration.proxy;

import net.flawedlogic.dimensionalexploration.init.DEBlocks;
import net.flawedlogic.dimensionalexploration.init.DEItems;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy{
	public void preInit(FMLPreInitializationEvent preEvent) {
		super.preInit(preEvent);
	}
	
	public void init(FMLInitializationEvent event) {
		super.init(event);
	}
	
	@Override
	public void register(FMLPreInitializationEvent preEvent){
		super.register(preEvent);
	}
	
	@Override
	public void registerRender(FMLInitializationEvent event) {
		DEItems.registerRender(event);
		DEBlocks.registerRender(event);
	}
	
	@Override
	public void registerEntities(FMLPreInitializationEvent preEvent) {
		super.registerEntities(preEvent);
	}

}
