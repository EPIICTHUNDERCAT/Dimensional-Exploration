package net.flawedlogic.dimensionalexploration.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DECreativeTab extends CreativeTabs {

	public DECreativeTab(int index, String label) {
			super(index, label);
		}

	public static final DECreativeTab DETab = new DECreativeTab(CreativeTabs.getNextID(), "decombat") {
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(Items.ACACIA_BOAT);
		}
	};

	@Override
	public ItemStack getTabIconItem() {
		return null;
	}
	@Override
	public boolean hasSearchBar() {
		return true;
		
	}

}
