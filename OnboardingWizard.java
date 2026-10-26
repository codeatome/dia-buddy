import javax.swing.*;
import java.awt.*;

public class OnboardingWizard extends JPanel {
    private CardLayout layout;
    private JPanel cards;
    private AppGUI mainApp;

    private JTextField nameField, customAnimalField, companionNameField;
    private JComboBox<String> diabetesBox, animalBox, cuisineBox, languageBox;

    public OnboardingWizard(AppGUI mainApp) {
        this.mainApp = mainApp;
        layout = new CardLayout();
        cards = new JPanel(layout);
        setLayout(new BorderLayout());

        cards.add(createStep1(), "Step1");
        cards.add(createStep2(), "Step2");
        cards.add(createStep3(), "Step3");

        add(cards, BorderLayout.CENTER);
        layout.show(cards, "Step1");
    }

    private JPanel createStep1() {
        JPanel p = new JPanel(new GridLayout(6, 1, 10, 10));
        p.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        p.add(new JLabel("Welcome to Dia-Buddy! What is your nickname?"));
        nameField = new JTextField(); 
        p.add(nameField);

        p.add(new JLabel("Select your health focus / type:"));
        diabetesBox = new JComboBox<>(new String[]{"Type 1 Diabetes", "Type 2 Diabetes", "Prediabetes", "General Wellness"});
        p.add(diabetesBox);

        p.add(new JLabel("Select App Language:"));
        languageBox = new JComboBox<>(new String[]{"English", "Spanish", "French"});
        p.add(languageBox);

        JButton next = new JButton("Next →");
        next.addActionListener(e -> layout.show(cards, "Step2"));
        p.add(next);

        return p;
    }

    private JPanel createStep2() {
        JPanel p = new JPanel(new GridLayout(7, 1, 10, 10));
        p.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        p.add(new JLabel("Choose your animal companion avatar:"));
        animalBox = new JComboBox<>(new String[]{"🐰 Bunny", "🐱 Cat", "🐶 Dog", "🦊 Fox", "🐼 Panda", "✨ Custom..."});
        p.add(animalBox);

        p.add(new JLabel("Or Type Custom Animal:"));
        customAnimalField = new JTextField(); 
        p.add(customAnimalField);

        p.add(new JLabel("Name your companion:"));
        companionNameField = new JTextField("Luna"); 
        p.add(companionNameField);

        JPanel bp = new JPanel(new GridLayout(1, 2, 10, 10));
        JButton back = new JButton("← Back"); 
        back.addActionListener(e -> layout.show(cards, "Step1"));
        
        JButton next = new JButton("Next →"); 
        next.addActionListener(e -> layout.show(cards, "Step3"));
        
        bp.add(back); 
        bp.add(next);
        p.add(bp);

        return p;
    }

    private JPanel createStep3() {
        JPanel p = new JPanel(new GridLayout(4, 1, 10, 10));
        p.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        p.add(new JLabel("Select Preferred Cuisine Style:"));
        cuisineBox = new JComboBox<>(new String[]{"Indian", "Mexican", "Mediterranean", "American", "Asian"});
        p.add(cuisineBox);

        JButton finish = new JButton("Start Companion Journey 🚀");
        finish.setBackground(new Color(76, 175, 80));
        finish.setForeground(Color.WHITE);

        finish.addActionListener(e -> {
            String name = nameField.getText().trim();
            if (name.isEmpty()) name = "Friend";

            String animal = (String) animalBox.getSelectedItem();
            if ("✨ Custom...".equals(animal) && !customAnimalField.getText().trim().isEmpty()) {
                animal = customAnimalField.getText().trim();
            } else {
                animal = animal.replaceAll("[^a-zA-Z]", "").trim();
            }

            String compName = companionNameField.getText().trim();
            if (compName.isEmpty()) compName = "Buddy";

            UserProfile user = new UserProfile(
                name,
                (String) diabetesBox.getSelectedItem(),
                animal,
                compName,
                "Cheerful",
                (String) cuisineBox.getSelectedItem(),
                (String) languageBox.getSelectedItem()
            );

            mainApp.launchMainApp(user);
        });

        p.add(finish);
        return p;
    }
}
