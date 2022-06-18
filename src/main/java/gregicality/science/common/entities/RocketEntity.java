package gregicality.science.common.entities;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RocketEntity extends Entity {

    protected boolean launched;
    protected boolean countdownStarted;

    protected int age;
    protected int launchTime;
    protected int flightTime;

    protected double startPos;
    /**
     * Jerk is the third derivative of position, the second derivative of velocity, the first derivative of acceleration
     */
    protected static final float jerk = 0.0001F;

    public RocketEntity(World worldIn) {
        super(worldIn);
        this.setSize(3F, 31F);
        rideCooldown = -1;
        ignoreFrustumCheck = true;
        launched = false;
        countdownStarted = false;
        age = 0;
        flightTime = 0;
        this.startCountdown(200); //Automatically launches after 10 seconds if summoned for debug
    }

    public RocketEntity(World worldIn, double x, double y, double z) {
        super(worldIn);
        this.setLocationAndAngles(x, y, z, this.rotationYaw, 180.0F);
        this.setSize(3F, 31F);
        rideCooldown = -1;
        ignoreFrustumCheck = true;
        launched = false;
        countdownStarted = false;
        age = 0;
        flightTime = 0;
    }

    protected void entityInit(){}

    @Override
    protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos){}

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        this.launched = compound.getBoolean("Launched");
        this.countdownStarted = compound.getBoolean("CountdownStarted");
        this.age = compound.getInteger("Age");
        this.launchTime = compound.getInteger("LaunchTime");
        this.flightTime = compound.getInteger("FlightTime");
        this.startPos = compound.getDouble("StartPos");
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        compound.setBoolean("Launched", this.launched);
        compound.setBoolean("CoutdownStarted", this.countdownStarted);
        compound.setInteger("Age", this.age);
        compound.setInteger("LaunchTime", this.launchTime);
        compound.setInteger("FlightTime", this.flightTime);
        compound.setDouble("StartPos", this.startPos);
    }

    @Override
    public void onUpdate()
    {
        if (!this.world.isRemote) {
            this.setFlag(6, this.isGlowing());
        }

        this.setRotation(0.0F, 90.0F);

        if(countdownStarted && !launched) {
            if(age >= launchTime){
                this.Launch();
            }
        }

        if(launched) {
            this.setPosition(this.posX, this.startPos + jerk * Math.pow(flightTime, 3)/ 6.F,this.posZ);
            flightTime++;
            if(this.posY > 300 || flightTime > 1200) {
                this.setDead();
            }
        }

        age++;

        super.onUpdate();
    }

    public void startCountdown(int time) {
        countdownStarted = true;
        launchTime = age + time;
    }

    public void Launch(){
        launched = true;
        this.startPos = this.posY;
    }

    public boolean isCountdownStarted() {
        return countdownStarted;
    }

    public boolean isLaunched() {
        return launched;
    }
}
