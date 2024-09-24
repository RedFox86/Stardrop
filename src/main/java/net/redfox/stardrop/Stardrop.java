package net.redfox.stardrop;

import com.mojang.logging.LogUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.redfox.stardrop.config.StardropConfigs;
import net.redfox.stardrop.item.ModItems;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Stardrop.MOD_ID)
public class Stardrop {
    public static final String MOD_ID = "stardrop";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Stardrop(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        ModItems.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        context.registerConfig(ModConfig.Type.COMMON, StardropConfigs.SPEC, "stardrop-common.toml");

        MinecraftForge.EVENT_BUS.register(this);

        LOGGER.debug("Stardrops registered successfully!");
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
