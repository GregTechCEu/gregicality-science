package gregicality.science.api.recipes.builders;

import gregicality.science.api.recipes.recipeproperties.NoCoilTemperatureProperty;
import gregicality.science.api.recipes.recipeproperties.PressureProperty;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.util.EnumValidationResult;
import gregtech.api.util.GTUtility;
import gregtech.api.util.ValidationResult;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.annotation.Nonnull;

public class TemperaturePressureRecipeBuilder extends RecipeBuilder<TemperaturePressureRecipeBuilder> {

    private int temperature;
    private double pressure;

    public TemperaturePressureRecipeBuilder() {

    }

    public TemperaturePressureRecipeBuilder(TemperaturePressureRecipeBuilder builder) {
        super(builder);
        this.temperature = builder.temperature;
        this.pressure = builder.pressure;
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
        return true;
    }

    @Nonnull
    public TemperaturePressureRecipeBuilder temperature(int temperature) {
        this.temperature = temperature;
        return this;
    }

    @Nonnull
    public TemperaturePressureRecipeBuilder pressure(double pressure) {
        this.pressure = pressure;
        return this;
    }

    public ValidationResult<Recipe> build() {
        Recipe recipe = new Recipe(inputs, outputs, chancedOutputs, fluidInputs, fluidOutputs,
                duration, EUt, hidden, isCTRecipe);
        if (!recipe.setProperty(NoCoilTemperatureProperty.getInstance(), temperature)) {
            return ValidationResult.newResult(EnumValidationResult.INVALID, recipe);
        }
        if (!recipe.setProperty(PressureProperty.getInstance(), pressure)) {
            return ValidationResult.newResult(EnumValidationResult.INVALID, recipe);
        }

        return ValidationResult.newResult(finalizeAndValidate(), recipe);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append(NoCoilTemperatureProperty.getInstance().getKey(), GTUtility.formatNumbers(temperature))
                .append(PressureProperty.getInstance().getKey(), GTUtility.formatNumbers(pressure))
                .toString();
    }
}
