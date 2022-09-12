package gregicality.science.common.entities;

import gregicality.science.api.sound.GCYSSounds;
import gregicality.science.client.render.particles.ParticleFlameHuge;
import gregicality.science.client.render.particles.ParticleSmokeHuge;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class RocketEntity extends Entity {

    /**
     * Jerk is the third derivative of position, the second derivative of velocity, the first derivative of acceleration
     */
    protected static final float jerk = 0.0001F;

    private static final DataParameter<Boolean> LAUNCHED = EntityDataManager.<Boolean>createKey(RocketEntity.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> COUNTDOWN_STARTED = EntityDataManager.<Boolean>createKey(RocketEntity.class, DataSerializers.BOOLEAN);

    private static final DataParameter<Integer> AGE = EntityDataManager.<Integer>createKey(RocketEntity.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> LAUNCH_TIME = EntityDataManager.<Integer>createKey(RocketEntity.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> FLIGHT_TIME = EntityDataManager.<Integer>createKey(RocketEntity.class, DataSerializers.VARINT);

    private static final DataParameter<Float> START_POS = EntityDataManager.<Float>createKey(RocketEntity.class, DataSerializers.FLOAT);

    private static final Random rnd = new Random();

    public RocketEntity(World worldIn) {
        super(worldIn);
        this.setSize(3F, 31F);
        rideCooldown = -1;
        ignoreFrustumCheck = true;
    }

    public RocketEntity(World worldIn, double x, double y, double z) {
        super(worldIn);
        this.setLocationAndAngles(x, y, z, this.rotationYaw, 180.0F);
        this.setSize(3F, 31F);
        rideCooldown = -1;
        ignoreFrustumCheck = true;
        this.setEntityBoundingBox(new AxisAlignedBB(x - 1, y + 0.1, z - 1, x + 1, y + 40, z + 1));
    }

    public RocketEntity(World worldIn, BlockPos pos) {
        this(worldIn, (float)pos.getX() + 0.5F, pos.getY(), (float)pos.getZ() + 0.5F);
    }

    protected void entityInit(){
        this.dataManager.register(LAUNCHED, false);
        this.dataManager.register(COUNTDOWN_STARTED, false);
        this.dataManager.register(AGE, 0);
        this.dataManager.register(LAUNCH_TIME, 0);
        this.dataManager.register(FLIGHT_TIME, 0);
        this.dataManager.register(START_POS, 0.F);
    }

    public boolean isLaunched(){
        return this.dataManager.get(LAUNCHED);
    }

    public void setLaunched(boolean launched){
        this.dataManager.set(LAUNCHED, launched);
    }

    public boolean isCountDownStarted(){
        return this.dataManager.get(COUNTDOWN_STARTED);
    }

    public void setCountdownStarted(boolean countdownStarted){
        this.dataManager.set(COUNTDOWN_STARTED, countdownStarted);
    }

    public int getAge(){
        return this.dataManager.get(AGE);
    }

    public void setAge(Integer age){
        this.dataManager.set(AGE, age);
    }

    public int getFlightTime(){
        return this.dataManager.get(FLIGHT_TIME);
    }

    public void setFlightTime(Integer flightTime){
        this.dataManager.set(FLIGHT_TIME, flightTime);
    }

    public int getLaunchTime(){
        return this.dataManager.get(LAUNCH_TIME);
    }

    public void setLaunchTime(Integer launchTime){
        this.dataManager.set(LAUNCH_TIME, launchTime);
    }

    public float getStartPos(){
        return this.dataManager.get(START_POS);
    }

    public void setStartPos(Float startPos){
        this.dataManager.set(START_POS, startPos);
    }

    public void startCountdown(){
        this.setCountdownStarted(true);
        this.setLaunchTime(this.getAge() + 200);
        this.playSound(GCYSSounds.ROCKET_LAUNCH, 0.9F, 1.F);
        this.setStartPos((float)this.posY);
    }

    public void Launch(){
        this.setLaunched(true);
        this.isAirBorne = true;
    }

    @Override
    protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos){}

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        this.setLaunched(compound.getBoolean("Launched"));
        this.setCountdownStarted(compound.getBoolean("CountdownStarted"));
        this.setAge(compound.getInteger("Age"));
        this.setLaunchTime(compound.getInteger("LaunchTime"));
        this.setFlightTime(compound.getInteger("FlightTime"));
        this.setStartPos(compound.getFloat("StartPos"));
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        compound.setBoolean("Launched", this.isLaunched());
        compound.setBoolean("CoutdownStarted", this.isCountDownStarted());
        compound.setInteger("Age", this.getAge());
        compound.setInteger("LaunchTime", this.getLaunchTime());
        compound.setInteger("FlightTime", this.getFlightTime());
        compound.setFloat("StartPos", this.getStartPos());
    }

    protected void spawnFlightParticles(){
        ParticleFlameHuge flame = new ParticleFlameHuge(this.world, this.posX, this.posY, this.posZ, 1.5*(rnd.nextFloat()-0.5)*0.08, -1.5, 1.5*(rnd.nextFloat()-0.5)*0.08);
        ParticleSmokeHuge smoke = new ParticleSmokeHuge(this.world, this.posX, this.posY, this.posZ, 1.5*(rnd.nextFloat()-0.5)*0.16, -1.5, 1.5*(rnd.nextFloat()-0.5)*0.16);
        Minecraft.getMinecraft().effectRenderer.addEffect(smoke);
        Minecraft.getMinecraft().effectRenderer.addEffect(flame);
    }

    protected void spawnLaunchParticles(double v){
        float startPos = this.getStartPos();
        float randFloat = rnd.nextFloat();
        float randSpeed = rnd.nextFloat();
        ParticleSmokeHuge smoke_x1 = new ParticleSmokeHuge(this.world, this.posX, startPos - 3, this.posZ, 0.5 + randSpeed, v*(randFloat-0.5)*0.16, v*(randFloat-0.5)*0.16);
        ParticleSmokeHuge smoke_x2 = new ParticleSmokeHuge(this.world, this.posX, startPos - 3, this.posZ, -(0.5 + randSpeed), v*(randFloat-0.5)*0.16, v*(randFloat-0.5)*0.16);
        ParticleSmokeHuge smoke_z1 = new ParticleSmokeHuge(this.world, this.posX, startPos - 3, this.posZ, v*(randFloat-0.5)*0.16, v*(randFloat-0.5)*0.16, 0.5 + randSpeed);
        ParticleSmokeHuge smoke_z2 = new ParticleSmokeHuge(this.world, this.posX, startPos - 3, this.posZ, v*(randFloat-0.5)*0.16, v*(randFloat-0.5)*0.16, -(0.5 + randSpeed));
        Minecraft.getMinecraft().effectRenderer.addEffect(smoke_x1);
        Minecraft.getMinecraft().effectRenderer.addEffect(smoke_x2);
        Minecraft.getMinecraft().effectRenderer.addEffect(smoke_z1);
        Minecraft.getMinecraft().effectRenderer.addEffect(smoke_z2);
    }

    @Override
    public void onUpdate() {

        if(this.firstUpdate){
            this.startCountdown();
        }

        super.onUpdate();

        this.setRotation(0.0F, 90.0F);

        boolean launched = this.isLaunched();
        int age = this.getAge();
        int launchTime = this.getLaunchTime();

        if (this.isCountDownStarted() && !launched && age >= launchTime) {
            this.Launch();
        }

        if (launched) {
            int flightTime = getFlightTime();
            float startPos = this.getStartPos();
            this.motionY = jerk * Math.pow(getFlightTime(), 2) / 2;
            this.setPosition(this.posX, startPos + jerk * Math.pow(flightTime, 3) / 6, this.posZ);
            this.setFlightTime(flightTime + 1);

            if(flightTime % 2 == 0) {
                this.spawnFlightParticles();
            }

            if (this.posY > 300 || flightTime > 1200) {
                this.setDead();
            }

            if(this.world.collidesWithAnyBlock(this.getEntityBoundingBox())) {
                this.explode();
            }

            List<Entity> collidingEntities = this.world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox());

            if(!collidingEntities.isEmpty()) {
                for(Entity entity : collidingEntities) {
                    entity.attackEntityFrom(DamageSource.FLY_INTO_WALL, (float) this.motionY * 10.f);
                }
            }
        }

        if(age % 2 == 0 && this.isCountDownStarted()) {
            if(launchTime - age < 60 && launchTime - age > 0) {
                this.spawnLaunchParticles(0.025*(age - launchTime + 60));
            }else if(launchTime - age > -100 && launchTime - age < 0) {
                this.spawnLaunchParticles(1.5);
            }else if(launchTime - age > -150 && launchTime - age < -100) {
                this.spawnLaunchParticles(-0.03*(age - launchTime + 150));
            }
        }

        this.setAge(age + 1);
    }

    public void explode() {
        this.world.newExplosion(this, this.posX, this.posY, this.posZ, 8, true, true);
        this.setDead();
    }

}
