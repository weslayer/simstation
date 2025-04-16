package prisoners;

import mvc.*;
import javax.swing.*;
import java.awt.*;

public class PrisonersPanel extends AppPanel {
    public PrisonersPanel(AppFactory factory) {
        super(factory);
        initControlPanel();
    }

    private void initControlPanel() {
        // Set layout for control panel
        controlPanel.setLayout(new GridLayout(5, 1, 2, 2));
        
        String[] commands = factory.getEditCommands();
        for (String command : commands) {
            JButton button = new JButton(command);
            button.addActionListener(this);
            controlPanel.add(button);
        }
    }
} 