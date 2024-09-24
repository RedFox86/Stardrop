package net.redfox.stardrop.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.redfox.stardrop.util.HealthBonus;

public class StardropSet {
	public StardropSet(CommandDispatcher<CommandSourceStack> dispatcher) {
		dispatcher.register(Commands.literal("stardrop").requires(commandSource -> commandSource.hasPermission(2)).then(Commands.literal("set").then(Commands.argument("value", IntegerArgumentType.integer()).executes(StardropSet::setHealthBonuses))));
	}
	private static int setHealthBonuses(CommandContext<CommandSourceStack> context) {
		CommandSourceStack source = context.getSource();
		if (source.getPlayer() != null) {
			int value = IntegerArgumentType.getInteger(context, "value");
			HealthBonus.setHealthBonus(source.getPlayer(), value);
			source.getPlayer().sendSystemMessage(Component.literal(source.getPlayer().getName().getString() + " health bonuses set to " + value));
			return Command.SINGLE_SUCCESS;
		}
		return 0;
	}
}