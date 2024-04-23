package MoonLight.tutorialmod.damage;

import MoonLight.tutorialmod.TutorialMod;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class DamageSources {

    public static final ResourceKey<DamageType> Custom_Damage = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(TutorialMod.MOD_ID, "custom_damage"));

    public static DamageSource customDamage(LivingEntity source) {
        RegistryAccess registry = source.level().registryAccess();
        Registry<DamageType> types = registry.registryOrThrow(Registries.DAMAGE_TYPE);
        return new DamageSource(types.getHolderOrThrow(Custom_Damage), source);
    }

}
