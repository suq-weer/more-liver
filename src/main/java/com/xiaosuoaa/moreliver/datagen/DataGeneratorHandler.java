package com.xiaosuoaa.moreliver.datagen;

import com.xiaosuoaa.moreliver.MoreLiver;
import net.minecraft.data.DataProvider;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@Mod(MoreLiver.MODID)
public class DataGeneratorHandler {
    public DataGeneratorHandler(IEventBus modEventBus){
        modEventBus.addListener(this::gatherData);
    }

    @SubscribeEvent
    private void gatherData(GatherDataEvent event){
        ExistingFileHelper efh = event.getExistingFileHelper();
        var lp = event.getLookupProvider();
        event.getGenerator().addProvider(
                event.includeServer(),
                (DataProvider.Factory<ModRecipeProvider>) pOutput -> new ModRecipeProvider(pOutput,lp)
        );
    }
}