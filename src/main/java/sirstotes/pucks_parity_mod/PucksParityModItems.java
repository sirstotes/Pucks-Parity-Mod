package sirstotes.pucks_parity_mod;

import net.minecraft.item.*;
//? if <1.20.1 {
/*import net.minecraft.util.registry.Registry;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
*///?} else {
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.registry.Registries;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
//?}
import net.minecraft.util.Identifier;

public class PucksParityModItems {
    public static Item register(Item.Settings settings, String name) {
        Identifier id = Identifier.of(PucksParityMod.MOD_ID, name);
        return Registry.register(/*? if >1.19.2 {*/Registries/*?} else {*//*Registry*//*?}*/.ITEM, id, new Item(settings
                //? if >1.21.1
                .registryKey(RegistryKey.of(RegistryKeys.ITEM, id))
        ));
    }
    //? if >1.19.2 {
    public static final RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(PucksParityMod.MOD_ID, "item_group"));
    public static final ItemGroup CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(PucksParityModBlocks.BLUE_TERRACOTTA_BRICKS))
            .displayName(Text.translatable("itemGroup.parity_stones"))
            .build();
    //?} else {
    /*public static final ItemGroup CUSTOM_ITEM_GROUP = FabricItemGroupBuilder. build(
            new Identifier(PucksParityMod.MOD_ID, "item_group"),
            () -> new ItemStack(PucksParityModBlocks.BLUE_TERRACOTTA_BRICKS));
    *///?}

    public static final Item COPPER_NUGGET = register(new Item.Settings()/*? if <=1.19.2 {*//*.group(CUSTOM_ITEM_GROUP)*//*?}*/, "copper_nugget");
}
