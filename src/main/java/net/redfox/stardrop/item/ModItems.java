package net.redfox.stardrop.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.redfox.stardrop.Stardrop;
import net.redfox.stardrop.item.custom.StardropItem;

public class ModItems {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Stardrop.MOD_ID);

	public static final RegistryObject<Item> STARDROP = ITEMS.register("stardrop", () -> new StardropItem(new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_MISC).food(ModFoods.STARDROP)));

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);

	}
}