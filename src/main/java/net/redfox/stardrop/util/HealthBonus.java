package net.redfox.stardrop.util;

import net.minecraft.world.entity.player.Player;
import net.redfox.stardrop.Stardrop;

public class HealthBonus {
	public static int getHealthBonus(Player player) {
		if (player.getPersistentData().contains(Stardrop.MOD_ID+".healthBonus")) {
			return player.getPersistentData().getInt(Stardrop.MOD_ID+".healthBonus");
		}
		return 0;
	}
	public static void setHealthBonus(Player player, int value) {
		player.getPersistentData().putInt(Stardrop.MOD_ID+".healthBonus", value);
	}
}