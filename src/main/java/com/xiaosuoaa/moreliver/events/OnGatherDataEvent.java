package com.xiaosuoaa.moreliver.events;

import com.xiaosuoaa.moreliver.MoreLiver;
import com.xiaosuoaa.moreliver.datagen.ModBlockTagsProvider;
import com.xiaosuoaa.moreliver.datagen.ModLootTableProvider;
import com.xiaosuoaa.moreliver.datagen.ModRecipeProvider;
import com.xiaosuoaa.moreliver.datagen.ModWorldGen;
import net.minecraft.data.DataProvider;

public class OnGatherDataEvent {
	public static void hook(net.neoforged.neoforge.data.event.GatherDataEvent event) {
		var lp = event.getLookupProvider();
		var efh = event.getExistingFileHelper();
        event.getGenerator().addProvider(
                event.includeServer(),
                (DataProvider.Factory<ModRecipeProvider>) pOutput -> new ModRecipeProvider(pOutput,lp)
        );
		event.getGenerator().addProvider(
            event.includeServer(),
				(DataProvider.Factory<ModLootTableProvider>) output -> new ModLootTableProvider(
						event.getGenerator().getPackOutput(),
						event.getLookupProvider()
				)
		);
        event.getGenerator().addProvider(event.includeServer(), (DataProvider.Factory<ModWorldGen>) pOutput -> new ModWorldGen(pOutput,lp));
		event.getGenerator().addProvider(event.includeServer(), (DataProvider.Factory<ModBlockTagsProvider>) pOutput -> new ModBlockTagsProvider(pOutput,lp, MoreLiver.MODID, efh));
	}
}
