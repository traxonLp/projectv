package de.traxonlp.projectv.Item;

import de.traxonlp.projectv.Main;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class CreativeTabProjectV {
    public static final RegistryKey<ItemGroup> PROJECTV_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(Main.MOD_ID, "item_group"));
    public static final ItemGroup PROJECTV_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.SOY_BEANS))
            .displayName(Text.translatable("itemGroup.projectv.creativetab"))
            .build();

    public static void registerCreativeTab() {
        Registry.register(Registries.ITEM_GROUP, PROJECTV_ITEM_GROUP_KEY, PROJECTV_ITEM_GROUP);

        ItemGroupEvents.modifyEntriesEvent(PROJECTV_ITEM_GROUP_KEY).register(entries -> {
            entries.add(ModItems.SOY_BEANS);
            entries.add(ModItems.SOY_MILK);
            entries.add(ModItems.TOFU);
            entries.add(ModItems.MINCED_TOFU);
            entries.add(ModItems.SMOKED_TOFU);
            entries.add(ModItems.SMOKED_MINCED_TOFU);
            entries.add(ModItems.LEATHER_SUBSTITUTE);
            entries.add(ModItems.KNIFE);
        });
    }
}
