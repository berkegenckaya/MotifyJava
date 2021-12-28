import java.util.Date;

public class Activities {
    public String name;
    public Date startDate;
    public Date endDate;
    public boolean isDone;

    public Activities(){
        name = null;
        startDate = null;
        endDate = null;
        isDone = false;
    }
    public Activities(String name,Date startDate , Date endDate , boolean isDone){
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isDone=isDone;
    }

    public String getName() {
        return name;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void isActivityDone(boolean controller){

    }

}
