package net.redfox.stardrop.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class StardropConfigs {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;

	public static final ForgeConfigSpec.ConfigValue<Integer> MAXIMUM_HEARTS_GAINED;
	public static final ForgeConfigSpec.ConfigValue<Boolean> GAIN_HEARTS;

	static {
		BUILDER.push("Client Configs for Stardrops");

		MAXIMUM_HEARTS_GAINED = BUILDER.comment("The maximum amount of hearts gained from eating stardrops")
				.defineInRange("Maximum Hearts", 10, 0, Integer.MAX_VALUE);
		GAIN_HEARTS = BUILDER.comment("Whether or not you gain an extra heart when you eat a stardrop.", "Disable if you have some special functionality for them.").define("Heart gain", true);

		BUILDER.pop();
		SPEC = BUILDER.build();
	}
}
