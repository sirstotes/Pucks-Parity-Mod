package sirstotes.pucks_parity_mod;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class PucksParityModItems {
    public static Item register(Item.Settings settings, String name) {
        Identifier id = Identifier.of(PucksParityMod.MOD_ID, name);
        return Registry.register(Registries.ITEM, name, new Item(settings
                //?if >1.21.1
                .registryKey(RegistryKey.of(RegistryKeys.ITEM, id))
        ));
    }
    public static final Item COPPER_NUGGET = register(new Item.Settings(), "copper_nugget");

    public static final RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(PucksParityMod.MOD_ID, "item_group"));
    public static final ItemGroup CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(PucksParityModBlocks.BLUE_TERRACOTTA_BRICKS))
            .displayName(Text.translatable("itemGroup.parity_stones"))
            .build();
}
