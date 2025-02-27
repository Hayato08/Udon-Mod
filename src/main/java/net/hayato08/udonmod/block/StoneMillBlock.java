package net.hayato08.udonmod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class StoneMillBlock extends Block {
    public StoneMillBlock(Properties properties) {
        super(properties);
    }

    // 見た目用の形状はそのまま（下部＋上部）
    private static final VoxelShape VISUAL_SHAPE = Shapes.or(
            // 下部（床部分）の形状（高さは0～9/16）
            Block.box(3.0D, 0.0D, 15.0D, 13.0D, 9.0D, 16.0D),
            Block.box(2.0D, 0.0D, 14.0D, 14.0D, 9.0D, 15.0D),
            Block.box(1.0D, 0.0D, 13.0D, 15.0D, 9.0D, 14.0D),
            Block.box(0.0D, 0.0D, 3.0D, 16.0D, 9.0D, 13.0D),
            Block.box(1.0D, 0.0D, 2.0D, 15.0D, 9.0D, 3.0D),
            Block.box(2.0D, 0.0D, 1.0D, 14.0D, 9.0D, 2.0D),
            Block.box(3.0D, 0.0D, 0.0D, 13.0D, 9.0D, 1.0D),
            // 上部（見た目上の部分）
            Block.box(3.0D, 9.1D, 4.0D, 13.0D, 15.0D, 12.0D),
            Block.box(4.0D, 9.1D, 3.0D, 12.0D, 15.0D, 4.0D),
            Block.box(5.0D, 9.1D, 2.0D, 11.0D, 15.0D, 3.0D),
            Block.box(7.0D, 11.0D, 0.0D, 9.0D, 15.0D, 2.0D),
            Block.box(2.0D, 9.1D, 5.0D, 3.0D, 15.0D, 11.0D),
            Block.box(13.0D, 9.1D, 5.0D, 14.0D, 15.0D, 11.0D),
            Block.box(4.0D, 9.1D, 12.0D, 12.0D, 15.0D, 13.0D),
            Block.box(5.0D, 9.1D, 11.0D, 11.0D, 15.0D, 12.0D),
            Block.box(5.0D, 9.1D, 13.0D, 11.0D, 15.0D, 14.0D)
    );

    // 衝突判定用の形状は、下部のみ高さを10にする
    private static final VoxelShape COLLISION_SHAPE = Shapes.or(
            Block.box(3.0D, 0.0D, 15.0D, 13.0D, 10.0D, 16.0D),
            Block.box(2.0D, 0.0D, 14.0D, 14.0D, 10.0D, 15.0D),
            Block.box(1.0D, 0.0D, 13.0D, 15.0D, 10.0D, 14.0D),
            Block.box(0.0D, 0.0D, 3.0D, 16.0D, 10.0D, 13.0D),
            Block.box(1.0D, 0.0D, 2.0D, 15.0D, 10.0D, 3.0D),
            Block.box(2.0D, 0.0D, 1.0D, 14.0D, 10.0D, 2.0D),
            Block.box(3.0D, 0.0D, 0.0D, 13.0D, 10.0D, 1.0D),

            Block.box(3.0D, 9.1D, 4.0D, 13.0D, 15.0D, 12.0D),
            Block.box(4.0D, 9.1D, 3.0D, 12.0D, 15.0D, 4.0D),
            Block.box(5.0D, 9.1D, 2.0D, 11.0D, 15.0D, 3.0D),
            Block.box(7.0D, 11.0D, 0.0D, 9.0D, 15.0D, 2.0D),
            Block.box(2.0D, 9.1D, 5.0D, 3.0D, 15.0D, 11.0D),
            Block.box(13.0D, 9.1D, 5.0D, 14.0D, 15.0D, 11.0D),
            Block.box(4.0D, 9.1D, 12.0D, 12.0D, 15.0D, 13.0D),
            Block.box(5.0D, 9.1D, 11.0D, 11.0D, 15.0D, 12.0D),
            Block.box(5.0D, 9.1D, 13.0D, 11.0D, 15.0D, 14.0D)
    );

    // ブロックのアウトライン（レンダリングや選択時）には見た目の形状を使用
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return VISUAL_SHAPE;
    }

    // 実際の衝突判定（プレイヤーとの衝突用）には高さを上げた形状を使用
    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return COLLISION_SHAPE;
    }
}
