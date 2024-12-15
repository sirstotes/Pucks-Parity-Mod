package sirstotes.pucks_parity_mod;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricBannerShieldItem;
import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShieldItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.FluidDrainable;
import net.minecraft.block.dispenser.DispenserBehavior;
import net.minecraft.block.dispenser.ItemDispenserBehavior;
import net.minecraft.block.dispenser.ShearsDispenserBehavior;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;
import sirstotes.pucks_parity_mod.accessors.FluidDrainableMixinAccessor;

import java.util.EnumMap;
import java.util.Map;

public class PucksParityModItems {
    public static void initialize() {
		DispenserBlock.registerBehavior(COPPER_SHEARS.asItem(), new ShearsDispenserBehavior());
        DispenserBlock.registerBehavior(GOLD_SHEARS.asItem(), new ShearsDispenserBehavior());

        //Dispenser behavior for placing lava then destroying the bucket.
        DispenserBehavior dispenserBehavior = new ItemDispenserBehavior() {
            private final ItemDispenserBehavior fallbackBehavior = new ItemDispenserBehavior();

            @Override
            public ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
                FluidModificationItem fluidModificationItem = (FluidModificationItem)stack.getItem();
                BlockPos blockPos = pointer.pos().offset(pointer.state().get(DispenserBlock.FACING));
                World world = pointer.world();
                if (fluidModificationItem.placeFluid(null, world, blockPos, null)) {
                    fluidModificationItem.onEmptied(null, world, stack, blockPos);
                    return this.decrementStackWithRemainder(pointer, stack, ItemStack.EMPTY);
                } else {
                    return this.fallbackBehavior.dispense(pointer, stack);
                }
            }
        };
        DispenserBlock.registerBehavior(PucksParityModItems.COPPER_LAVA_BUCKET, dispenserBehavior);
        //Dispenser behavior for just dispensing liquids
        DispenserBehavior dispenserBehavior2 = new ItemDispenserBehavior() {
            private final ItemDispenserBehavior fallbackBehavior = new ItemDispenserBehavior();

            @Override
            public ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
                FluidModificationItem fluidModificationItem = (FluidModificationItem)stack.getItem();
                BlockPos blockPos = pointer.pos().offset(pointer.state().get(DispenserBlock.FACING));
                World world = pointer.world();
                if (fluidModificationItem.placeFluid(null, world, blockPos, null)) {
                    fluidModificationItem.onEmptied(null, world, stack, blockPos);
                    if (stack.getItem() instanceof PucksParityModBucket bucket) {
                        return this.decrementStackWithRemainder(pointer, stack, new ItemStack(bucket.pucks_Parity_Mod$getEmptied()));
                    } else {
                        return this.decrementStackWithRemainder(pointer, stack, ItemStack.EMPTY);
                    }
                } else {
                    return this.fallbackBehavior.dispense(pointer, stack);
                }
            }
        };
        DispenserBlock.registerBehavior(PucksParityModItems.COPPER_WATER_BUCKET, dispenserBehavior2);
        DispenserBlock.registerBehavior(PucksParityModItems.COPPER_POWDER_SNOW_BUCKET, dispenserBehavior2);
        DispenserBlock.registerBehavior(PucksParityModItems.GOLD_WATER_BUCKET_3, dispenserBehavior2);
        DispenserBlock.registerBehavior(PucksParityModItems.GOLD_LAVA_BUCKET_3, dispenserBehavior2);
        DispenserBlock.registerBehavior(PucksParityModItems.GOLD_POWDER_SNOW_BUCKET_3, dispenserBehavior2);
        //Dispenser behavior for just filling liquids
        DispenserBehavior dispenserBehavior3 = new ItemDispenserBehavior() {
            @Override
            public ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
                WorldAccess worldAccess = pointer.world();
                BlockPos blockPos = pointer.pos().offset(pointer.state().get(DispenserBlock.FACING));
                BlockState blockState = worldAccess.getBlockState(blockPos);
                if (blockState.getBlock() instanceof FluidDrainable fluidDrainable) {
                    ItemStack itemStack = ((FluidDrainableMixinAccessor) fluidDrainable).pucks_Parity_Mod$tryDrainFluid(stack.getItem(), worldAccess, blockPos, blockState);
                    if (itemStack.isEmpty()) {
                        return super.dispenseSilently(pointer, stack);
                    } else {
                        worldAccess.emitGameEvent(null, GameEvent.FLUID_PICKUP, blockPos);
                        Item item = itemStack.getItem();
                        return this.decrementStackWithRemainder(pointer, stack, new ItemStack(item));
                    }
                } else {
                    return super.dispenseSilently(pointer, stack);
                }
            }
        };
        DispenserBlock.registerBehavior(PucksParityModItems.COPPER_BUCKET, dispenserBehavior3);
        DispenserBlock.registerBehavior(PucksParityModItems.GOLD_BUCKET, dispenserBehavior3);
        //Dispenser behavior for filling and emptying liquids
        DispenserBehavior dispenserBehavior4 = new ItemDispenserBehavior() {
            private final ItemDispenserBehavior fallbackBehavior = new ItemDispenserBehavior();
            @Override
            public ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
                World world = pointer.world();
                BlockPos blockPos = pointer.pos().offset(pointer.state().get(DispenserBlock.FACING));
                BlockState blockState = world.getBlockState(blockPos);
                FluidModificationItem fluidModificationItem = (FluidModificationItem)stack.getItem();
                if (blockState.getBlock() instanceof FluidDrainable fluidDrainable) {
                    ItemStack itemStack = ((FluidDrainableMixinAccessor) fluidDrainable).pucks_Parity_Mod$tryDrainFluid(stack.getItem(), world, blockPos, blockState);
                    if (itemStack.isEmpty()) {
                        return super.dispenseSilently(pointer, stack);
                    } else {
                        world.emitGameEvent(null, GameEvent.FLUID_PICKUP, blockPos);
                        Item item = itemStack.getItem();
                        return this.decrementStackWithRemainder(pointer, stack, new ItemStack(item));
                    }
                } else if (fluidModificationItem.placeFluid(null, world, blockPos, null)) {
                    fluidModificationItem.onEmptied(null, world, stack, blockPos);
                    if (stack.getItem() instanceof PucksParityModBucket bucket) {
                        return this.decrementStackWithRemainder(pointer, stack, new ItemStack(bucket.pucks_Parity_Mod$getEmptied()));
                    } else {
                        return this.decrementStackWithRemainder(pointer, stack, ItemStack.EMPTY);
                    }
                } else {
                    return this.fallbackBehavior.dispense(pointer, stack);
                }
            }
        };
        DispenserBlock.registerBehavior(PucksParityModItems.GOLD_WATER_BUCKET_1, dispenserBehavior4);
        DispenserBlock.registerBehavior(PucksParityModItems.GOLD_WATER_BUCKET_2, dispenserBehavior4);
        DispenserBlock.registerBehavior(PucksParityModItems.GOLD_LAVA_BUCKET_1, dispenserBehavior4);
        DispenserBlock.registerBehavior(PucksParityModItems.GOLD_LAVA_BUCKET_2, dispenserBehavior4);
        DispenserBlock.registerBehavior(PucksParityModItems.GOLD_POWDER_SNOW_BUCKET_1, dispenserBehavior4);
        DispenserBlock.registerBehavior(PucksParityModItems.GOLD_POWDER_SNOW_BUCKET_2, dispenserBehavior4);


        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((itemGroup) -> {
            itemGroup.addBefore(Items.BUCKET, new ItemStack(COPPER_BUCKET),
                    new ItemStack(COPPER_WATER_BUCKET),
                    new ItemStack(COPPER_LAVA_BUCKET),
                    new ItemStack(COPPER_POWDER_SNOW_BUCKET),
                    new ItemStack(COPPER_MILK_BUCKET));
            itemGroup.addAfter(Items.MILK_BUCKET, new ItemStack(GOLD_BUCKET),
                    new ItemStack(GOLD_WATER_BUCKET_3),
                    new ItemStack(GOLD_LAVA_BUCKET_3),
                    new ItemStack(GOLD_POWDER_SNOW_BUCKET_3),
                    new ItemStack(GOLD_MILK_BUCKET_3));
            itemGroup.addBefore(Items.FLINT_AND_STEEL, COPPER_FIRE_STARTER);
            itemGroup.addAfter(Items.FLINT_AND_STEEL, GOLD_FIRE_STARTER);
            itemGroup.addBefore(Items.SHEARS, COPPER_SHEARS);
            itemGroup.addAfter(Items.SHEARS, GOLD_SHEARS);
            itemGroup.addAfter(Items.BRUSH, new ItemStack(IRON_BRUSH), new ItemStack(GOLD_BRUSH));
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register((itemGroup) -> {
            itemGroup.addBefore(Items.SHIELD, COPPER_SHIELD);
            itemGroup.addAfter(Items.SHIELD, GOLD_SHIELD);
            itemGroup.addAfter(Items.LEATHER_HORSE_ARMOR, COPPER_HORSE_ARMOR);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register((itemGroup) -> {
            itemGroup.addBefore(Items.MILK_BUCKET, COPPER_MILK_BUCKET);
            itemGroup.addAfter(Items.MILK_BUCKET, GOLD_MILK_BUCKET_3);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register((itemGroup) -> itemGroup.addAfter(Items.IRON_NUGGET, COPPER_NUGGET));
    }
    public static Item register(Item item, String id) {
		Identifier itemID = Identifier.of(PucksParityMod.MOD_ID, id);
		return Registry.register(Registries.ITEM, itemID, item);
	}
    public static Item register(Item.Settings settings, String id) {
        Identifier itemID = Identifier.of(PucksParityMod.MOD_ID, id);
        return Registry.register(Registries.ITEM, itemID, new Item(settings));
    }
    public static RegistryKey<EquipmentAsset> registerEquipmentAssetKey(String id) {
        return RegistryKey.of(RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset")), Identifier.of(PucksParityMod.MOD_ID, id));
    }
    public static final Item COPPER_NUGGET = register(new Item(new Item.Settings()), "copper_nugget");
    public static final Item COPPER_SHEARS = register(new ShearsItem(new Item.Settings().maxDamage(138).component(DataComponentTypes.TOOL, ShearsItem.createToolComponent())), "copper_shears");
    public static final Item GOLD_SHEARS = register(new ShearsItem(new Item.Settings().maxDamage(200).component(DataComponentTypes.TOOL, ShearsItem.createToolComponent())), "gold_shears");

    public static final Item COPPER_BUCKET = register(new CopperBucketItem(Fluids.EMPTY, new Item.Settings().maxCount(16)), "copper_bucket");
	public static final Item COPPER_WATER_BUCKET = register(new CopperBucketItem(Fluids.WATER, new Item.Settings().recipeRemainder(COPPER_BUCKET).maxCount(1)), "copper_water_bucket");
	public static final Item COPPER_LAVA_BUCKET = register(new CopperBucketItem(Fluids.LAVA, new Item.Settings()), "copper_lava_bucket");
    public static final Item COPPER_MILK_BUCKET = register((new Item.Settings()).recipeRemainder(COPPER_BUCKET).component(DataComponentTypes.CONSUMABLE, ConsumableComponents.MILK_BUCKET).useRemainder(COPPER_BUCKET).maxCount(1), "copper_milk_bucket");
	public static final Item COPPER_POWDER_SNOW_BUCKET = register(new CopperPowderSnowBucketItem(Blocks.POWDER_SNOW, SoundEvents.ITEM_BUCKET_EMPTY_POWDER_SNOW, new Item.Settings().maxCount(1)), "copper_powder_snow_bucket");
    public static final Item COPPER_FIRE_STARTER = register(new FlintAndSteelItem(new Item.Settings().maxDamage(16)), "copper_fire_starter");
    public static final Item COPPER_SHIELD = register(new FabricShieldItem(new Item.Settings().maxDamage(150), 5, 13, Items.COPPER_INGOT), "copper_shield");

    public static final Item GOLD_BUCKET = register(new GoldBucketItem(Fluids.EMPTY, null, 0, new Item.Settings().maxCount(16)), "gold_bucket");
    public static final Item GOLD_WATER_BUCKET_1 = register(new GoldBucketItem(Fluids.WATER, GOLD_BUCKET, 1, new Item.Settings().recipeRemainder(GOLD_BUCKET).maxCount(1)), "gold_water_bucket_1");
    public static final Item GOLD_WATER_BUCKET_2 = register(new GoldBucketItem(Fluids.WATER, GOLD_WATER_BUCKET_1, 2, new Item.Settings().recipeRemainder(GOLD_WATER_BUCKET_1).maxCount(1)), "gold_water_bucket_2");
    public static final Item GOLD_WATER_BUCKET_3 = register(new GoldBucketItem(Fluids.WATER, GOLD_WATER_BUCKET_2, 3, new Item.Settings().recipeRemainder(GOLD_WATER_BUCKET_2).maxCount(1)), "gold_water_bucket_3");
    public static final Item GOLD_LAVA_BUCKET_1 = register(new GoldBucketItem(Fluids.LAVA, GOLD_BUCKET, 1, new Item.Settings().recipeRemainder(GOLD_BUCKET).maxCount(1)), "gold_lava_bucket_1");
    public static final Item GOLD_LAVA_BUCKET_2 = register(new GoldBucketItem(Fluids.LAVA, GOLD_LAVA_BUCKET_1, 2, new Item.Settings().recipeRemainder(GOLD_LAVA_BUCKET_1).maxCount(1)), "gold_lava_bucket_2");
    public static final Item GOLD_LAVA_BUCKET_3 = register(new GoldBucketItem(Fluids.LAVA, GOLD_LAVA_BUCKET_2, 3, new Item.Settings().recipeRemainder(GOLD_LAVA_BUCKET_2).maxCount(1)), "gold_lava_bucket_3");
    public static final Item GOLD_MILK_BUCKET_1 = register((new Item.Settings()).recipeRemainder(GOLD_BUCKET).component(DataComponentTypes.CONSUMABLE, ConsumableComponents.MILK_BUCKET).useRemainder(GOLD_BUCKET).maxCount(1), "gold_milk_bucket_1");
    public static final Item GOLD_MILK_BUCKET_2 = register((new Item.Settings()).recipeRemainder(GOLD_MILK_BUCKET_1).component(DataComponentTypes.CONSUMABLE, ConsumableComponents.MILK_BUCKET).useRemainder(GOLD_MILK_BUCKET_1).maxCount(1), "gold_milk_bucket_2");
    public static final Item GOLD_MILK_BUCKET_3 = register((new Item.Settings()).recipeRemainder(GOLD_MILK_BUCKET_2).component(DataComponentTypes.CONSUMABLE, ConsumableComponents.MILK_BUCKET).useRemainder(GOLD_MILK_BUCKET_2).maxCount(1), "gold_milk_bucket_3");
    public static final Item GOLD_POWDER_SNOW_BUCKET_1 = register(new GoldPowderSnowBucketItem(GOLD_BUCKET, 1, Blocks.POWDER_SNOW, SoundEvents.ITEM_BUCKET_EMPTY_POWDER_SNOW, new Item.Settings().maxCount(1)), "gold_powder_snow_bucket_1");
    public static final Item GOLD_POWDER_SNOW_BUCKET_2 = register(new GoldPowderSnowBucketItem(GOLD_POWDER_SNOW_BUCKET_1, 2, Blocks.POWDER_SNOW, SoundEvents.ITEM_BUCKET_EMPTY_POWDER_SNOW, new Item.Settings().maxCount(1)), "gold_powder_snow_bucket_2");
    public static final Item GOLD_POWDER_SNOW_BUCKET_3 = register(new GoldPowderSnowBucketItem(GOLD_POWDER_SNOW_BUCKET_2, 3, Blocks.POWDER_SNOW, SoundEvents.ITEM_BUCKET_EMPTY_POWDER_SNOW, new Item.Settings().maxCount(1)), "gold_powder_snow_bucket_3");
    public static final Item GOLD_FIRE_STARTER = register(new FlintAndSteelItem(new Item.Settings().maxDamage(128)), "gold_fire_starter");
    public static final Item GOLD_SHIELD = register(new FabricBannerShieldItem(new Item.Settings().maxDamage(400), 10, 13, Items.GOLD_INGOT), "gold_shield");

    public static final Item IRON_BRUSH = register(new BrushItem(new Item.Settings().maxDamage(100)) {
       public int getBrushes() {
            return 8;
       }
    }, "iron_brush");
    public static final Item GOLD_BRUSH = register(new BrushItem(new Item.Settings().maxDamage(150)) {
        public int getBrushes() {
            return 5;
        }
    }, "gold_brush");

    public static final net.minecraft.item.equipment.ArmorMaterial COPPER_ARMOR = new net.minecraft.item.equipment.ArmorMaterial(15, (Map)Util.make(new EnumMap(EquipmentType.class), (map) -> {
        map.put(EquipmentType.BOOTS, 2);
        map.put(EquipmentType.LEGGINGS, 4);
        map.put(EquipmentType.CHESTPLATE, 5);
        map.put(EquipmentType.HELMET, 2);
        map.put(EquipmentType.BODY, 5);
    }), 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, ItemTags.REPAIRS_IRON_ARMOR, EquipmentAssetKeys.IRON);

    RegistryKey<EquipmentAsset> COPPER_EQUIPMENT_ASSET = registerEquipmentAssetKey("copper");
    public static final Item COPPER_HORSE_ARMOR = register(new AnimalArmorItem(COPPER_ARMOR, AnimalArmorItem.Type.EQUESTRIAN, SoundEvents.ENTITY_HORSE_ARMOR, false, new Item.Settings().maxCount(1)), "copper_horse_armor");

    public static final RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(PucksParityMod.MOD_ID, "item_group"));
    public static final ItemGroup CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(PucksParityModBlocks.BLUE_TERRACOTTA_BRICKS))
            .displayName(Text.translatable("itemGroup.parity_stones"))
            .build();
}
