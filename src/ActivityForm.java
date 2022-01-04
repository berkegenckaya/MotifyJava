import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ActivityForm extends  JFrame implements ActionListener {
    JCheckBox checkBox;

    JLabel activityLabel;
    ArrayList<Activities> acts = new ArrayList<>();
    JFrame  activities ;
    ActivityForm(){
        activities = new JFrame("Main Screen");
        activities.setSize(600,600);
        JButton addActivityButton = new JButton("Add Activity");
        addActivityButton.setBounds(100, 200, 50, 20);
        JPanel panel = new JPanel();
        panel.add(addActivityButton);
        activities.add(panel);
        activities.setVisible(true);
        addActivityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addActivity();
            }
        });
    }
    public void addActivity(){
        JButton approveButton = new JButton("Confirm");
        JFrame f= new JFrame("Add Activity");
        JTextField t1;
        t1=new JTextField();
        t1.setBounds(50,100, 200,30);
        approveButton.setBounds(100, 200, 50, 20);
        f.add(t1);
        Date today = new Date();
        JSpinner spinner = new JSpinner(new SpinnerDateModel(today, null, null, Calendar.MONTH));
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "dd/MM/yy");
        spinner.setEditor(editor);
        f.add(spinner);
        f.add(approveButton);
        f.setSize(300,200);
        f.setLayout(new GridLayout(3,1,10,50));
        f.setVisible(true);

        approveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createActComponent(t1.getText(),spinner.getValue().toString(),activities);
                f.setVisible(false);
            }
        });
    }
    public void createActComponent(String name ,String endDate,JFrame frame){
        JPanel ActPanel = new JPanel(new FlowLayout());
        JLabel actNameLabel = new JLabel(name);
        actNameLabel.add(ActPanel);
        JLabel dateLabel = new JLabel(String.valueOf(endDate));
        dateLabel.add(ActPanel);
        ActPanel.setBackground(Color.GRAY);
        ActPanel.setVisible(true);
        frame.add(ActPanel);
        frame.repaint();
        frame.revalidate();

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        addActivity();
    }
}
