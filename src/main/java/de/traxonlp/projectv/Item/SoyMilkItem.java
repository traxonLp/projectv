package de.traxonlp.projectv.Item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.consume.UseAction;
import net.minecraft.stat.Stats;
import net.minecraft.world.World;

public class SoyMilkItem extends Item {
    public SoyMilkItem(Settings settings) {
        super(settings);
    }

    public static final FoodComponent SOY_MILK_FOOD_COMPONENT = new FoodComponent.Builder()
            .alwaysEdible()   // jederzeit konsumierbar
            .build();
            

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof PlayerEntity player) {
            if (!world.isClient) {
                player.clearStatusEffects(); // Entfernt alle Effekte wie Milch
            }
            player.incrementStat(Stats.USED.getOrCreateStat(this));
        }
        // Optional: leeres Gefäß zurückgeben (wie Eimer)
        return super.finishUsing(stack, world, user);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK; // Trink-Animation
    }
}
