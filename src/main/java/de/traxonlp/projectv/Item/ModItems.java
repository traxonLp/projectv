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
    public static final Item KNIFE = registerItem("knife");
    public static final Item LEATHER_SUBSTITUTE = registerItem("leather_substitute");
    public static final Item TOFU = registerItem("tofu");
    public static final Item SOY_BEANS = registerItem("soy_beans");
    public static final Item SOY_MILK = registerItem("soy_milk");
    public static final Item SMOKED_TOFU = registerItem("smoked_tofu");
    public static final Item MINCED_TOFU = registerItem("minced_tofu");
    public static final Item SMOKED_MINCED_TOFU = registerItem("smoked_minced_tofu");


    //Components
    public static final FoodComponent TOFU_FOOD_COMPONENT = new FoodComponent.Builder()
            .alwaysEdible()
            .build();
    public static final FoodComponent SOY_BEANS_FOOD_COMPONENT = new FoodComponent.Builder()
            .alwaysEdible()
            .build();
    public static final FoodComponent SOY_MILK_FOOD_COMPONENT = new FoodComponent.Builder()
            .alwaysEdible()
            .build();
    public static final FoodComponent SMOKED_TOFU_FOOD_COMPONENT = new FoodComponent.Builder()
            .alwaysEdible()
            .build();
    public static final FoodComponent MINCED_TOFU_FOOD_COMPONENT = new FoodComponent.Builder()
            .alwaysEdible()
            .build();
    public static final FoodComponent SMOKED_MINCED_TOFU_FOOD_COMPONENT = new FoodComponent.Builder()
            .alwaysEdible()
            .build();

    //Item Registry
    private static Item registerItem(String name) {
        Identifier identifier = Identifier.of(Main.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, identifier);

        Item.Settings settings = new Item.Settings().registryKey(key)
                        .rarity(Rarity.COMMON);


        switch (name) {
            case "leather_substitute" -> {
                return Registry.register(Registries.ITEM, key, new LeatherSubstituteItem(settings));
            }
            case "tofu" -> {
                settings = settings.food(TOFU_FOOD_COMPONENT);
                return Registry.register(Registries.ITEM, key, new TofuItem(settings));
            }
            case "soy_beans" -> {
                settings = settings.food(SOY_BEANS_FOOD_COMPONENT);
                return Registry.register(Registries.ITEM, key, new SoyBeansItem(settings));
            }
            case "soy_milk" -> {
                settings = settings.food(SOY_MILK_FOOD_COMPONENT);
                return Registry.register(Registries.ITEM, key, new SoyMilkItem(settings));
            }
            case "smoked_tofu" -> {
                settings = settings.food(SMOKED_TOFU_FOOD_COMPONENT);
                return Registry.register(Registries.ITEM, key, new SmokedTofuItem(settings));
            }
            case "smoked_minced_tofu" -> {
                settings = settings.food(SMOKED_MINCED_TOFU_FOOD_COMPONENT);
                return Registry.register(Registries.ITEM, key, new SmokedMincedTofuItem(settings));
            }
            case "minced_tofu" -> {
                settings = settings.food(MINCED_TOFU_FOOD_COMPONENT);
                return Registry.register(Registries.ITEM, key, new MincedTofuItem(settings));
            }
            case "knife" -> {
                return Registry.register(Registries.ITEM, key, new KnifeItem(settings));
            }
        }
        return Registry.register(Registries.ITEM, key, new Item(settings));
    }


    private static void itemGroupIngedients(FabricItemGroupEntries entries) {
        entries.add(KNIFE);
        entries.add(LEATHER_SUBSTITUTE);
        entries.add(TOFU);
        entries.add(SOY_BEANS);
        entries.add(SOY_MILK);
        entries.add(SMOKED_TOFU);
        entries.add(MINCED_TOFU);
        entries.add(SMOKED_MINCED_TOFU);
    }

    public static void registerModItems() {
        Main.LOGGER.info("Registering Mod Items for " + Main.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent
                (ItemGroups.FOOD_AND_DRINK).register(ModItems::itemGroupIngedients);
    }
}
