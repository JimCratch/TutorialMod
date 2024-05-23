package MoonLight.tutorialmod.event;

import MoonLight.tutorialmod.TutorialMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.MovementInputUpdateEvent;
import net.neoforged.neoforge.event.entity.living.LivingEvent.LivingTickEvent;

public class PlayerFlowerWalk {
    /*
    @Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class FlowerEvent {

        @SubscribeEvent(priority = EventPriority.LOWEST)
        public static void FlowerWalk(LivingTickEvent livingtickevent) {
            //MovementInputUpdateEvent
            int BlockX = livingtickevent.getEntity().getBlockX();
            int BlockY = livingtickevent.getEntity().getBlockY();
            int BlockZ = livingtickevent.getEntity().getBlockZ();

            Level world = livingtickevent.getEntity().level();
            BlockPos position = new BlockPos(BlockX,BlockY,BlockZ);
            LivingEntity player = livingtickevent.getEntity();

            if (world.getBlockState(position).getBlock() == Blocks.AIR) {return;}

            world.setBlock(position, Blocks.DANDELION.defaultBlockState(),3);
        }
    }
    */
}
