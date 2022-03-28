package gregicality.science.api.particle;

public class Quark extends Particle{

    public static Quark createQuark(String name, float mass, boolean isUpType, int parity){
        double electricCharge = 0;
        if(isUpType){
            electricCharge = parity == 1 ? 2./3 : -2./3;
        }else{
            electricCharge = parity == 1 ? -1./3 : 1./3;
        }
        return new Quark( name,  mass,  electricCharge,  isUpType,  parity);
    }

    protected Quark(String name, float mass, double electricCharge, boolean isUpType, int parity){
        super(name, mass, electricCharge, true, true, 1/2f, parity);
    }
}
