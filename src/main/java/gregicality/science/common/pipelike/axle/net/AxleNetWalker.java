package gregicality.science.common.pipelike.axle.net;

import gregicality.science.api.capability.EnumRotation;
import gregicality.science.common.pipelike.axle.tile.TileEntityAxlePipe;
import gregtech.api.pipenet.PipeNetWalker;
import gregtech.api.pipenet.tile.IPipeTile;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class AxleNetWalker extends PipeNetWalker {

    public static void checkSpeed(World world, BlockPos start, long speed) {
        AxleNetWalker walker = new AxleNetWalker(world, start, 0);
        walker.speed = speed;
        walker.traversePipeNet();
    }

    public static void checkPower(World world, BlockPos start, int power) {
        AxleNetWalker walker = new AxleNetWalker(world, start, 0);
        walker.power = power;
        walker.traversePipeNet();
    }

    public static void checkRotation(World world, BlockPos start, EnumRotation rotation) {
        AxleNetWalker walker = new AxleNetWalker(world, start, 0);
        walker.rotation = rotation;
        walker.traversePipeNet();
    }

    protected AxleNetWalker(World world, BlockPos sourcePipe, int walkedBlocks) {
        super(world, sourcePipe, walkedBlocks);
    }

    private long speed = -1;
    private int power = -1;
    private EnumRotation rotation = EnumRotation.NONE;

    @Override
    protected PipeNetWalker createSubWalker(World world, BlockPos blockPos, int i) {
        AxleNetWalker walker = new AxleNetWalker(world, blockPos, i);
        walker.speed = speed;
        walker.power = power;
        walker.rotation = rotation;
        return walker;
    }

    @Override
    protected void checkPipe(IPipeTile<?, ?> iPipeTile, BlockPos blockPos) {
        TileEntityAxlePipe pipe = (TileEntityAxlePipe) iPipeTile;
        pipe.checkSpeed(speed);
        pipe.checkPower(power);
        pipe.checkRotation(rotation);
    }

    @Override
    protected void checkNeighbour(IPipeTile<?, ?> iPipeTile, BlockPos blockPos, EnumFacing enumFacing, @Nullable TileEntity tileEntity) {

    }

    @Override
    protected boolean isValidPipe(IPipeTile<?, ?> iPipeTile, IPipeTile<?, ?> iPipeTile1, BlockPos blockPos, EnumFacing enumFacing) {
        return iPipeTile1 instanceof TileEntityAxlePipe;
    }
}
