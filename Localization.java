public class Localization {
    public static String get(String lang, String key) {
        if (lang == null) lang = "English";
        switch (lang) {
            case "Spanish": return getSpanish(key);
            case "French": return getFrench(key);
            default: return getEnglish(key);
        }
    }
    private static String getEnglish(String key) {
        switch (key) {
            case "welcome": return "Welcome to Dia-Buddy!";
            case "dashboard": return "Health Dashboard";
            case "food_coach": return "Food Coach";
            case "chat": return "Chat with your Companion";
            case "chat_btn": return "Chat with ";
            case "back": return "← Back";
            case "send": return "Send";
            default: return key;
        }
    }
    private static String getSpanish(String key) {
        switch (key) {
            case "welcome": return "¡Bienvenido a Dia-Buddy!";
            case "dashboard": return "Panel de Salud";
            case "food_coach": return "Entrenador de Comida";
            case "chat": return "Hablas con tu Compañero";
            case "chat_btn": return "Chatear con ";
            case "back": return "← Volver";
            case "send": return "Enviar";
            default: return key;
        }
    }
    private static String getFrench(String key) {
        switch (key) {
            case "welcome": return "Bienvenue sur Dia-Buddy !";
            case "dashboard": return "Tableau de Bord";
            case "food_coach": return "Coach Culinaire";
            case "chat": return "Discuter avec ton Compagnon";
            case "chat_btn": return "Discuter avec ";
            case "back": return "← Retour";
            case "send": return "Envoyer";
            default: return key;
        }
    }
}
