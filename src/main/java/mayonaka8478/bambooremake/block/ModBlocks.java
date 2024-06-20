package mayonaka8478.bambooremake.block;

import mayonaka8478.bambooremake.BambooRemake;
import mayonaka8478.bambooremake.IDUtils;
import mayonaka8478.bambooremake.item.ItemBlockSlabTatami;
import net.minecraft.client.render.block.model.BlockModelAxisAligned;
import net.minecraft.client.render.block.model.BlockModelCrossedSquares;
import net.minecraft.client.render.block.model.BlockModelSlab;
import net.minecraft.client.render.block.model.BlockModelStairs;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockAxisAligned;
import net.minecraft.core.block.BlockSlab;
import net.minecraft.core.block.BlockStairs;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.item.block.ItemBlockSlab;
import net.minecraft.core.sound.BlockSounds;
import net.minecraft.core.world.Dimension;
import net.minecraft.core.world.World;
import org.useless.dragonfly.model.block.DFBlockModelBuilder;
import turniplabs.halplibe.helper.BlockBuilder;

import java.util.Random;

public class ModBlocks {

	//tatami
	public static final Block tatami = new BlockBuilder(BambooRemake.MOD_ID)
		.setResistance(5.0f)
		.setHardness(0.1f)
		.setBlockSound(BlockSounds.GRASS)
		.setBlockModel(block -> {
			return new BlockModelAxisAligned<>(block).withTextures("bambooremake:block/tatami_top", "bambooremake:block/tatami");
		})
		.setTicking(true)
		.build(new BlockAxisAligned("tatami", IDUtils.getCurrBlockId(), Material.grass) {
			public void updateTick(World world, int x, int y, int z, Random rand) {
				if (rand.nextInt(5) == 0) {
					if (world.dimension == Dimension.nether) {
						world.setBlockAndMetadataWithNotify(x, y, z, ModBlocks.tatami_suntan.id, world.getBlockMetadata(x, y, z));
					}
				}
			}
		});
	//slab_tatami
	public static final Block slab_tatami = new BlockBuilder(BambooRemake.MOD_ID)
		.setResistance(5.0f)
		.setHardness(0.1f)
		.setUseInternalLight()
		.setVisualUpdateOnMetadata()
		.setBlockSound(BlockSounds.GRASS)
		.setItemBlock(ItemBlockSlabTatami::new)
		.setBlockModel(block -> new DFBlockModelBuilder(BambooRemake.MOD_ID)
			.setBlockModel("block/slab_tatami.json")
			.setBlockState("slab_tatami.json")
			.setMetaStateInterpreter(new SlabTatamiMetaStateInterpreter())
			.setRender3D(true)
			.build(block))
		.setTicking(true)
		.build(new SlabTatami(tatami, IDUtils.getCurrBlockId()) {
			public void updateTick(World world, int x, int y, int z, Random rand) {
				if (rand.nextInt(5) == 0) {
					if (world.dimension == Dimension.nether) {
						world.setBlockAndMetadataWithNotify(x, y, z, ModBlocks.slab_tatami_suntan.id, world.getBlockMetadata(x, y, z));
					}
				}
			}
		});
	//stairs_tatami
	public static final Block stairs_tatami = new BlockBuilder(BambooRemake.MOD_ID)
		.setResistance(5.0f)
		.setHardness(0.1f)
		.setUseInternalLight()
		.setVisualUpdateOnMetadata()
		.setBlockSound(BlockSounds.GRASS)
		.setBlockModel(block -> new DFBlockModelBuilder(BambooRemake.MOD_ID)
			.setBlockModel("block/stairs_tatami.json")
			.setBlockState("stairs_tatami.json")
			.setMetaStateInterpreter(new StairsTatamiMetaStateInterpreter())
			.setRender3D(true)
			.build(block))
		.setTicking(true)
		.build(new BlockStairs(tatami, IDUtils.getCurrBlockId()) {
			public void updateTick(World world, int x, int y, int z, Random rand) {
				if (rand.nextInt(5) == 0) {
					if (world.dimension == Dimension.nether) {
						world.setBlockAndMetadataWithNotify(x, y, z, ModBlocks.stairs_tatami_suntan.id, world.getBlockMetadata(x, y, z));
					}
				}
			}
		});
	//tatami_suntan
	public static final Block tatami_suntan = new BlockBuilder(BambooRemake.MOD_ID)
		.setResistance(5.0f)
		.setHardness(0.1f)
		.setBlockSound(BlockSounds.GRASS)
		.setBlockModel(block -> {
			return new BlockModelAxisAligned<>(block).withTextures("bambooremake:block/tatami_suntan_top", "bambooremake:block/tatami_suntan");
		})
		.build(new BlockAxisAligned("tatami_suntan", IDUtils.getCurrBlockId(), Material.grass));
	//slab_tatami_suntan
	public static final Block slab_tatami_suntan = new BlockBuilder(BambooRemake.MOD_ID)
		.setResistance(5.0f)
		.setHardness(0.1f)
		.setUseInternalLight()
		.setVisualUpdateOnMetadata()
		.setBlockSound(BlockSounds.GRASS)
		.setItemBlock(ItemBlockSlabTatami::new)
		.setBlockModel(block -> new DFBlockModelBuilder(BambooRemake.MOD_ID)
			.setBlockModel("block/slab_tatami_suntan.json")
			.setBlockState("slab_tatami_suntan.json")
			.setMetaStateInterpreter(new SlabTatamiMetaStateInterpreter())
			.setRender3D(true)
			.build(block))
		.build(new SlabTatami(tatami_suntan, IDUtils.getCurrBlockId()));
	//stairs_tatami_suntan
	public static final Block stairs_tatami_suntan = new BlockBuilder(BambooRemake.MOD_ID)
		.setResistance(5.0f)
		.setHardness(0.1f)
		.setUseInternalLight()
		.setVisualUpdateOnMetadata()
		.setBlockSound(BlockSounds.GRASS)
		.setBlockModel(block -> new DFBlockModelBuilder(BambooRemake.MOD_ID)
			.setBlockModel("block/stairs_tatami_suntan.json")
			.setBlockState("stairs_tatami_suntan.json")
			.setMetaStateInterpreter(new StairsTatamiMetaStateInterpreter())
			.setRender3D(true)
			.build(block))
		.build(new BlockStairs(tatami_suntan, IDUtils.getCurrBlockId()));
	//bamboo_works
	public static final Block bamboo_works = new BlockBuilder(BambooRemake.MOD_ID)
		.setResistance(3.0f)
		.setHardness(2.0f)
		.setBlockSound(BlockSounds.WOOD)
		.setFlammability(5, 20)
		.setTags(BlockTags.MINEABLE_BY_AXE, BlockTags.FENCES_CONNECT)
		.setTextures("bambooremake:block/bamboo_works")
		.build(new Block("bamboo_works", IDUtils.getCurrBlockId(), Material.wood));
	//slab_bamboo_works
	public static final Block slab_bamboo_works = new BlockBuilder(BambooRemake.MOD_ID)
		.setResistance(3.0f)
		.setHardness(2.0f)
		.setUseInternalLight()
		.setVisualUpdateOnMetadata()
		.setItemBlock(ItemBlockSlab::new)
		.setBlockModel(BlockModelSlab::new)
		.setBlockSound(BlockSounds.WOOD)
		.setFlammability(5, 20)
		.setTags(BlockTags.MINEABLE_BY_AXE)
		.setTextures("bambooremake:block/bamboo_works")
		.build(new BlockSlab(bamboo_works, IDUtils.getCurrBlockId()));
	//stairs_bamboo_works
	public static final Block stairs_bamboo_works = new BlockBuilder(BambooRemake.MOD_ID)
		.setResistance(3.0f)
		.setHardness(2.0f)
		.setUseInternalLight()
		.setVisualUpdateOnMetadata()
		.setBlockModel(BlockModelStairs::new)
		.setBlockSound(BlockSounds.WOOD)
		.setFlammability(5, 20)
		.setTags(BlockTags.MINEABLE_BY_AXE)
		.setTextures("bambooremake:block/bamboo_works")
		.build(new BlockStairs(bamboo_works, IDUtils.getCurrBlockId()));
	//bamboo_shoot
	public static final Block bamboo_shoot = new BlockBuilder(BambooRemake.MOD_ID)
		.setResistance(3.0f)
		.setHardness(0.0f)
		.setBlockSound(BlockSounds.STONE)
		.setBlockModel(block -> new BlockModelCrossedSquares<>(block).withTextures("bambooremake:block/bamboo_shoot"))
		.setTags(BlockTags.MINEABLE_BY_HOE)
		.setIcon("bambooremake:item/bamboo_shoot")
		.build(new BambooShoot("bamboo_shoot", IDUtils.getCurrBlockId()));
	//bamboo
	public static final Block bamboo = new BlockBuilder(BambooRemake.MOD_ID)
		.setResistance(3.0f)
		.setHardness(0.0f)
		.setBlockSound(BlockSounds.STONE)
		.setBlockModel(block -> new BlockModelBamboo<>(block).withTextures("bambooremake:block/bamboo"))
		.build(new Bamboo("bamboo", IDUtils.getCurrBlockId()));
	//bamboo_cut
	public static final Block bamboo_cut = new BlockBuilder(BambooRemake.MOD_ID)
		.setResistance(3.0f)
		.setHardness(0.0f)
		.setBlockSound(BlockSounds.STONE)
		.setIcon("bambooremake:block/bamboo")
		.setBlockModel(block -> new DFBlockModelBuilder(BambooRemake.MOD_ID)
			.setBlockModel("block/bamboo_cut.json")
			.setBlockState("bamboo_cut.json")
			.setMetaStateInterpreter(new BambooCutMetaStateInterpreter())
			.setRender3D(false)
			.build(block))
		.build(new BambooCut("bamboo_cut", IDUtils.getCurrBlockId()));

	public static void createBlocks() {
	}
}
