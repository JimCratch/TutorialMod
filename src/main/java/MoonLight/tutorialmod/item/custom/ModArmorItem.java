package MoonLight.tutorialmod.item.custom;

import MoonLight.tutorialmod.item.ModArmorMaterials;
import net.minecraft.network.protocol.game.ServerboundPlayerAbilitiesPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.extensions.IItemExtension;


public class ModArmorItem extends ArmorItem implements IItemExtension {
    public ModArmorItem(Type pType, Properties pProperties) {
        super(ModArmorMaterials.USELESS, pType, pProperties);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (pEntity instanceof Player player) {
            ItemStack boots = player.getItemBySlot(EquipmentSlot.FEET);
            ItemStack leggings = player.getItemBySlot(EquipmentSlot.LEGS);
            ItemStack chestplate = player.getItemBySlot(EquipmentSlot.CHEST);
            ItemStack helmet = player.getItemBySlot(EquipmentSlot.HEAD);

            if (player.isCreative()) {
                return;
            }

            if (boots.getItem() instanceof ModArmorItem && leggings.getItem() instanceof ModArmorItem && chestplate.getItem() instanceof ModArmorItem && helmet.getItem() instanceof ModArmorItem) {
                player.getAbilities().mayfly = true;
                player.getAbilities().invulnerable = true;
            } else {
                player.getAbilities().mayfly = false; // Turn off flight
                player.getAbilities().invulnerable = false;
                player.getAbilities().flying = false;
            }
        }
    }
}