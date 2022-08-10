package gregicality.science.api.recipes.builders;

import gregicality.science.api.GCYSValues;
import gregicality.science.api.recipes.recipeproperties.NoCoilTemperatureProperty;
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

public class TemperaturePressureRecipeBuilder extends RecipeBuilder<TemperaturePressureRecipeBuilder> {

    public TemperaturePressureRecipeBuilder() {

    }

    @SuppressWarnings("unused")
    public TemperaturePressureRecipeBuilder(Recipe recipe, RecipeMap<TemperaturePressureRecipeBuilder> recipeMap) {
        super(recipe, recipeMap);
    }

    public TemperaturePressureRecipeBuilder(TemperaturePressureRecipeBuilder builder) {
        super(builder);
    }

    @Override
    public TemperaturePressureRecipeBuilder copy() {
        return new TemperaturePressureRecipeBuilder(this);
    }

    @Override
    public boolean applyProperty(@Nonnull String key, Object value) {
        if (key.equals(NoCoilTemperatureProperty.KEY)) {
            this.temperature(((Number) value).intValue());
            return true;
        }
        if (key.equals(PressureProperty.KEY)) {
            this.pressure(((Number) value).doubleValue());
            return true;
        }
        return super.applyProperty(key, value);
    }

    @Nonnull
    public TemperaturePressureRecipeBuilder temperature(int temperature) {
        if (temperature <= 0) {
            GTLog.logger.error("Temperature cannot be less than or equal to 0", new IllegalArgumentException());
            recipeStatus = EnumValidationResult.INVALID;
        }
        this.applyProperty(NoCoilTemperatureProperty.getInstance(), temperature);
        return this;
    }

    @Nonnull
    public TemperaturePressureRecipeBuilder pressure(double pressure) {
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
        if (this.recipePropertyStorage.hasRecipeProperty(NoCoilTemperatureProperty.getInstance())) {
            if (this.recipePropertyStorage.getRecipePropertyValue(NoCoilTemperatureProperty.getInstance(), -1) <= 0) {
                this.recipePropertyStorage.store(NoCoilTemperatureProperty.getInstance(), GCYSValues.EARTH_TEMPERATURE);
            }
        } else {
            this.recipePropertyStorage.store(NoCoilTemperatureProperty.getInstance(), GCYSValues.EARTH_TEMPERATURE);
        }

        if (this.recipePropertyStorage.hasRecipeProperty(PressureProperty.getInstance())) {
            if (this.recipePropertyStorage.getRecipePropertyValue(PressureProperty.getInstance(), -1.0D) <= 0) {
                this.recipePropertyStorage.store(PressureProperty.getInstance(), GCYSValues.EARTH_PRESSURE);
            }
        } else {
            this.recipePropertyStorage.store(PressureProperty.getInstance(), GCYSValues.EARTH_PRESSURE);
        }

        return super.build();
    }

    public int getTemperature() {
        return this.recipePropertyStorage == null ? 0 :
                this.recipePropertyStorage.getRecipePropertyValue(NoCoilTemperatureProperty.getInstance(), 0);
    }

    public double getPressure() {
        return this.recipePropertyStorage == null ? 0.0D :
                this.recipePropertyStorage.getRecipePropertyValue(PressureProperty.getInstance(), 0.0D);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append(NoCoilTemperatureProperty.getInstance().getKey(), GTUtility.formatNumbers(getTemperature()))
                .append(PressureProperty.getInstance().getKey(), GTUtility.formatNumbers(getPressure()))
                .toString();
    }
}
