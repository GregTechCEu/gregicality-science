package gregicality.science.api.particle;

public class GaugeBoson extends Particle{
    public GaugeBoson(String name, float mass, double electricCharge, boolean coloured, boolean weaklyCharged){
        super(name, mass, electricCharge, coloured, weaklyCharged, 1, -1);
    }
}
