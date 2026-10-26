import java.util.ArrayList;
import java.util.List;

public class CulturalFoodCoach {
    public static List<String> getMealSuggestions(UserProfile user) {
        List<String> suggestions = new ArrayList<>();
        String cuisine = user.getCuisinePreference();
        if (cuisine == null) cuisine = "General";
        switch (cuisine.toLowerCase()) {
            case "indian":
                suggestions.add("Multigrain Roti with Dal and Stir-fried Greens");
                suggestions.add("Methi Thepla with Low-Fat Curd");
                break;
            case "mexican":
                suggestions.add("Grilled Chicken Fajitas with Whole Wheat Tortillas");
                suggestions.add("Black Bean and Avocado Salad");
                break;
            case "mediterranean":
                suggestions.add("Baked Salmon with Quinoa and Roasted Vegetables");
                suggestions.add("Greek Salad with Grilled Chicken and Olive Oil");
                break;
            default:
                suggestions.add("Aim for a balanced plate with lean protein, fiber-rich vegetables, and complex carbs.");
                break;
        }
        return suggestions;
    }
