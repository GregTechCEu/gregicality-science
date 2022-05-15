package gregicality.science.api.recipes.builders;

import gregicality.science.api.recipes.recipeproperties.NoCoilTemperatureProperty;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.util.EnumValidationResult;
import gregtech.api.util.GTUtility;
import gregtech.api.util.ValidationResult;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.annotation.Nonnull;

public class NoCoilTemperatureRecipeBuilder extends RecipeBuilder<NoCoilTemperatureRecipeBuilder> {

    private int temperature;

    public NoCoilTemperatureRecipeBuilder() {

    }

    public NoCoilTemperatureRecipeBuilder(NoCoilTemperatureRecipeBuilder builder) {
        super(builder);
        this.temperature = builder.temperature;
    }

    @Override
    public NoCoilTemperatureRecipeBuilder copy() {
        return new NoCoilTemperatureRecipeBuilder(this);
    }

    @Override
    public boolean applyProperty(@Nonnull String key, Object value) {
        if (key.equals(NoCoilTemperatureProperty.KEY)) {
            this.temperature(((Number) value).intValue());
            return true;
        }
        return true;
    }

    @Nonnull
    public NoCoilTemperatureRecipeBuilder temperature(int temperature) {
        this.temperature = temperature;
        return this;
    }

    public ValidationResult<Recipe> build() {
        Recipe recipe = new Recipe(inputs, outputs, chancedOutputs, fluidInputs, fluidOutputs,
                duration, EUt, hidden, isCTRecipe);
        if (!recipe.setProperty(NoCoilTemperatureProperty.getInstance(), temperature)) {
            return ValidationResult.newResult(EnumValidationResult.INVALID, recipe);
        }

        return ValidationResult.newResult(finalizeAndValidate(), recipe);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append(NoCoilTemperatureProperty.getInstance().getKey(), GTUtility.formatNumbers(temperature))
                .toString();
    }
}
