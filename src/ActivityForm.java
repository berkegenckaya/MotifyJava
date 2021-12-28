import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActivityForm extends  JFrame implements ActionListener {
    JCheckBox checkBox;
    JPanel panel;
    JLabel activityLabel;

    ActivityForm(){
        activityLabel = new JLabel();
        activityLabel.setText("Activity");
        checkBox = new JCheckBox();

        panel = new JPanel();
        panel.add(activityLabel);
        panel.add(checkBox);
        add(panel, BorderLayout.CENTER);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
