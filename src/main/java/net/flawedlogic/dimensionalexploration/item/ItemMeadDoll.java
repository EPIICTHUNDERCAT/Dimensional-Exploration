package net.flawedlogic.dimensionalexploration.item;

import net.flawedlogic.dimensionalexploration.dimensions.TP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.server.management.PlayerList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class ItemMeadDoll extends DEItem {
	protected final int DIMENSION_FROM_ID;
	protected final int DIMENSION_TO_ID;

	public ItemMeadDoll(String name, int maxStack, int dimFromID, int dimToID) {
		super(name, maxStack);
		this.DIMENSION_FROM_ID = dimFromID;
		this.DIMENSION_TO_ID = dimToID;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {

		if (worldIn instanceof WorldServer) {
			//System.out.println(playerIn.getSpawnDimension());
			PlayerList playerList = worldIn.getMinecraftServer().getPlayerList();
			if (playerList != null) {
				TP teleporter = new TP((WorldServer) worldIn);
				// AxisAlignedBB boundingBox = new AxisAlignedBB(playerIn.pos,
				// otherPos).expand(0.5, 0.5, 0.5).offset(0, 0.5, 0);

				// it.setPortal(pos);
				if (playerIn instanceof EntityPlayerMP) {
					EntityPlayerMP teleportee = (EntityPlayerMP) playerIn;
					if (teleportee.dimension == DIMENSION_TO_ID) {
						playerList.transferPlayerToDimension((EntityPlayerMP) playerIn, DIMENSION_FROM_ID, teleporter);
					} else {
						playerList.transferPlayerToDimension((EntityPlayerMP) playerIn, DIMENSION_TO_ID, teleporter);
					}
				}

			}
		}
		return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));

	}
}
