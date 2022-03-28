package gregicality.science.api.particle;

import com.sun.istack.internal.Nullable;

import java.util.ArrayList;

public class ParticleComposite extends Particle{

    protected ArrayList<ParticleStack> components;

    public ParticleComposite(String name, float mass, double electricCharge, boolean coloured, boolean weaklyCharged, float spin, int parity){
        super(name, mass, electricCharge, coloured, weaklyCharged, spin, parity);
    }

    protected void setComponents(ArrayList<ParticleStack> components) {
        this.components = components;
    }

    protected void addComponent(ParticleStack particleStack){
        this.components.add(particleStack);
    }

    public Particle addComponent(Particle particle, int amount){
        this.addComponent(new ParticleStack(particle, amount));
        return this;
    }

    @Nullable
    public ArrayList<ParticleStack> getComponents(){
        return components;
    }

    public ParticleStack getComponent(int i){
        return components.get(i);
    }
}
