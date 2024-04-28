package MoonLight.tutorialmod.item.custom;

import MoonLight.tutorialmod.util.ModTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;

import java.util.function.Predicate;

public class CustomBowItem extends BowItem {
    public CustomBowItem(Properties pProperties) {
        super(pProperties);

    }

    public static final Predicate<ItemStack> BULLET_ARROW = (p_43017_) -> {
        return p_43017_.is(ModTags.Items.BULLETS_ITEM);
    };

    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return BULLET_ARROW;
    }
}
