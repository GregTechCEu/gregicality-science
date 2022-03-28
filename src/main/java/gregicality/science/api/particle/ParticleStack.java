package gregicality.science.api.particle;

public class ParticleStack {

    protected Particle particle;
    protected int amount;

    public ParticleStack(Particle particle, int amount){
        this.particle = particle;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public Particle getParticle() {
        return particle;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setParticle(Particle particle) {
        this.particle = particle;
    }
}
