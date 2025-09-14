package de.traxonlp.projectv.Item;

import de.traxonlp.projectv.Main;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {

    //Registered Items
    public static final Item LEATHER_SUBSTITUTE = registerItem("leather_substitute");
    public static final Item TOFU = registerItem("tofu");
    public static final Item SOY_BEANS = registerItem("soy_beans");
    public static final Item SOY_MILK = registerItem("soy_milk");


    //Components
    public static final FoodComponent SOY_MILK_FOOD_COMPONENT = new FoodComponent.Builder()
            .alwaysEdible()
            .build();

    //Item Registry
    private static Item registerItem(String name) {
        Identifier identifier = Identifier.of(Main.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, identifier);

        Item.Settings settings = new Item.Settings().registryKey(key)
                        .rarity(Rarity.COMMON);
        if (name.equals("leather_substitute")) {
            return Registry.register(Registries.ITEM, key, new LeatherSubstituteItem(settings));
        }
        if (name.equals("tofu")) {
            return Registry.register(Registries.ITEM, key, new TofuItem(settings));
        }
        if (name.equals("soy_beans")) {
            return Registry.register(Registries.ITEM, key, new TofuItem(settings));
        }
        if (name.equals("soy_milk")) {
            settings = settings.food(SOY_MILK_FOOD_COMPONENT);
            return Registry.register(Registries.ITEM, key, new SoyMilkItem(settings));
        }

        return Registry.register(Registries.ITEM, key, new Item(settings));
    }


    private static void itemGroupIngedients(FabricItemGroupEntries entries) {
        entries.add(LEATHER_SUBSTITUTE);
        entries.add(TOFU);
        entries.add(SOY_BEANS);
        entries.add(SOY_MILK);
    }

    public static void registerModItems() {
        Main.LOGGER.info("Registering Mod Items for " + Main.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent
                (ItemGroups.FOOD_AND_DRINK).register(ModItems::itemGroupIngedients);
    }
}
