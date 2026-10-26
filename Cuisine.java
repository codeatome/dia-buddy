import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class CuisineScreen extends JPanel {
    private JComboBox<String> cuisineDropdown;
    private JTextField customCuisineInput;
    private JTextArea suggestionsArea;
    private JLabel foodImageView;
    private UserProfile user;

    public CuisineScreen(UserProfile user, ActionListener onBack) {
        this.user = user;
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel topPanel = new JPanel(new BorderLayout());
        JButton backBtn = new JButton(Localization.get(user.getLanguagePreference(), "back"));
        backBtn.addActionListener(onBack);
        JLabel titleLabel = new JLabel("Cultural Food Coach", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        
        topPanel.add(backBtn, BorderLayout.WEST);
        topPanel.add(titleLabel, BorderLayout.CENTER);
        add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(1, 2, 10, 10));

        JPanel controlsPanel = new JPanel(new GridLayout(6, 1, 5, 5));
        controlsPanel.add(new JLabel("Select Preferred Cuisine:"));
        
        String[] cuisines = {"Indian", "Mexican", "Mediterranean", "American", "Asian", "Custom..."};
        cuisineDropdown = new JComboBox<>(cuisines);
        cuisineDropdown.setSelectedItem(user.getCuisinePreference());
        controlsPanel.add(cuisineDropdown);

        controlsPanel.add(new JLabel("Or Type Custom Cuisine:"));
        customCuisineInput = new JTextField();
        controlsPanel.add(customCuisineInput);

        JButton generateBtn = new JButton("Get Meal Recommendations");
        generateBtn.setBackground(new Color(76, 175, 80));
        generateBtn.setForeground(Color.WHITE);
        controlsPanel.add(generateBtn);

        centerPanel.add(controlsPanel);

        JPanel outputPanel = new JPanel(new BorderLayout(5, 5));
        
        foodImageView = new JLabel("Image Preview", SwingConstants.CENTER);
        foodImageView.setPreferredSize(new Dimension(150, 120));
        foodImageView.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        outputPanel.add(foodImageView, BorderLayout.NORTH);

        suggestionsArea = new JTextArea();
        suggestionsArea.setEditable(false);
        suggestionsArea.setLineWrap(true);
        suggestionsArea.setWrapStyleWord(true);
        outputPanel.add(new JScrollPane(suggestionsArea), BorderLayout.CENTER);

        centerPanel.add(outputPanel);
        add(centerPanel, BorderLayout.CENTER);

        generateBtn.addActionListener(e -> updateSuggestions());
    }

    private void updateSuggestions() {
        List<String> suggestions = CulturalFoodCoach.getMealSuggestions(user);
        StringBuilder sb = new StringBuilder("Recommended Options:\n\n");
        for (String item : suggestions) {
            sb.append("• ").append(item).append("\n\n");
        }
        suggestionsArea.setText(sb.toString());
        foodImageView.setText("[Food Coach]");
    }
}
