package gregicality.science.api.recipes.builders;

import gregicality.science.api.recipes.recipeproperties.PressureProperty;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.util.EnumValidationResult;
import gregtech.api.util.GTUtility;
import gregtech.api.util.ValidationResult;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.annotation.Nonnull;

public class PressureRecipeBuilder extends RecipeBuilder<PressureRecipeBuilder> {

    private double pressure;

    public PressureRecipeBuilder() {

    }

    public PressureRecipeBuilder(PressureRecipeBuilder builder) {
        super(builder);
        this.pressure = builder.pressure;
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
        return true;
    }

    @Nonnull
    public PressureRecipeBuilder pressure(Double pressure) {
        this.pressure = pressure;
        return this;
    }

    public ValidationResult<Recipe> build() {
        Recipe recipe = new Recipe(inputs, outputs, chancedOutputs, fluidInputs, fluidOutputs,
                duration, EUt, hidden, isCTRecipe);
        if (!recipe.setProperty(PressureProperty.getInstance(), pressure)) {
            return ValidationResult.newResult(EnumValidationResult.INVALID, recipe);
        }

        return ValidationResult.newResult(finalizeAndValidate(), recipe);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append(PressureProperty.getInstance().getKey(), GTUtility.formatNumbers(pressure))
                .toString();
    }
}
