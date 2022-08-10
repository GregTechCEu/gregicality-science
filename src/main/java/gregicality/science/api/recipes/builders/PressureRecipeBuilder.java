package gregicality.science.api.recipes.builders;

import gregicality.science.api.GCYSValues;
import gregicality.science.api.recipes.recipeproperties.PressureProperty;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.recipeproperties.RecipePropertyStorage;
import gregtech.api.util.EnumValidationResult;
import gregtech.api.util.GTLog;
import gregtech.api.util.GTUtility;
import gregtech.api.util.ValidationResult;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
public class PressureRecipeBuilder extends RecipeBuilder<PressureRecipeBuilder> {

    @SuppressWarnings("unused")
    public PressureRecipeBuilder() {

    }

    @SuppressWarnings("unused")
    public PressureRecipeBuilder(Recipe recipe, RecipeMap<PressureRecipeBuilder> recipeMap) {
        super(recipe, recipeMap);
    }

    public PressureRecipeBuilder(PressureRecipeBuilder builder) {
        super(builder);
    }

    @Override
    public PressureRecipeBuilder copy() {
        return new PressureRecipeBuilder(this);
    }

    @Override
    public boolean applyProperty(@Nonnull String key, Object value) {
        if (key.equals(PressureProperty.KEY)) {
            this.pressure(((Number) value).doubleValue());
            return true;
        }
        return super.applyProperty(key, value);
    }

    @Nonnull
    public PressureRecipeBuilder pressure(double pressure) {
        if (pressure <= 0) {
            GTLog.logger.error("Pressure cannot be less than or equal to 0", new IllegalArgumentException());
            recipeStatus = EnumValidationResult.INVALID;
        }
        this.applyProperty(PressureProperty.getInstance(), pressure);
        return this;
    }

    @Override
    public ValidationResult<Recipe> build() {
        if (this.recipePropertyStorage == null) this.recipePropertyStorage = new RecipePropertyStorage();
        if (this.recipePropertyStorage.hasRecipeProperty(PressureProperty.getInstance())) {
            if (this.recipePropertyStorage.getRecipePropertyValue(PressureProperty.getInstance(), -1.0D) <= 0) {
                this.recipePropertyStorage.store(PressureProperty.getInstance(), GCYSValues.EARTH_PRESSURE);
            }
        } else {
            this.recipePropertyStorage.store(PressureProperty.getInstance(), GCYSValues.EARTH_PRESSURE);
        }

        return super.build();
    }

    public double getPressure() {
        return this.recipePropertyStorage == null ? 0.0D :
                this.recipePropertyStorage.getRecipePropertyValue(PressureProperty.getInstance(), 0.0D);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append(PressureProperty.getInstance().getKey(), GTUtility.formatNumbers(getPressure()))
                .toString();
    }
}
