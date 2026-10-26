import java.util.ArrayList;
import java.util.List;

public class UserProfile {
    private String nickname;
    private String diabetesType;
    private String animalType;
    private String companionName;
    private String animalPersonality;
    private String cuisinePreference;
    private String languagePreference;
    private List<HealthLog> healthLogs;

    public UserProfile(String nickname, String diabetesType, String animalType, String companionName, String animalPersonality, String cuisinePreference, String languagePreference) {
        this.nickname = nickname;
        this.diabetesType = diabetesType;
        this.animalType = animalType;
        this.companionName = companionName;
        this.animalPersonality = animalPersonality;
        this.cuisinePreference = cuisinePreference;
        this.languagePreference = languagePreference;
        this.healthLogs = new ArrayList<>(); 
    }

    public String getNickname() { return nickname; }
    public String getUsername() { return nickname; }

    public String getDiabetesType() { return diabetesType; }

    public String getAnimalType() { return animalType; }
    public String getAnimal() { return animalType; }

    public String getCompanionName() { return companionName; }
    public String getAnimalName() { return companionName; }

    public String getAnimalPersonality() { return animalPersonality; }
    public String getPersonality() { return animalPersonality; }

    public String getCuisinePreference() { return cuisinePreference; }
    public String getCuisine() { return cuisinePreference; }

    public String getLanguagePreference() { return languagePreference; }
    public String getLanguage() { return languagePreference; }

    public List<HealthLog> getHealthLogs() { return healthLogs; }
    public void addHealthLog(HealthLog log) { this.healthLogs.add(log); }

    public String getHealthHistorySummary() {
        if (healthLogs.isEmpty()) {
            return "No health logs recorded yet.";
        }
        StringBuilder sb = new StringBuilder();
        for (HealthLog log : healthLogs) {
            sb.append(log.getDate()).append(" (").append(log.getTime()).append(") - ")
              .append("Glucose: ").append(log.getGlucoseValue()).append(" mg/dL, Note: ").append(log.getMealDescription()).append("; ");
        }
        return sb.toString();
    }
}
