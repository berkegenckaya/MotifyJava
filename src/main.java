import java.util.Calendar;
import java.util.Date;

public class main {
    public static void main(String[] args) {

        //loginForm loginForm = new loginForm();
        //loginForm.setSize(300,100);
        //loginForm.setVisible(true);
        Activities act1 = new Activities("Water", new Date(2021, Calendar.DECEMBER,25,14,30),false);
        ActivityForm activityForm = new ActivityForm();
        activityForm.setSize(600,600);
        activityForm.setVisible(true);
    }
}
