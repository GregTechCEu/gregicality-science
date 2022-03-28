package gregicality.science.api.particle;

public class ParticleBeam {

    protected final float momentum;
    protected final float width;
    protected final float particleRate;
    protected final float energy;

    protected final ParticleStack particleStack;

    public ParticleBeam(float momentum, float width, float particleRate, ParticleStack particleStack){
        this.momentum = momentum;
        this.width = width;
        this.particleRate = particleRate;
        this.particleStack = particleStack;
        this.energy = (float) Math.sqrt(Math.pow(this.particleStack.getParticle().getMass(), 2) + Math.pow(this.momentum, 2));
    }

    public float getMomentum() {
        return momentum;
    }

    public float getWidth() {
        return width;
    }

    public float getParticleRate() {
        return particleRate;
    }

    public ParticleStack getParticleStack() {
        return particleStack;
    }

    public double getEnergy(){
        return this.energy;
    }

    public float getMass(){
        return this.particleStack.getParticle().getMass();
    }

    public double getS(ParticleBeam beam){
        return Math.pow(this.getMass(), 2) + Math.pow(beam.getMass(), 2) + 2*(this.getEnergy()* beam.getEnergy() + this.getMomentum()*beam.getMomentum());
    }

    public double getInvariantMass(ParticleBeam beam){
        return Math.sqrt(this.getS(beam));
    }
}
