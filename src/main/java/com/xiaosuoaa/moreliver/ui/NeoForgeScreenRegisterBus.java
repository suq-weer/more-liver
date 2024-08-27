package com.xiaosuoaa.moreliver.ui;

import com.xiaosuoaa.moreliver.ui.Screen.StructuralCompressorScreen;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

public class NeoForgeScreenRegisterBus {
	public static void register(RegisterMenuScreensEvent event){
		event.register(NeoForgeMenuRegisterBus.STRUCTURAL_COMPRESSOR_GUI.get(), StructuralCompressorScreen::new);
	}
}
