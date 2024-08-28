package com.xiaosuoaa.moreliver.jei;

import com.xiaosuoaa.moreliver.MoreLiver;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@JeiPlugin
public class MoreLiverJEIPlugin implements IModPlugin {
	public static IJeiHelpers iJeiHelpers;

	public MoreLiverJEIPlugin(IJeiHelpers pIJeiHelpers) {
		iJeiHelpers = pIJeiHelpers;
	}

	@Override
	public @NotNull ResourceLocation getPluginUid() {
		return ResourceLocation.fromNamespaceAndPath(MoreLiver.MODID, "plugin_jei");
	}

	@Override
	public void registerCategories(@NotNull IRecipeCategoryRegistration registration) {
		IModPlugin.super.registerCategories(registration);
	}

	@Override
	public void registerRecipes(@NotNull IRecipeRegistration registration) {
		IModPlugin.super.registerRecipes(registration);
	}
}
