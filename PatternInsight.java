import java.util.Arraylist;
import java.util.List;

public class PatternInsight {
  public static List<String> patternRecognition(List<HealthLog> logs) {
    List<String> insights = new ArrayList<>();
    int highEveningCOunt = 0;
    int totalGlucoseLogs = 0;
    for (HealthLog log : log) {
      if ("Glucose".equals(log.getLogType())) {
        totalGlucoseLogs++;
        if (log.getGlucoseValue() > 140 && "Evening".equalsIgnoreCase(log.getGlucoseContext())) {
          highEveningCount++;
        }
      }
    }
    if (highEveningCount >= 2) {
      insights.add("Noticeable Pattern: Your logged glucose readings were higher on " + highEveningCount + " evenings after dinner.");
    }
    else {
      insights.add("Logging Constistency: You have recorded " + totalGlucoseLogs + " glucose readings so far. Keep up the good work!");
    }
    return insights;
  }
}
    
