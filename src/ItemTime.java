import java.util.Date;

public class ItemTime extends Item {
    private String begin;
    private String over;

    public ItemTime(String itemName, double cost, int category, int priority) {
        super(itemName, cost, category, priority);
    }

    public ItemTime(String itemName, double cost, int category, int priority,String begin,String over ) {
        super(itemName, cost, category, priority);
        this.begin = begin;
        this.over = over;
    }

    public String getBeginTime(){
        return begin;
    }

    public String getOverTime(){
        return over;
    }

    public String backTimeCategory(){
        if (getCategory()==3){
            return "承諾時間";
        }else if (getCategory()==2){
            return "維護時間";
        }else {
            return "自由支配時間";
        }
    }

    public String backTimePriority(){
        if (getPriority()==3){
            return "緊急";
        }else if (getPriority()==2){
            return "重要";
        }else {
            return "不重要";
        }
    }
}
