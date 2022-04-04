package gregicality.science.common.metatileentities.singleblock;

import gregicality.science.api.capability.IPressureContainer;
import gregtech.api.gui.ModularUI;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class MetaTileEntityCreativePressurePump extends MetaTileEntity {

    private double pumpRate = 2000;
    private double pressureLimit = IPressureContainer.ATMOSPHERIC_PRESSURE * 10;

    public MetaTileEntityCreativePressurePump(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity iGregTechTileEntity) {
        return new MetaTileEntityCreativePressurePump(metaTileEntityId);
    }

    @Override
    protected ModularUI createUI(EntityPlayer entityPlayer) {
        ModularUI.Builder builder = ModularUI.defaultBuilder();

        return builder.build(getHolder(), entityPlayer);
    }
}
