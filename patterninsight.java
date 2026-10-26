import java.util.ArrayList;
import java.util.List;

public class PatternInsight {
    
    public static List<String> patternRecognition(List<HealthLog> logs) {
        List<String> insights = new ArrayList<>();
        int highEveningCount = 0;
        int totalGlucoseLogs = 0;
        
        for (HealthLog log : logs) {
            if ("Glucose".equals(log.getLogType())) {
                totalGlucoseLogs++;
                if (log.getGlucoseValue() > 140 && "Evening".equalsIgnoreCase(log.getGlucoseContext())) {
                    highEveningCount++;
                }
            }
        }
        
        if (highEveningCount >= 2) {
            insights.add("Noticeable Pattern: Your logged glucose readings were higher on " + highEveningCount + " evenings after dinner.");
        } else {
            insights.add("Logging Consistency: You have recorded " + totalGlucoseLogs + " glucose readings so far. Keep up the great work!");
        }
        
        return insights;
    }

    public static String getCompanionInsights(UserProfile user) {
        String prompt = "Review my health history summary and give me a friendly, supportive wellness tip based on my recent patterns.";
        return AIService.askDiaBuddy(user, prompt);
    }
}

