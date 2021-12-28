import java.util.Date;

public class Activities {
    public String name;
    public Date startDate;
    public boolean isDone;

    public Activities(){
        name = null;
        startDate = null;
        isDone = false;
    }
    public Activities(String name,Date startDate, boolean isDone){
        this.name = name;
        this.startDate = startDate;
        this.isDone=isDone;
    }

    public String getName() {
        return name;
    }



    public Date getStartDate() {
        return startDate;
    }

    public void setName(String name) {
        this.name = name;
    }



    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void isActivityDone(boolean controller){

    }

}
