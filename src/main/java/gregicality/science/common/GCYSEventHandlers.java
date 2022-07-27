package gregicality.science.common;

import gregicality.science.GregicalityScience;
import gregicality.science.api.unification.OrePrefixAdditions;
import gregicality.science.api.unification.materials.GCYSMaterials;
import gregicality.science.api.unification.materials.properties.GCYSMaterialPropertyAddition;
import gregtech.api.GregTechAPI;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = GregicalityScience.MODID)
public class GCYSEventHandlers {

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void registerMaterials(GregTechAPI.MaterialEvent event) {
        GCYSMaterials.init();
        GCYSMaterialPropertyAddition.init();
        OrePrefixAdditions.init();
    }
}
