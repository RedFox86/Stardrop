package net.redfox.stardrop.command;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.redfox.stardrop.config.StardropConfigs;
import net.redfox.stardrop.util.HealthBonus;

public class StardropGet {
	public StardropGet(CommandDispatcher<CommandSourceStack> dispatcher) {
		dispatcher.register(Commands.literal("stardrop").requires(commandSource -> commandSource.hasPermission(2)).then(Commands.literal("get").executes((command) -> getHealthBonuses(command.getSource()))));
	}
	private int getHealthBonuses(CommandSourceStack source) {
		if (source.getPlayer() != null) {
			int value = HealthBonus.getHealthBonus(source.getPlayer());
			source.getPlayer().sendSystemMessage(Component.literal(source.getPlayer().getName().getString() + " has " + value + " out of maximum " + StardropConfigs.MAXIMUM_HEARTS_GAINED.get() + " health bonuses."));
			return value;
		}
		return 0;
	}
}