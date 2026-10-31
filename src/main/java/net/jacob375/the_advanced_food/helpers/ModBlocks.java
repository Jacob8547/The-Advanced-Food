package net.jacob375.the_advanced_food.helpers;

import java.util.function.Function;
import java.util.function.Supplier;

import net.jacob375.the_advanced_food.TheAdvancedFood;
import net.jacob375.the_advanced_food.custom.blocks.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.sounds.AmbientLeavesBlockSoundPlayer;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {

	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(TheAdvancedFood.MOD_ID);

	// Registers the block, and optionally a matching BlockItem (added to
	// ModItems.ITEMS)
	private static <B extends Block> DeferredBlock<B> register(String name,
			Function<BlockBehaviour.Properties, B> blockFactory,
			Supplier<BlockBehaviour.Properties> settings, boolean shouldRegisterItem) {
		DeferredBlock<B> block = BLOCKS.registerBlock(name, blockFactory, settings);

		if (shouldRegisterItem) {
			ModItems.ITEMS.registerItem(name,
					props -> new BlockItem(block.get(), props.useBlockDescriptionPrefix()),
					Item.Properties::new);
		}

		return block;
	}

	// BLOCKS
	public static final DeferredBlock<Block> PEANUT_BLOCK = register("peanut_block", Block::new,
			() -> BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT), true);

	public static final DeferredBlock<CORN_CROP> CORN_CROP = register("corn_crop", CORN_CROP::new,
			() -> BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).noCollision().randomTicks().instabreak()
					.sound(SoundType.CROP).noOcclusion(),
			false);

	public static final DeferredBlock<ORANGE_LEAVES> ORANGE_LEAVES = register("orange_leaves",
			properties -> new ORANGE_LEAVES(AmbientLeavesBlockSoundPlayer.noAmbientSound(), properties),
			() -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).noOcclusion(), true);

	public static void register(IEventBus modEventBus) {
		BLOCKS.register(modEventBus);
	}
}