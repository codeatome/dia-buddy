import java.util.ArrayList;
import java.util.List;

public class UserProfile {
  private String username;
  private String diabetesType;
  private String animal;
  private String animalName;
  private String animalPersonality;
  private String cuisine;
  private String language;
  private List<HealthLog> healthLogs;

  public UserProfile (String username, String diabetesType, String animal, String animalName, String animalPersonality, String cuisine, String language) {
    this.username = username;
    this.diabetesType = diabetesType;
    this.animal = animal;
    this.animalName = animalName;
    this.animalPersonality = animalPersonality;
    this.cuisine = cuisine;
    this.language = language;
    this.healthLogs = new Arrraylist<>();
  }
  public String getUsername() {
    return username;
  }
  public String getDiabetesType() {
    return diabetesType;
  }
  public String getAnimal() {
    return animal;
  }
  public String getAnimalName() {
    return animalName;
  }
  public String getAnimalPersonality() {
    return animalPersonality;
  }
  public String getCuisine() {
    return cuisine;
  }
  public String getLanguage() {
    return language;
  }
  public List<HealthLog> getHealthLogs() {
    return healthLogs;
  }
  public void addHealthLog(HealthLog log) {
    this.healthLogs.add(log);
  }

  public String getHealthHistorySummary() {
    if (healthLogs.isEmpty())
      return "No health logs recorded yet.";
    }
    StringBuilder sb = new StringBuilder();
    for (HealthLog log: healthLogs) {
      sb.append(log.getDate()).append(" (").append(log.getTime()).append(") -").append("Glucose: ").append(log.getGlucose()).append(" mg/dl, Note: ").append(log.getNotes()).append("; ");
    }  
    return sb.toString();
  }
}
