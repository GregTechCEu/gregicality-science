package gregicality.science.api.metatileentity.multiblock;

import gregicality.science.api.capability.IPressureContainer;
import gregicality.science.api.capability.IPressureMachine;
import gregicality.science.api.capability.impl.AtmosphericPressureContainer;
import gregicality.science.api.capability.impl.PressureMultiblockRecipeLogic;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.recipes.RecipeMap;
import net.minecraft.util.ResourceLocation;

import java.util.List;

public abstract class PressureMultiblockController extends RecipeMapMultiblockController implements IPressureMachine {

    private IPressureContainer container;

    public PressureMultiblockController(ResourceLocation metaTileEntityId, RecipeMap<?> recipeMap) {
        super(metaTileEntityId, recipeMap);
        this.recipeMapWorkable = new PressureMultiblockRecipeLogic(this);
    }

    @Override
    protected void initializeAbilities() {
        super.initializeAbilities();
        List<IPressureContainer> list = getAbilities(GCYSMultiblockAbility.PRESSURE_CONTAINER);
        if (list.isEmpty()) {
            this.container = new AtmosphericPressureContainer(this, 1.0);
        } else {
            this.container = list.get(0);
        }
    }

    @Override
    public TraceabilityPredicate autoAbilities(boolean checkEnergyIn, boolean checkMaintenance, boolean checkItemIn, boolean checkItemOut, boolean checkFluidIn, boolean checkFluidOut, boolean checkMuffler) {
        TraceabilityPredicate predicate = super.autoAbilities(checkEnergyIn, checkMaintenance, checkItemIn, checkItemOut, checkFluidIn, checkFluidOut, checkMuffler);
        predicate = predicate.or(abilities(GCYSMultiblockAbility.PRESSURE_CONTAINER).setMaxGlobalLimited(1).setPreviewCount(1));
        return predicate;
    }

    @Override
    public IPressureContainer getPressureContainer() {
        return this.container;
    }
}
