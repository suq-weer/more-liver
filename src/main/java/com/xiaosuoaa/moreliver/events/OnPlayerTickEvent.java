package com.xiaosuoaa.moreliver.events;

import com.xiaosuoaa.moreliver.datagen.recipes.RecipeTypeRegisterBus;
import com.xiaosuoaa.moreliver.datagen.recipes.compressor.StructuralCompressorRecipe;
import com.xiaosuoaa.moreliver.ui.menu.StructuralCompressorMenu;
import net.minecraft.core.NonNullList;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.List;
import java.util.Optional;

public class OnPlayerTickEvent {

	public static void hook(PlayerTickEvent.Post playerTickEvent) {
		onStructuralCompressorMenu(playerTickEvent);
	}

	//结构压缩机合成逻辑
	private static void onStructuralCompressorMenu(PlayerTickEvent.Post event) {
		Player entity = event.getEntity();
		//当玩家打开结构压缩机的GUI时
		if (entity.containerMenu instanceof StructuralCompressorMenu) {
			Level world = entity.level();
			if (world.isClientSide()) return;
			RecipeManager recipes = world.getRecipeManager();
			NonNullList<Slot> slotNonNullList = entity.containerMenu.slots;
			ItemStack item0 = slotNonNullList.get(0).getItem();
			ItemStack item1 = slotNonNullList.get(1).getItem();
			ItemStack item2 = slotNonNullList.get(2).getItem();
			ItemStack item3 = slotNonNullList.get(3).getItem();
			//生成一个当前物品放置列表（每个蓝色格子）
			List<ItemStack> itemStackList = List.of(item0, item1, item2, item3);
			//查询是否有这个配方
			CraftingInput input = CraftingInput.of(2, 2, itemStackList);
			Optional<RecipeHolder<StructuralCompressorRecipe>> optional = recipes.getRecipeFor(
            		RecipeTypeRegisterBus.STRUCTURAL_COMPRESSOR.get(),
            		input,
					world
    		);
			//将查询结果作为一个变量
			ItemStack result = optional
            		.map(RecipeHolder::value)
            		.map(e -> e.assemble(input, world.registryAccess()))
					//如果没有结果返回一个空槽位
            		.orElse(ItemStack.EMPTY);
			//查询燃料（绿色格子）
			boolean matches = false;
			List<ItemStack> fuel = StructuralCompressorRecipe.getFuel();
			for (int i = 0; i <= fuel.size()-1; i++) {
				if (ItemStack.isSameItem(slotNonNullList.get(4).getItem(), fuel.get(i))) {
					matches = true;
				}
			}
			//如果有放燃料且配方有效
			if (matches && result != ItemStack.EMPTY) {
				if (!slotNonNullList.get(5).hasItem()) {
					slotNonNullList.get(5).set(result);
					for (int i = 0; i <= 4; i++) {
						ItemStack item = entity.containerMenu.getSlot(i).getItem();
						if (item.getCount() != 1) {
							ItemStack output = new ItemStack(item.getItemHolder(), item.getCount() - 1);
							entity.containerMenu.getSlot(i).set(output);
						} else {
							entity.containerMenu.getSlot(i).set(ItemStack.EMPTY);
						}
					}
				}
			}
		}
	}
}
