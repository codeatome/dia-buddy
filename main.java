import java.util.ArrayList;
import java.util.List;

public class App {
  public static void main(String[] args) {
    System.out.println("Starting Dia-Buddy Engine...\n");
    UserProfile user = new UserProfile("Alex", "Type 2", "Bunny", "Luna", "Cheerful", "Indian", "English"); 
    List<HealthLog> logs = new ArrayList<>();
    logs.add(new HealthLog("2026-10-22", "19:00", 165, "Evening"));
    logs.add(new HealthLog("2026-10-23", "20:00", 145, "Evening"));
    logs.add(new HealthLog("2025-10-24", "21:00", 110, "Morning"));
    List<String> userInsights = PatternInsight.generateInsights(logs);
    System.out.println("--- " + user.getAnimalName() + "'s Dashboard ---");
    System.out.println("User: " + user.getUsername() + " | Diabetes Type: " + user.getDiabetesType());
    System.out.println("\nInsights and Pattern Recognition:");
    for (String insight: userInsights) {
      System.out.println("**" + insight + "**");
    }
  }
}
