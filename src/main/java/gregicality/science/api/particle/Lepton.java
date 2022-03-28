package gregicality.science.api.particle;

public class Lepton extends Particle{
    public Lepton(String name, float mass, double electricCharge, int parity){
        super(name, mass, electricCharge, false, true, 0.5f, parity);
    }
}
