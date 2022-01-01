import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class ActivityForm extends  JFrame implements ActionListener {
    JCheckBox checkBox;
    JPanel panel,actPanel;
    JLabel activityLabel;
    JButton addActivitybButton;
    ArrayList<Activities> acts = new ArrayList<>();

    ActivityForm(){
        activityLabel = new JLabel();
        activityLabel.setText("Activity");
        checkBox = new JCheckBox();
        addActivitybButton = new JButton("Add Activity");

        addActivitybButton.addActionListener(this::actionPerformed);
        panel = new JPanel();
        panel.add(activityLabel);
        panel.add(checkBox);
        panel.add(addActivitybButton);
        add(panel, BorderLayout.CENTER);


    }
    public void addActivity(){
        JButton approveButton = new JButton("Confirm");
        actPanel = new JPanel(new GridLayout());
        JFrame f= new JFrame("Add Activity");
        JTextField t1;
        DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
        t1=new JTextField();
        t1.setBounds(50,100, 200,30);
        JFormattedTextField t2 = new JFormattedTextField(dateFormat);
        t2.setValue(new Date());
        Date startdate = (Date)t2.getValue();
        t2.setBounds(50,150, 200,30);
        approveButton.setBounds(100, 200, 50, 20);
        f.add(t1);
        f.add(t2);
        f.add(approveButton);
        f.setSize(300,200);
        f.setLayout(new GridLayout(3,1,10,50));
        f.setVisible(true);

        approveButton.addActionListener(e -> {
            Activities act = new Activities(t1.getText(),startdate,false);
            System.out.println("activity added");
            acts.add(act);
        });

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        addActivity();
    }
}
