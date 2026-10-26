public class UserProfile {
  private String username;
  private String diabetesType;
  private String animal;
  private String animalName;
  private String animalPersonality;
  private String cuisine;
  private String language;

  public UserProfile (String username, String diabetesType, String animal, String animalName, String animalPersonality, String cuisine, String language) {
    this.username = username;
    this.diabetesType = diabetesType;
    this.animal = animal;
    this.animalName = animalName;
    this.animalPersonality = animalPersonality;
    this.cuisine = cuisine;
    this.language = language;
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
}
