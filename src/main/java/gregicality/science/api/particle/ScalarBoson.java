package gregicality.science.api.particle;

public class ScalarBoson extends Particle{
    public ScalarBoson(String name, float mass, double electricCharge, int parity){
        super(name, mass, electricCharge, false, true, 0, parity);
    }
}
