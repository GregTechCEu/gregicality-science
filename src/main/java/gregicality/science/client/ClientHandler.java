package gregicality.science.client;

import gregtech.api.gui.resources.TextureArea;
import gregtech.api.render.OrientedOverlayRenderer;
import gregtech.api.render.OrientedOverlayRenderer.OverlayFace;
import gregtech.api.render.SimpleCubeRenderer;
import gregtech.api.render.SimpleOverlayRenderer;

public class ClientHandler {

    // Multiblock Casing
    public static SimpleCubeRenderer QUANTUM_COMPUTER = new SimpleCubeRenderer("casings/solid/quantum/computer");
    public static SimpleCubeRenderer CLADDED_REACTOR_CASING = new SimpleCubeRenderer("casings/solid/cladded_reactor_casing");
    public static SimpleCubeRenderer HYPER_CASING = new SimpleCubeRenderer("casings/solid/hyper_casing");
    public static SimpleCubeRenderer HYPER_CASING_2 = new SimpleCubeRenderer("casings/solid/hyper_casing_2");
    public static SimpleCubeRenderer FUSION_TEXTURE = new SimpleCubeRenderer("casings/fusion/machine_casing_fusion_glass");
    public static SimpleCubeRenderer BIO_REACTOR = new SimpleCubeRenderer("casings/solid/bio_reactor_casing");
    public static SimpleCubeRenderer THORIUM_CASING = new SimpleCubeRenderer("casings/metal_casings/thorium");
    public static SimpleCubeRenderer PROTACTINIUM_CASING = new SimpleCubeRenderer("casings/metal_casings/protactinium");
    public static SimpleCubeRenderer URANIUM_CASING = new SimpleCubeRenderer("casings/metal_casings/uranium");
    public static SimpleCubeRenderer NEPTUNIUM_CASING = new SimpleCubeRenderer("casings/metal_casings/neptunium");
    public static SimpleCubeRenderer PLUTONIUM_CASING = new SimpleCubeRenderer("casings/metal_casings/plutonium");
    public static SimpleCubeRenderer AMERICIUM_CASING = new SimpleCubeRenderer("casings/metal_casings/americium");
    public static SimpleCubeRenderer CURIUM_CASING = new SimpleCubeRenderer("casings/metal_casings/curium");
    public static SimpleCubeRenderer BERKELIUM_CASING = new SimpleCubeRenderer("casings/metal_casings/berkelium");
    public static SimpleCubeRenderer CALIFORNIUM_CASING = new SimpleCubeRenderer("casings/metal_casings/californium");
    public static SimpleCubeRenderer EINSTEINIUM_CASING = new SimpleCubeRenderer("casings/metal_casings/einsteinium");
    public static SimpleCubeRenderer FERMIUM_CASING = new SimpleCubeRenderer("casings/metal_casings/fermium");
    public static SimpleCubeRenderer MENDELEVIUM_CASING = new SimpleCubeRenderer("casings/metal_casings/mendelevium");
    public static SimpleCubeRenderer HASTELLOY_N_CASING = new SimpleCubeRenderer("casings/metal_casings/hastelloy_n");
    public static SimpleCubeRenderer HASTELLOY_K243_CASING = new SimpleCubeRenderer("casings/metal_casings/hastelloy_k243");
    public static SimpleCubeRenderer MARAGING_STEEL_250_CASING = new SimpleCubeRenderer("casings/metal_casings/maraging_steel_250");
    public static SimpleCubeRenderer NITINOL_60_CASING = new SimpleCubeRenderer("casings/metal_casings/nitinol_60");
    public static SimpleCubeRenderer ENRICHED_NAQUADAH_ALLOY_CASING = new SimpleCubeRenderer("casings/metal_casings/enriched_naquadah_alloy");
    public static SimpleCubeRenderer QUANTUM_CASING = new SimpleCubeRenderer("casings/metal_casings/quantum");
    public static SimpleCubeRenderer NAQUADRIA_CASING = new SimpleCubeRenderer("casings/metal_casings/naquadria");

    // Machine Overlays
    public static OrientedOverlayRenderer NAQADAH_OVERLAY = new OrientedOverlayRenderer("machines/naquadah_reactor", OverlayFace.FRONT, OverlayFace.BACK, OverlayFace.TOP);
    public static OrientedOverlayRenderer ROCKET_OVERLAY = new OrientedOverlayRenderer("machines/rocket_generator", OverlayFace.FRONT, OverlayFace.BACK, OverlayFace.TOP);
    public static OrientedOverlayRenderer FUSION_REACTOR_OVERLAY = new OrientedOverlayRenderer("machines/fusion_reactor", OverlayFace.FRONT);
    public static final TextureArea BRONZE_FLUID_SLOT = TextureArea.fullImage("textures/gui/steam/fluid_slot.png");
    public static OrientedOverlayRenderer STEAM_MIXER_OVERLAY = new OrientedOverlayRenderer("machines/steam_mixer", OverlayFace.FRONT, OverlayFace.SIDE, OverlayFace.TOP);
    public static final TextureArea BRONZE_DISPLAY = TextureArea.fullImage("textures/gui/steam/bronze_display.png");
    public static final TextureArea BRONZE_IN_SLOT_OVERLAY = TextureArea.fullImage("textures/gui/steam/bronze_in_slot_overlay.png");
    public static final TextureArea BRONZE_OUT_SLOT_OVERLAY = TextureArea.fullImage("textures/gui/steam/bronze_out_slot_overlay.png");
    public static final TextureArea BRONZE_TANK_ICON = TextureArea.fullImage("textures/gui/steam/bronze_tank_icon.png");
    public static SimpleOverlayRenderer STEAM_PUMP_OVERLAY = new SimpleOverlayRenderer("overlay/machine/overlay_steam_pump");
    public static OrientedOverlayRenderer ORGANIC_REPLICATOR_OVERLAY = new OrientedOverlayRenderer("machines/organic_replicator", OverlayFace.FRONT, OverlayFace.TOP);
    public static OrientedOverlayRenderer QUBIT_COMPUTER_OVERLAY = new OrientedOverlayRenderer("machines/qubit_computer", OverlayFace.FRONT);
    public static OrientedOverlayRenderer NUCLEAR_REACTOR_OVERLAY = new OrientedOverlayRenderer("machines/nuclear_reactor", OverlayFace.FRONT);
}
