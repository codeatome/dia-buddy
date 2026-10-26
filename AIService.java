import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AIService {
  private static final String API_Key = System.getenv("OPENAI_API_KEY");
  private static final String API_URL = "https://api.groq.com/openai/v1/chat/completions";
  public static String askDiaBuddy(UserProfile user, String userPrompt) {
    if (API_KEY == null || API_KEY.isEmpty()) {
      return user.getAnimalName() + ": put API key in replit secret";
    }
    try {
      HttpClient client = HttpClient.newHttpClient();
      String systemContext = "You are " + user.getCompanionName() + ", a friendly " + user.getAnimalType() + " companion for " + user.getUsername() + ", who is managing " + user.getDiabetesType() + ". " + user.getUsername() + " prefers " + user.getCuisine() + " cuisine and speak " + user.getLangugage() + ". " + "Stored medical history summary: " + user.getHealthHistorySummary() + " " + "Always reply in " + user.getLanguage() + ". Ensure all responses are support, and non-diagnostic (put a warning to consult a doctor for any medical decision).";
      String safeQuery = userQuery.replace("\"", "\\\"");
      String safeContext = systemContext.replace("\"", "\\\"");
      String jsonPayload = "{" + 
        "\"model\": \"llama-3.3-70b-versatile\"," +
        "\"messages\": [" +
        "  {\"role\": \"system\", \"content\": \"" + safeContext + "\"}," +
        "  {\"role\": \"user\", \"content\": \"" + safeQuery + "\"}" +
        "]" +
        "}";
      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(API_URL))
        .header("Content-Type", "application/json")
        .header("Authorization", "Bearer " + API_KEY)
        .POST(HttpRequest.BodyPublishers.ofString(jsonPayload))
        .build();
      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
      if (response.statusCode() == 200) {
        return extractContent(response.body(), user.getAnimalName());
      }
      else {
        return "[" + user.getAnimalName() + "]: Connection error (Status " + response.statusCode() + ").";
      }
    } catch (Exception e) {
            return "[" + user.getAnimalName() + "]: Network error.";
    }
  }
  private static String extractContent(String json, String name) {
    try {
      int marker = json.indexOf("\"content\":\"");
      if (marker != -1) {
        int start = marker + 11;
        int end = json.indexOf("\"", start);
        return "[" + name + "]: " + json.substring(start, end).replace("\\n", "\n");
      }
    } catch (Exception ignored) {}
    return "[" + name + "]: Response received.";
    }
}
