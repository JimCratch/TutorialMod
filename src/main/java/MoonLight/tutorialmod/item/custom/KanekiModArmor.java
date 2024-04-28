package MoonLight.tutorialmod.item.custom;

import MoonLight.tutorialmod.item.KanekiMaskMaterials;
import MoonLight.tutorialmod.item.ModArmorMaterials;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.extensions.IItemExtension;


public class KanekiModArmor extends ArmorItem implements IItemExtension {
    public KanekiModArmor(Type pType, Properties pProperties) {
        super(KanekiMaskMaterials.KANEKI, pType, pProperties);
    }
}