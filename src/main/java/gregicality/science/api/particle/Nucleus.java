package gregicality.science.api.particle;

public class Nucleus extends Particle{
    public Nucleus(String name, float mass, double electricCharge, float spin, int parity){
        super(name, mass, electricCharge, false, true, spin, parity);
    }

    @Override
    public Particle addComponent(Particle particle, int amount){
        if(particle instanceof Baryon) {
            this.addComponent(new ParticleStack(particle, amount));
        }else{
            throw new IllegalArgumentException("Cannot add non-baryon components to nucleus " + name);
        }
        return this;
    }
}
