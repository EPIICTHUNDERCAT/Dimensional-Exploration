package net.flawedlogic.dimensionalexploration.init;

import java.util.ArrayList;
import java.util.List;

import net.flawedlogic.dimensionalexploration.dimensions.Dimensions;
import net.flawedlogic.dimensionalexploration.item.ItemMeadDoll;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.world.DimensionType;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class DEItems {
	public static List<Item> items = new ArrayList<Item>();

	public static Item doll = new ItemMeadDoll("doll", 1, Dimensions.MEDEVIL.getDimensionID(), DimensionType.OVERWORLD.getId());

	private static List<Item> getItems() {
		return items;

	}

	public static void register(FMLPreInitializationEvent preEvent) {
		for (Item item : getItems()) {
			if (item != null) {
				ForgeRegistries.ITEMS.register(item);
			}
		}
	}

	public static void registerRender(FMLInitializationEvent event) {
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		for (Item item : getItems()) {
			renderItem.getItemModelMesher().register(item, 0,
					new ModelResourceLocation(item.getRegistryName().toString(), "inventory"));
		}
	}

}
