package MoonLight.tutorialmod.util;

import MoonLight.tutorialmod.damage.DamageSources;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.LivingEntity;

public class DamageUtil {
    public static boolean isBlockable(LivingEntity target, DamageSource source) {
        if (source.is(DamageTypeTags.BYPASSES_INVULNERABILITY) || source.is(DamageTypes.STARVE) || source.is(DamageSources.Custom_Damage)) return false;
        return source.getEntity() != target;
    }

    public static boolean isMelee(DamageSource source) {
        return !source.isIndirect() && (source.is(DamageTypes.MOB_ATTACK) || source.is(DamageTypes.PLAYER_ATTACK) || source.is(DamageSources.Custom_Damage));
    }

}