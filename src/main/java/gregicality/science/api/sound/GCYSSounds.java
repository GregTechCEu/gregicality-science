package gregicality.science.api.sound;

import gregicality.science.api.GCYSValues;
import gregicality.science.api.utils.GCYSLog;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class GCYSSounds {

    public static SoundEvent ROCKET_LAUNCH;

    public static void registerSounds(){
        ROCKET_LAUNCH = registerSound("entity.rocket_launch");
    }

    private static SoundEvent registerSound(String soundNameIn) {
        ResourceLocation location = new ResourceLocation(GCYSValues.MODID, soundNameIn);
        SoundEvent event = new SoundEvent(location);
        event.setRegistryName(location);
        ForgeRegistries.SOUND_EVENTS.register(event);
        return event;
    }
}
