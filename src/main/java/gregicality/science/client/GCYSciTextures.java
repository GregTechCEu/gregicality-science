package gregicality.science.client;

import gregtech.api.render.OrientedOverlayRenderer;
import gregtech.api.render.OrientedOverlayRenderer.OverlayFace;
import gregtech.api.render.SimpleCubeRenderer;

public class GCYSciTextures {

    // Multiblock Casings
    public static SimpleCubeRenderer QUANTUM_COMPUTER = new SimpleCubeRenderer("casings/solid/quantum/computer");
    public static SimpleCubeRenderer HYPER_CASING = new SimpleCubeRenderer("casings/solid/hyper_casing");
    public static SimpleCubeRenderer HYPER_CASING_2 = new SimpleCubeRenderer("casings/solid/hyper_casing_2");
    public static SimpleCubeRenderer FUSION_TEXTURE = new SimpleCubeRenderer("casings/fusion/machine_casing_fusion_glass");
    public static SimpleCubeRenderer BIO_REACTOR = new SimpleCubeRenderer("casings/solid/bio_reactor_casing");
    public static SimpleCubeRenderer HASTELLOY_N_CASING = new SimpleCubeRenderer("casings/metal_casings/hastelloy_n");
    public static SimpleCubeRenderer HASTELLOY_K243_CASING = new SimpleCubeRenderer("casings/metal_casings/hastelloy_k243");
    public static SimpleCubeRenderer NITINOL_60_CASING = new SimpleCubeRenderer("casings/metal_casings/nitinol_60");
    public static SimpleCubeRenderer ENRICHED_NAQUADAH_ALLOY_CASING = new SimpleCubeRenderer("casings/metal_casings/enriched_naquadah_alloy");
    public static SimpleCubeRenderer QUANTUM_CASING = new SimpleCubeRenderer("casings/metal_casings/quantum");
    public static SimpleCubeRenderer NAQUADRIA_CASING = new SimpleCubeRenderer("casings/metal_casings/naquadria");

    // Machine Overlays
    public static OrientedOverlayRenderer NAQUADAH_OVERLAY = new OrientedOverlayRenderer("machines/naquadah_reactor", OverlayFace.FRONT, OverlayFace.BACK, OverlayFace.TOP);
    public static OrientedOverlayRenderer ROCKET_OVERLAY = new OrientedOverlayRenderer("machines/rocket_generator", OverlayFace.FRONT, OverlayFace.BACK, OverlayFace.TOP);
    public static OrientedOverlayRenderer FUSION_REACTOR_OVERLAY = new OrientedOverlayRenderer("machines/fusion_reactor", OverlayFace.FRONT);
    public static OrientedOverlayRenderer ORGANIC_REPLICATOR_OVERLAY = new OrientedOverlayRenderer("machines/organic_replicator", OverlayFace.FRONT, OverlayFace.TOP);
    public static OrientedOverlayRenderer QUBIT_COMPUTER_OVERLAY = new OrientedOverlayRenderer("machines/qubit_computer", OverlayFace.FRONT);
}
