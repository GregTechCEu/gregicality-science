package gregicality.science.api.particle;

public class Hadron extends ParticleComposite{
    public Hadron(String name, float mass, double electricCharge, float spin, int parity){
        super(name, mass, electricCharge, false, true, spin, parity);
    }

    @Override
    public Particle addComponent(Particle particle, int amount){
        if(particle instanceof Quark) {
            this.addComponent(new ParticleStack(particle, amount));
        }else{
            throw new IllegalArgumentException("Cannot add non-quark components to hadron " + name);
        }
        return this;
    }
}
