package net.jacob375.the_advanced_food;

import java.util.function.Function;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.jacob375.the_advanced_food.custom.blocks.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.sounds.AmbientLeavesBlockSoundPlayer;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ModBlocks implements ModInitializer {
	private static Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory,
			BlockBehaviour.Properties settings, boolean shouldRegisterItem) {
		ResourceKey<Block> blockKey = keyOfBlock(name);

		Block block = blockFactory.apply(settings.setId(blockKey));

		if (shouldRegisterItem) {
			ResourceKey<Item> itemKey = keyOfItem(name);

			BlockItem blockItem = new BlockItem(block,
					new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
			Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
		}

		return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
	}

	private static ResourceKey<Block> keyOfBlock(String name) {
		return ResourceKey.create(Registries.BLOCK,
				Identifier.fromNamespaceAndPath(TheAdvancedFood.MOD_ID, name));
	}

	private static ResourceKey<Item> keyOfItem(String name) {
		return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TheAdvancedFood.MOD_ID, name));
	}

	public static void initialize() {
	}

	@Override
	public void onInitialize() {
		ModBlocks.initialize();
	}

	// BLOCKS
	public static final Block PEANUT_BLOCK = ModBlocks.register("peanut_block", Block::new,
			BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT), true);

	public static final Block CORN_CROP = ModBlocks.register("corn_crop", CORN_CROP::new, BlockBehaviour.Properties
			.ofFullCopy(Blocks.WHEAT).noCollision().randomTicks().instabreak().sound(SoundType.CROP).noOcclusion(), false);

	public static final Block ORANGE_LEAVES = ModBlocks.register("orange_leaves",
			(properties) -> new ORANGE_LEAVES(AmbientLeavesBlockSoundPlayer.noAmbientSound(), properties),
			BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).noOcclusion(), true);

	public ModBlocks() {
		final Block[] items = { PEANUT_BLOCK, ORANGE_LEAVES };

		CreativeModeTabEvents.modifyOutputEvent(TheAdvancedFood.CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
			for (var block : items) {
				itemGroup.accept(block);
			}
		});
	}
}
