package gregicality.science.common.items;

import gregicality.science.common.items.behaviors.HeldItemDestroyBehavior;
import gregtech.api.items.metaitem.StandardMetaItem;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.items.MetaItems;

import static gregicality.science.common.items.GCYSMetaItems.*;

public class GCYSMetaItem1 extends StandardMetaItem {

    public GCYSMetaItem1() {
        super();
    }

    @Override
    public void registerSubItems() {
        MAGNETRON = addItem(0, "magnetron");

        BIOWARE_PROCESSOR = addItem(1, "circuit.bioware_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Ultimate);
        BIOWARE_ASSEMBLY = addItem(2, "circuit.bioware_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Super);
        BIOWARE_COMPUTER = addItem(3, "circuit.bioware_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Infinite);
        BIOWARE_MAINFRAME = addItem(4, "circuit.bioware_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Ultra);

        OPTICAL_PROCESSOR = addItem(5,"circuit.optical_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Super);
        OPTICAL_ASSEMBLY = addItem(6,"circuit.optical_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Infinite);
        OPTICAL_COMPUTER = addItem(7,"circuit.optical_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Ultra);
        OPTICAL_MAINFRAME = addItem(8,"circuit.optical_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Insane);

        EXOTIC_PROCESSOR = addItem(9, "circuit.exotic_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Infinite);
        EXOTIC_ASSEMBLY = addItem(10, "circuit.exotic_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Ultra);
        EXOTIC_COMPUTER = addItem(11, "circuit.exotic_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Insane);
        EXOTIC_MAINFRAME = addItem(12, "circuit.exotic_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Epic);

        COSMIC_PROCESSOR = addItem(13, "circuit.cosmic_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Ultra);
        COSMIC_ASSEMBLY = addItem(14, "circuit.cosmic_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Insane);
        COSMIC_COMPUTER = addItem(15, "circuit.cosmic_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Epic);
        COSMIC_MAINFRAME = addItem(16, "circuit.cosmic_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Legendary);

        SUPRACAUSAL_PROCESSOR = addItem(17, "circuit.supracausal_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Insane);
        SUPRACAUSAL_ASSEMBLY = addItem(18, "circuit.supracausal_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Epic);
        SUPRACAUSAL_COMPUTER = addItem(19, "circuit.supracausal_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Legendary);
        SUPRACAUSAL_MAINFRAME = addItem(20, "circuit.supracausal_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Maximum);

        ULTRASONIC_HOMOGENZIER = addItem(21, "ultrasonic_homogenizer");
        STERILE_PETRI_DISH = addItem(22, "petri_dish.sterile").addComponents(new HeldItemDestroyBehavior(MetaItems.PETRI_DISH));
        CLEAN_CULTURE = addItem(23, "culture.clean").addComponents(new HeldItemDestroyBehavior(MetaItems.PETRI_DISH));
        CUPRIAVIDUS_NECATOR = addItem(24, "culture.cupriavidus_necator").addComponents(new HeldItemDestroyBehavior(MetaItems.PETRI_DISH));
        BREVIBACTERIUM_FLAVUM = addItem(25, "culture.brevibacterium_flavum").addComponents(new HeldItemDestroyBehavior(MetaItems.PETRI_DISH));
        RAPIDLY_REPLICATING_CELLS = addItem(26, "rapidly_replicating_cells").addComponents(new HeldItemDestroyBehavior(MetaItems.FERTILIZER));
        SUPERINTELLIGENT_ORGANISM = addItem(27, "superintelligent_organism").addComponents(new HeldItemDestroyBehavior(MetaItems.FERTILIZER));

        BIOWARE_BOARD = addItem(28, "board.bioware");
        BIOWARE_CIRCUIT_BOARD = addItem(29, "circuit_board.bioware");

        SENTIENT_PROCESSOR = addItem(30, "processor.sentient");

        INSANE_SMD_CAPACITOR = addItem(31, "component.insane_smd.capacitor");
        INSANE_SMD_DIODE = addItem(32, "component.insane_smd.diode");
        INSANE_SMD_RESISTOR = addItem(33, "component.insane_smd.resistor");
        INSANE_SMD_TRANSISTOR = addItem(34, "component.insane_smd.transistor");
        INSANE_SMD_INDUCTOR = addItem(35, "component.insane_smd.inductor");
    }
}
