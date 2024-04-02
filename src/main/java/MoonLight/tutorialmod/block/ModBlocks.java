package MoonLight.tutorialmod.block;

import MoonLight.tutorialmod.TutorialMod;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import javax.annotation.Nullable;

public class ModBlocks {
    private static boolean always(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return false;
    }

    private static boolean never(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return false;
    }

    private static Boolean never(BlockState pState, BlockGetter pLevel, BlockPos pPos, EntityType<?> pType) {
        return false;
    }

    @Nullable
    public static <E extends BlockEntity, A extends BlockEntity> BlockEntityTicker<A> createTickerHelper(BlockEntityType<A> pServerType, BlockEntityType<E> pClientType, BlockEntityTicker<? super E> pTicker) {
        return pClientType == pServerType ? (BlockEntityTicker<A>) pTicker : null;
    }

    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(BuiltInRegistries.BLOCK, TutorialMod.MOD_ID);

    public static final DeferredHolder<Block, Block> USELESS_BLOCK = BLOCKS.register("useless_block", () -> new MagmaBlock(BlockBehaviour.Properties.of()
            .instrument(NoteBlockInstrument.BASEDRUM)
            .requiresCorrectToolForDrops()));

    public static final DeferredHolder<Block, Block> UGLY_BLOCK = BLOCKS.register("ugly_block", () -> new MagmaBlock(BlockBehaviour.Properties.of()
            .instrument(NoteBlockInstrument.CREEPER)
            .requiresCorrectToolForDrops()));
}
