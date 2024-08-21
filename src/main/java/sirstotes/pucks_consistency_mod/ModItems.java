package sirstotes.pucks_consistency_mod;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Blocks;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.ShearsDispenserBehavior;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.MilkBucketItem;
import net.minecraft.item.PowderSnowBucketItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class ModItems {
    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
		.register((itemGroup) -> itemGroup.add(ModItems.COPPER_NUGGET));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((itemGroup) -> itemGroup.add(ModItems.COPPER_SHEARS));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((itemGroup) -> itemGroup.add(ModItems.COPPER_BUCKET));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((itemGroup) -> itemGroup.add(ModItems.COPPER_WATER_BUCKET));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((itemGroup) -> itemGroup.add(ModItems.COPPER_MILK_BUCKET));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((itemGroup) -> itemGroup.add(ModItems.COPPER_POWDER_SNOW_BUCKET));
        
		DispenserBlock.registerBehavior(COPPER_SHEARS.asItem(), new ShearsDispenserBehavior());
    }
    public static Item register(Item item, String id) {
		// Create the identifier for the item.
		Identifier itemID = Identifier.of(PucksConsistencyMod.MOD_ID, id);

		// Register the item.
		Item registeredItem = Registry.register(Registries.ITEM, itemID, item);

		// Return the registered item!
		return registeredItem;
	}
    public static final Item COPPER_NUGGET = register(new Item(new Item.Settings()), "copper_nugget");
    public static final TagKey<Item> SHEARS = TagKey.of(RegistryKeys.ITEM, Identifier.of("c", "shear"));
    public static final Item COPPER_SHEARS = register(
        new CopperShearsItem(new Item.Settings().maxDamage(138).component(DataComponentTypes.TOOL, CopperShearsItem.createToolComponent())), "copper_shears"
	);
    public static final Item COPPER_BUCKET = register(new CopperBucketItem(Fluids.EMPTY, new Item.Settings().maxCount(16)), "copper_bucket");
	public static final Item COPPER_WATER_BUCKET = register(new CopperBucketItem(Fluids.WATER, new Item.Settings().recipeRemainder(COPPER_BUCKET).maxCount(1)), "copper_water_bucket");
	public static final Item COPPER_MILK_BUCKET = register(new CopperMilkBucketItem(new Item.Settings().recipeRemainder(COPPER_BUCKET).maxCount(1)), "copper_milk_bucket");
	public static final Item COPPER_POWDER_SNOW_BUCKET = register(new CopperPowderSnowBucketItem(Blocks.POWDER_SNOW, SoundEvents.ITEM_BUCKET_EMPTY_POWDER_SNOW, new Item.Settings().maxCount(1)), "copper_powder_snow_bucket");
}
