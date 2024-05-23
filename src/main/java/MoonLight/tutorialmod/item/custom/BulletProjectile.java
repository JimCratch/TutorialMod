package MoonLight.tutorialmod.item.custom;

import MoonLight.tutorialmod.item.ModItems;
import com.google.common.collect.Sets;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;

import java.util.Set;

public class BulletProjectile extends AbstractArrow {
    private static final ItemStack DEFAULT_ARROW_STACK;
    protected BulletProjectile(EntityType<? extends AbstractArrow> pEntityType, Level pLevel) {
        super(pEntityType, pLevel, DEFAULT_ARROW_STACK);
    }

    protected BulletProjectile(double pX, double pY, double pZ, Level pLevel, ItemStack pPickupItemStack) {
        super(EntityType.ARROW, pX, pY, pZ, pLevel, pPickupItemStack);
    }

    protected BulletProjectile(LivingEntity pOwner, Level pLevel, ItemStack pPickupItemStack) {
        super(EntityType.ARROW, pOwner, pLevel, pPickupItemStack);
    }

    static {
        DEFAULT_ARROW_STACK = new ItemStack(ModItems.BULLET_ITEM);
    }
}
