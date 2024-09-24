package net.redfox.stardrop.event;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;
import net.redfox.stardrop.Stardrop;
import net.redfox.stardrop.command.StardropGet;
import net.redfox.stardrop.command.StardropSet;
import net.redfox.stardrop.util.HealthBonus;

public class ModEvents {
	@Mod.EventBusSubscriber(modid = Stardrop.MOD_ID)
	public static class ForgeEvents {
		@SubscribeEvent
		public static void onPlayerClone(PlayerEvent.Clone event) {
			Player player = event.getEntity();
			CompoundTag originalData = event.getOriginal().getPersistentData();

			if (originalData.contains(Stardrop.MOD_ID+".healthBonus")) {
				player.getPersistentData().putInt(Stardrop.MOD_ID+".healthBonus", originalData.getInt(Stardrop.MOD_ID+".healthBonus"));
			}
			AttributeInstance maxHealth = player.getAttribute(Attributes.MAX_HEALTH);
			if (maxHealth != null) {
				maxHealth.setBaseValue(maxHealth.getValue() + (HealthBonus.getHealthBonus(player) * 2));
				player.setHealth(player.getMaxHealth());
			}
		}
		@SubscribeEvent
		public static void onCommandsRegister(RegisterCommandsEvent event) {
			new StardropGet(event.getDispatcher());
			new StardropSet(event.getDispatcher());

			ConfigCommand.register(event.getDispatcher());
		}
	}
}