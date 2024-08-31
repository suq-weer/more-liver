package com.xiaosuoaa.moreliver.emi;

import com.xiaosuoaa.moreliver.MoreLiver;
import com.xiaosuoaa.moreliver.blocks.NeoForgeBlockRegisterBus;
import com.xiaosuoaa.moreliver.datagen.recipes.RecipeTypeRegisterBus;
import com.xiaosuoaa.moreliver.datagen.recipes.compressor.StructuralCompressorRecipe;
import dev.emi.emi.api.EmiEntrypoint;
import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.render.EmiTexture;
import dev.emi.emi.api.stack.EmiStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;

@EmiEntrypoint
public class ModEMIPlugin implements EmiPlugin {
	public static final ResourceLocation CATEGORY_MIPMAPS = ResourceLocation.parse("moreliver:textures/emi/category_mipmaps.png");
    public static final EmiStack STRUCTURAL_COMPRESSOR = EmiStack.of(NeoForgeBlockRegisterBus.STRUCTURAL_COMPRESSOR_ITEM.get());
    public static final EmiRecipeCategory STRUCTURAL_COMPRESSOR_CATEGORY
        = new EmiRecipeCategory(ResourceLocation.fromNamespaceAndPath(MoreLiver.MODID, "structural_compressor"), STRUCTURAL_COMPRESSOR, new EmiTexture(CATEGORY_MIPMAPS, 0, 0, 16, 16, 16, 16, 128, 128));

	@Override
	public void register(EmiRegistry registry) {
        registry.addCategory(STRUCTURAL_COMPRESSOR_CATEGORY);
        registry.addWorkstation(STRUCTURAL_COMPRESSOR_CATEGORY, STRUCTURAL_COMPRESSOR);

		RecipeManager manager = registry.getRecipeManager();
		for (RecipeHolder<StructuralCompressorRecipe> recipe : manager.getAllRecipesFor(RecipeTypeRegisterBus.STRUCTURAL_COMPRESSOR.get())) {
            registry.addRecipe(new StructuralCompressorRecipeEMI(recipe.value()));
        }
	}
}
