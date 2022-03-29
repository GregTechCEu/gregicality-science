package gregicality.science.api.particle;

public class Atom extends Particle{
    public Atom(String name, float mass, float spin, int parity){
        super(name, mass, 0, false, true, spin, parity);
    }

    @Override
    public Particle addComponent(Particle particle, int amount){
        if(particle instanceof Nucleus || particle instanceof Lepton) {
            this.addComponent(new ParticleStack(particle, amount));
        }else{
            throw new IllegalArgumentException("Cannot add non-nucleus or non-lepton components to atom " + name);
        }
        return this;
    }
}
