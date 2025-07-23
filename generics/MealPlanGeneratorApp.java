public class MealPlanGeneratorApp {
    public static void main(String[] args) {
        VegetarianMeal veg = new VegetarianMeal();
        KetoMeal keto = new KetoMeal();

        Meal<VegetarianMeal> vegMeal = MealPlanGenerator.generatePlan(veg);
        Meal<KetoMeal> ketoMeal = MealPlanGenerator.generatePlan(keto);

        System.out.println("Meal Plan 1: " + vegMeal.getPlan().getPlanType());
        System.out.println("Meal Plan 2: " + ketoMeal.getPlan().getPlanType());
    }
}

interface MealPlan {
    String getPlanType();
}

class VegetarianMeal implements MealPlan {
    public String getPlanType() {
        return "Vegetarian";
    }
}

class VeganMeal implements MealPlan {
    public String getPlanType() {
        return "Vegan";
    }
}

class KetoMeal implements MealPlan {
    public String getPlanType() {
        return "Keto";
    }
}

class Meal<T extends MealPlan> {
    private T plan;

    public Meal(T plan) {
        this.plan = plan;
    }

    public T getPlan() {
        return plan;
    }
}

class MealPlanGenerator {
    public static <T extends MealPlan> Meal<T> generatePlan(T plan) {
        return new Meal<>(plan);
    }
}
