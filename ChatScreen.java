import javax.swing.*;
import java.awt.*;

public class ChatScreen extends JPanel {
    private JTextArea chatLog;
    private JTextField inputField;
    private UserProfile user;

    public ChatScreen(UserProfile user, Runnable onBack) {
        this.user = user;
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel topPanel = new JPanel(new BorderLayout());
        JButton backButton = new JButton(Localization.get(user.getLanguagePreference(), "back"));
        backButton.addActionListener(e -> onBack.run());

        String avatarEmoji = getAvatarEmoji(user.getAnimalType());
        JLabel titleLabel = new JLabel(
            avatarEmoji + " " + user.getCompanionName() + " (" + user.getAnimalType() + ")", 
            SwingConstants.CENTER
        );
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));

        topPanel.add(backButton, BorderLayout.WEST);
        topPanel.add(titleLabel, BorderLayout.CENTER);
        add(topPanel, BorderLayout.NORTH);

        chatLog = new JTextArea();
        chatLog.setEditable(false);
        chatLog.setLineWrap(true);
        chatLog.setWrapStyleWord(true);
        chatLog.setFont(new Font("SansSerif", Font.PLAIN, 14));
        
        chatLog.setText("[" + user.getCompanionName() + "]: Hi " + user.getNickname() + 
            "! I'm here to help with your " + user.getCuisinePreference() + 
            " meal ideas and wellness goals. What can I do for you today?\n\n");

        JScrollPane scrollPane = new JScrollPane(chatLog);
        add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new BorderLayout(5, 5));
        inputField = new JTextField();
        JButton sendButton = new JButton(Localization.get(user.getLanguagePreference(), "send"));

        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
        add(inputPanel, BorderLayout.SOUTH);

        sendButton.addActionListener(e -> sendMessage());
        inputField.addActionListener(e -> sendMessage());
    }

    private void sendMessage() {
        String query = inputField.getText().trim();
        if (query.isEmpty()) return;

        chatLog.append("You: " + query + "\n");
        inputField.setText("");

        new Thread(() -> {
            String response = AIService.askDiaBuddy(user, query);
            SwingUtilities.invokeLater(() -> chatLog.append(response + "\n\n"));
        }).start();
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
}
