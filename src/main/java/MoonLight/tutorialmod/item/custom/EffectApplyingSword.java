package MoonLight.tutorialmod.item.custom;

import MoonLight.tutorialmod.damage.DamageSources;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.state.BlockState;

public class EffectApplyingSword extends SwordItem {
    public EffectApplyingSword(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide()) {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,1000000000,1000000000,false,false,false));
        }

        pContext.getItemInHand().hurtAndBreak(0, pContext.getPlayer(),
                player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return InteractionResult.SUCCESS;
    }

    @Override
    public boolean hurtEnemy(ItemStack itemstack, LivingEntity attackedEntity, LivingEntity attacker) {
        attackedEntity.addEffect(new MobEffectInstance(MobEffects.GLOWING,10,1000000000,false,false,false));
        return super.hurtEnemy(itemstack, attackedEntity, attacker);

    }
}
