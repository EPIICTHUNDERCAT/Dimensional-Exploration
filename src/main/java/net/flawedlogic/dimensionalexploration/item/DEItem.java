package net.flawedlogic.dimensionalexploration.item;

import net.flawedlogic.dimensionalexploration.creativetab.DECreativeTab;
import net.flawedlogic.dimensionalexploration.init.DEItems;
import net.minecraft.item.Item;

public class DEItem extends Item {

	public DEItem(String name, int maxStack) {
		this.setMaxStackSize(maxStack);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(DECreativeTab.DETab);
		addToItems(this);
	}
	


	private void addToItems(Item item) {
		DEItems.items.add(item);
	}
}
