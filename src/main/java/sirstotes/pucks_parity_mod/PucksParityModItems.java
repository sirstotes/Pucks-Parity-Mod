package sirstotes.pucks_parity_mod;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricBannerShieldItem;
import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShieldItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.FluidDrainable;
import net.minecraft.block.dispenser.DispenserBehavior;
import net.minecraft.block.dispenser.ItemDispenserBehavior;
import net.minecraft.block.dispenser.ShearsDispenserBehavior;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.BannerPatternsComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;
import sirstotes.pucks_parity_mod.accessors.FluidDrainableMixinAccessor;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class PucksParityModItems {
    public static void initialize() {
        FuelRegistry.INSTANCE.add(COPPER_LAVA_BUCKET, 20000);
        FuelRegistry.INSTANCE.add(GOLD_LAVA_BUCKET_1, 20000);
        FuelRegistry.INSTANCE.add(GOLD_LAVA_BUCKET_2, 20000);
        FuelRegistry.INSTANCE.add(GOLD_LAVA_BUCKET_3, 20000);

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
    }
    public static Item register(Item item, String id) {
		// Create the identifier for the item.
		Identifier itemID = Identifier.of(PucksParityMod.MOD_ID, id);

		// Register the item.
		Item registeredItem = Registry.register(Registries.ITEM, itemID, item);

		// Return the registered item!
		return registeredItem;
	}
    public static final Item COPPER_NUGGET = register(new Item(new Item.Settings()), "copper_nugget");
    public static final TagKey<Item> SHEARS = TagKey.of(RegistryKeys.ITEM, Identifier.of("c", "tools/shear"));
    public static final TagKey<Item> BUCKETS = TagKey.of(RegistryKeys.ITEM, Identifier.of("c", "tools/bucket"));
    public static final TagKey<Item> SHIELDS = TagKey.of(RegistryKeys.ITEM, Identifier.of("c", "tools/shield"));
    public static final Item COPPER_SHEARS = register(new ShearsItem(new Item.Settings().maxDamage(138).component(DataComponentTypes.TOOL, ShearsItem.createToolComponent())), "copper_shears");
    public static final Item GOLD_SHEARS = register(new ShearsItem(new Item.Settings().maxDamage(200).component(DataComponentTypes.TOOL, ShearsItem.createToolComponent())), "gold_shears");

    public static final Item COPPER_BUCKET = register(new CopperBucketItem(Fluids.EMPTY, new Item.Settings().maxCount(16)), "copper_bucket");
	public static final Item COPPER_WATER_BUCKET = register(new CopperBucketItem(Fluids.WATER, new Item.Settings().recipeRemainder(COPPER_BUCKET).maxCount(1)), "copper_water_bucket");
	public static final Item COPPER_LAVA_BUCKET = register(new CopperBucketItem(Fluids.LAVA, new Item.Settings()), "copper_lava_bucket");
    public static final Item COPPER_MILK_BUCKET = register(new CopperMilkBucketItem(new Item.Settings().recipeRemainder(COPPER_BUCKET).maxCount(1)), "copper_milk_bucket");
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
    public static final Item GOLD_MILK_BUCKET_1 = register(new GoldMilkBucketItem(GOLD_BUCKET, 1, new Item.Settings().recipeRemainder(GOLD_BUCKET).maxCount(1)), "gold_milk_bucket_1");
    public static final Item GOLD_MILK_BUCKET_2 = register(new GoldMilkBucketItem(GOLD_MILK_BUCKET_1, 2, new Item.Settings().recipeRemainder(GOLD_MILK_BUCKET_1).maxCount(1)), "gold_milk_bucket_2");
    public static final Item GOLD_MILK_BUCKET_3 = register(new GoldMilkBucketItem(GOLD_MILK_BUCKET_2, 3, new Item.Settings().recipeRemainder(GOLD_MILK_BUCKET_2).maxCount(1)), "gold_milk_bucket_3");
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

    public static final RegistryEntry<ArmorMaterial> COPPER_ARMOR = registerArmor("copper", Util.make(new EnumMap(ArmorItem.Type.class), map -> {
        map.put(ArmorItem.Type.BOOTS, 2);
        map.put(ArmorItem.Type.LEGGINGS, 4);
        map.put(ArmorItem.Type.CHESTPLATE, 5);
        map.put(ArmorItem.Type.HELMET, 2);
        map.put(ArmorItem.Type.BODY, 5);
    }), 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.ofItems(Items.COPPER_INGOT));

    public static final Item COPPER_HORSE_ARMOR = register(new AnimalArmorItem(COPPER_ARMOR, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)), "copper_horse_armor");

    private static RegistryEntry<ArmorMaterial> registerArmor(
            String id,
            EnumMap<ArmorItem.Type, Integer> defense,
            int enchantability,
            RegistryEntry<SoundEvent> equipSound,
            float toughness,
            float knockbackResistance,
            Supplier<Ingredient> repairIngredient
    ) {
        List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(Identifier.of("pucks_parity_mod", id)));
        return registerArmor(id, defense, enchantability, equipSound, toughness, knockbackResistance, repairIngredient, list);
    }
    private static RegistryEntry<ArmorMaterial> registerArmor(
            String id,
            EnumMap<ArmorItem.Type, Integer> defense,
            int enchantability,
            RegistryEntry<SoundEvent> equipSound,
            float toughness,
            float knockbackResistance,
            Supplier<Ingredient> repairIngredient,
            List<ArmorMaterial.Layer> layers
    ) {
        EnumMap<ArmorItem.Type, Integer> enumMap = new EnumMap(ArmorItem.Type.class);

        for (ArmorItem.Type type : ArmorItem.Type.values()) {
            enumMap.put(type, (Integer)defense.get(type));
        }

        return Registry.registerReference(
                Registries.ARMOR_MATERIAL,
                Identifier.of("pucks_parity_mod", id),
                new ArmorMaterial(enumMap, enchantability, equipSound, repairIngredient, layers, toughness, knockbackResistance)
        );
    }
}
