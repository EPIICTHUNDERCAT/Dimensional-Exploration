package net.flawedlogic.dimensionalexploration.dimensions;

import net.minecraft.entity.Entity;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class TP extends Teleporter
{
	public TP(WorldServer world)
	{
		super(world);
	}

	@Override
	public boolean makePortal(Entity entity)
	{
		return true;
	}
}
