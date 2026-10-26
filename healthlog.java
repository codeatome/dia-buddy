public class HealthLog {
    private String date;
    private String time;
    private int glucoseValue;
    private String logType;
    private String glucoseContext;
    private String mealDescription;

    public HealthLog(String date, String time, int glucoseValue, String logType) {
        this.date = date;
        this.time = time;
        this.glucoseValue = glucoseValue;
        this.logType = logType;
        this.glucoseContext = "Evening";
        this.mealDescription = "Chicken, potatoes, and green beans";
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
}
