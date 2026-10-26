import javax.swing.*;
import java.awt.*;

public class AppGUI extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private UserProfile user;

    public AppGUI() {
        setTitle("Dia-Buddy App");
        setSize(500, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        OnboardingWizard onboarding = new OnboardingWizard(this);
        mainPanel.add(onboarding, "Onboarding");

        add(mainPanel);
        cardLayout.show(mainPanel, "Onboarding");
    }

    public void launchMainApp(UserProfile profile) {
        this.user = profile;

        JPanel dashboardScreen = createDashboardScreen();
        CuisineScreen cuisineScreen = new CuisineScreen(user, e -> cardLayout.show(mainPanel, "Dashboard"));
        ChatScreen chatScreen = new ChatScreen(user, () -> cardLayout.show(mainPanel, "Dashboard"));

        mainPanel.add(dashboardScreen, "Dashboard");
        mainPanel.add(cuisineScreen, "Cuisine");
        mainPanel.add(chatScreen, "Chat");

        cardLayout.show(mainPanel, "Dashboard");
    }

    private JPanel createDashboardScreen() {
        JPanel panel = new JPanel(new BorderLayout(15, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel topPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        JLabel welcomeLabel = new JLabel(
            Localization.get(user.getLanguagePreference(), "welcome") + " " + user.getNickname() + "!", 
            SwingConstants.CENTER
        );
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel subLabel = new JLabel(
            Localization.get(user.getLanguagePreference(), "dashboard"), 
            SwingConstants.CENTER
        );
        subLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        subLabel.setForeground(Color.GRAY);

        topPanel.add(welcomeLabel);
        topPanel.add(subLabel);
        panel.add(topPanel, BorderLayout.NORTH);

        JPanel companionCard = new JPanel(new BorderLayout(10, 10));
        companionCard.setBorder(BorderFactory.createTitledBorder("Your Companion"));
        
        String avatarEmoji = getAvatarEmoji(user.getAnimalType());
        JLabel avatarLabel = new JLabel(avatarEmoji, SwingConstants.CENTER);
        avatarLabel.setFont(new Font("Serif", Font.PLAIN, 64));

        JLabel companionDetails = new JLabel(
            "<html><center><b>" + user.getCompanionName() + "</b> (" + user.getAnimalType() + ")<br>" +
            "Focus: " + user.getDiabetesType() + "<br>" +
            "Cuisine: " + user.getCuisinePreference() + "</center></html>",
            SwingConstants.CENTER
        );
        companionDetails.setFont(new Font("SansSerif", Font.PLAIN, 14));

        companionCard.add(avatarLabel, BorderLayout.CENTER);
        companionCard.add(companionDetails, BorderLayout.SOUTH);
        panel.add(companionCard, BorderLayout.CENTER);

        JPanel navPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        JButton foodCoachBtn = new JButton(Localization.get(user.getLanguagePreference(), "food_coach"));
        foodCoachBtn.setFont(new Font("Arial", Font.BOLD, 14));
        foodCoachBtn.addActionListener(e -> cardLayout.show(mainPanel, "Cuisine"));

        JButton chatBtn = new JButton(
            Localization.get(user.getLanguagePreference(), "chat_btn") + user.getCompanionName() + " 💬"
        );
        chatBtn.setFont(new Font("Arial", Font.BOLD, 14));
        chatBtn.setBackground(new Color(33, 150, 243));
        chatBtn.setForeground(Color.WHITE);
        chatBtn.addActionListener(e -> cardLayout.show(mainPanel, "Chat"));

        navPanel.add(foodCoachBtn);
        navPanel.add(chatBtn);
        panel.add(navPanel, BorderLayout.SOUTH);

        return panel;
    }

    private String getAvatarEmoji(String animalType) {
        if (animalType == null) return "🐰";
        switch (animalType.toLowerCase().trim()) {
            case "cat": return "🐱";
            case "dog": return "🐶";
            case "fox": return "🦊";
            case "panda": return "🐼";
            case "bunny": return "🐰";
            default: return "🐾";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AppGUI().setVisible(true);
        });
    }
}
