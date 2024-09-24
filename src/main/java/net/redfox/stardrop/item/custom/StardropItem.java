package net.redfox.stardrop.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.redfox.stardrop.config.StardropConfigs;
import net.redfox.stardrop.util.HealthBonus;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class StardropItem extends Item {
	public StardropItem(Properties properties) {
		super(properties);
	}

	@Override
	public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
		if (entity instanceof Player player && !level.isClientSide() && StardropConfigs.GAIN_HEARTS.get()) {
			int healthBonuses = HealthBonus.getHealthBonus(player)+1;
			if (healthBonuses <= StardropConfigs.MAXIMUM_HEARTS_GAINED.get()) {
				System.out.println(healthBonuses);
				System.out.println(StardropConfigs.MAXIMUM_HEARTS_GAINED.get());
				HealthBonus.setHealthBonus(player, healthBonuses);
				AttributeInstance maxHealth = player.getAttribute(Attributes.MAX_HEALTH);
				if (maxHealth != null) {
					maxHealth.setBaseValue(maxHealth.getValue() + 2);
				}
			}
		}

		return super.finishUsingItem(stack, level, entity);
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {
		components.add(Component.literal("Hmm... what does it taste like?").withStyle(s -> s.withColor(TextColor.parseColor("#AAAAAA"))));

		super.appendHoverText(stack, level, components, tooltipFlag);
	}
}