public class HealthLog {
  private String date;
  private String time;
  private String logType;
  private int glucoseValue;
  private String glucoseContext;
  private String mealDescription;
  private String mealType;
  private String activityDescription;
  private int activityDurationMin;
  private double a1cPercentage;
  public HealthLog (String date, String time, int glucoseValue, String logType,  String glucoseContext, String mealDescription, String mealType, String activtyDescription, int activityDurationMin, double a1cpercentage) {
    this.date = date;
    this.time = time;
    this.glucoseValue = glucoseValue;
    this.logType = logType;
    this.glucoseContext = glucoseContext;
    this.mealDescription = mealDescription;
    this.mealType = mealType;
    this.activityDescription = activityDescription;
    this.activityDurationMin = activityDurationMin;
    this.a1cPercentage = a1cPercentage;
  }
  public String getDate() {
    return date;
  }
  public String getTime() {
    return time;
  }
  public int getGlucoseValue() {
    return glucoseValue;
  }
  public String getLogType() {
    return logType;
  }
  public String getGlucoseContext() {
    return glucoseContext;
  }
  public String getMealDescription() {
    return mealDescription;
  }
  public String getMealType() {
    return mealType;
  }
  public String getActivityDescription() {
    return activityDescription;
  }
  public int getActivityDurationMin() {
    return activityDurationMin;
  }
  public double geta1cPercentage() {
    return a1cPercentage;
  }
}
  
