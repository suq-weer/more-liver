package com.xiaosuoaa.moreliver.items;

import com.xiaosuoaa.moreliver.MoreLiver;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.SwordItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CoalItems {
	private static Item.Properties pickaxe(Float damage, Float speed) {
		return new Item.Properties().attributes(
				PickaxeItem.createAttributes(
						CoalToolsTier.COAL_TIER,
						damage,
						speed
				)
		);
	}
	private static Item.Properties axe(Float damage, Float speed) {
		return new Item.Properties().attributes(
					AxeItem.createAttributes(
							CoalToolsTier.COAL_TIER,
							damage,
							speed
					)
		);
	}
	private static Item.Properties sword(Float damage, Float speed) {
		return new Item.Properties().attributes(
					SwordItem.createAttributes(
							CoalToolsTier.COAL_TIER,
							damage,
							speed
					)
		);
	}

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MoreLiver.MODID);

	//压缩煤炭1到9级
	public static final Supplier<Item> COAL_EX1 = ITEMS.registerSimpleItem("coal_ex1");
	public static final Supplier<Item> COAL_EX2 = ITEMS.registerSimpleItem("coal_ex2");
	public static final Supplier<Item> COAL_EX3 = ITEMS.registerSimpleItem("coal_ex3");
	public static final Supplier<Item> COAL_EX4 = ITEMS.registerSimpleItem("coal_ex4");
	public static final Supplier<Item> COAL_EX5 = ITEMS.registerSimpleItem("coal_ex5");
	public static final Supplier<Item> COAL_EX6 = ITEMS.registerSimpleItem("coal_ex6");
	public static final Supplier<Item> COAL_EX7 = ITEMS.registerSimpleItem("coal_ex7");
	public static final Supplier<Item> COAL_EX8 = ITEMS.registerSimpleItem("coal_ex8");
	public static final Supplier<Item> COAL_EX9 = ITEMS.registerSimpleItem("coal_ex9");
	//压缩煤炭工具1到5级
	public static final Supplier<PickaxeItem> COAL_PICKAXE = ITEMS.register("coal_pickaxe", () -> new PickaxeItem(
			CoalToolsTier.COAL_TIER,
			pickaxe(2f, 2f)
	));
	public static final Supplier<AxeItem> COAL_AXE = ITEMS.register("coal_axe", () -> new AxeItem(
			CoalToolsTier.COAL_TIER,
			axe(4f, 0.5f)
	));
	public static final Supplier<SwordItem> COAL_SWORD = ITEMS.register("coal_sword", () -> new SwordItem(
			CoalToolsTier.COAL_TIER,
			sword(3f, 1f)
	));
	public static final Supplier<PickaxeItem> COAL_PICKAXE_EX1 = ITEMS.register("coal_pickaxe_ex1", () -> new PickaxeItem(
			CoalToolsTier.COAL_TIER_EX1,
			pickaxe(3f, 2f)
	));
	public static final Supplier<AxeItem> COAL_AXE_EX1 = ITEMS.register("coal_axe_ex1", () -> new AxeItem(
			CoalToolsTier.COAL_TIER_EX1,
			axe(5f, 0.5f)
	));
	public static final Supplier<SwordItem> COAL_SWORD_EX1 = ITEMS.register("coal_sword_ex1", () -> new SwordItem(
			CoalToolsTier.COAL_TIER_EX1,
			sword(4f, 1f)
	));
	public static final Supplier<PickaxeItem> COAL_PICKAXE_EX2 = ITEMS.register("coal_pickaxe_ex2", () -> new PickaxeItem(
			CoalToolsTier.COAL_TIER_EX2,
			pickaxe(3f, 4f)
	));
	public static final Supplier<AxeItem> COAL_AXE_EX2 = ITEMS.register("coal_axe_ex2", () -> new AxeItem(
			CoalToolsTier.COAL_TIER_EX2,
			axe(5f, 1f)
	));
	public static final Supplier<SwordItem> COAL_SWORD_EX2 = ITEMS.register("coal_sword_ex2", () -> new SwordItem(
			CoalToolsTier.COAL_TIER_EX2,
			sword(4f, 2f)
	));
	public static final Supplier<PickaxeItem> COAL_PICKAXE_EX3 = ITEMS.register("coal_pickaxe_ex3", () -> new PickaxeItem(
			CoalToolsTier.COAL_TIER_EX3,
			pickaxe(5f, 5f)
	));
	public static final Supplier<AxeItem> COAL_AXE_EX3 = ITEMS.register("coal_axe_ex3", () -> new AxeItem(
			CoalToolsTier.COAL_TIER_EX3,
			axe(6f, 2f)
	));
	public static final Supplier<SwordItem> COAL_SWORD_EX3 = ITEMS.register("coal_sword_ex3", () -> new SwordItem(
			CoalToolsTier.COAL_TIER_EX3,
			sword(6f, 4f)
	));
	public static final Supplier<PickaxeItem> COAL_PICKAXE_EX4 = ITEMS.register("coal_pickaxe_ex4", () -> new PickaxeItem(
			CoalToolsTier.COAL_TIER_EX4,
			pickaxe(6f, 5f)
	));
	public static final Supplier<AxeItem> COAL_AXE_EX4 = ITEMS.register("coal_axe_ex4", () -> new AxeItem(
			CoalToolsTier.COAL_TIER_EX4,
			axe(8f, 2f)
	));
	public static final Supplier<SwordItem> COAL_SWORD_EX4 = ITEMS.register("coal_sword_ex4", () -> new SwordItem(
			CoalToolsTier.COAL_TIER_EX4,
			sword(8f, 4f)
	));
	public static final Supplier<PickaxeItem> COAL_PICKAXE_EX5 = ITEMS.register("coal_pickaxe_ex5", () -> new PickaxeItem(
			CoalToolsTier.COAL_TIER_EX5,
			pickaxe(8f, 6f)
	));
	public static final Supplier<AxeItem> COAL_AXE_EX5 = ITEMS.register("coal_axe_ex5", () -> new AxeItem(
			CoalToolsTier.COAL_TIER_EX5,
			axe(12f, 4f)
	));
	public static final Supplier<SwordItem> COAL_SWORD_EX5 = ITEMS.register("coal_sword_ex5", () -> new SwordItem(
			CoalToolsTier.COAL_TIER_EX5,
			sword(14f, 6f)
	));

	public static void register(IEventBus eventBus){
		ITEMS.register(eventBus);
	}

	public static void registerCoalsToIG(BuildCreativeModeTabContentsEvent event) {
		event.accept(COAL_EX1.get());
		event.accept(COAL_EX2.get());
		event.accept(COAL_EX3.get());
		event.accept(COAL_EX4.get());
		event.accept(COAL_EX5.get());
		event.accept(COAL_EX6.get());
		event.accept(COAL_EX7.get());
		event.accept(COAL_EX8.get());
		event.accept(COAL_EX9.get());
	}
	public static void registerCoalToolsToIG(BuildCreativeModeTabContentsEvent event) {
		event.accept(COAL_SWORD.get());
		event.accept(COAL_PICKAXE.get());
		event.accept(COAL_AXE.get());
		event.accept(COAL_SWORD_EX1.get());
		event.accept(COAL_PICKAXE_EX1.get());
		event.accept(COAL_AXE_EX1.get());
		event.accept(COAL_SWORD_EX2.get());
		event.accept(COAL_PICKAXE_EX2.get());
		event.accept(COAL_AXE_EX2.get());
		event.accept(COAL_SWORD_EX3.get());
		event.accept(COAL_PICKAXE_EX3.get());
		event.accept(COAL_AXE_EX3.get());
		event.accept(COAL_SWORD_EX4.get());
		event.accept(COAL_PICKAXE_EX4.get());
		event.accept(COAL_AXE_EX4.get());
		event.accept(COAL_SWORD_EX5.get());
		event.accept(COAL_PICKAXE_EX5.get());
		event.accept(COAL_AXE_EX5.get());
	}
}
