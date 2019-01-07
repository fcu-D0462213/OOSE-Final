import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeSet;

public class TimeManage extends ManageSystem {
    private String userName;
    private Date beginTime;
    private Date overTime;
    private double totalTime;
    TreeSet<Item> timeItems = new TreeSet<Item>();

    //String转日期
    public Date StrToData(String str) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date date = null;
        date = format.parse(str);
        return date;
    }

    //日期转String

    public double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getOverTime() {
        return overTime;
    }

    public void setOverTime(Date overTime) {
        this.overTime = overTime;
    }

    //計算時間差
    public double calculateTotalTime(Date beginTime,Date overTime){
        //System.out.println("結束時間getTime:"+overTime.getTime()+"開始時間getTime："+beginTime.getTime());
        double x = ((double)(beginTime.getTime())-(double)(overTime.getTime()))/(60*60*1000);
        return x;
    }

    @Override
    public void inputInitialInfo(String userName, Double totalTime) {
        setUserName(userName);
        setTotalTime(totalTime);
    }

    @Override
    public int chooseCategory(String category) {
        int virtualCategory;
        if (category.equals("承諾時間")){
            virtualCategory = 3;
        }else if (category.equals("維護時間")){
            virtualCategory = 2;
        }else {
            virtualCategory = 1;
        }
        return virtualCategory;
    }

    @Override
    public int choosePriority(String priority) {
        int virtualPriority;
        if (priority.equals("緊急")) {
            virtualPriority = 3;
        }else if (priority.equals("重要")){
            virtualPriority = 2;
        }else {
            virtualPriority = 1;
        }
        return virtualPriority;
    }

    @Override
    public void addItem(String itemName, double cost, int category, int priority) {
        Item item = new Item(itemName,cost,category,priority);
        timeItems.add(item);
    }


    @Override
    public void output() {

    }
}
