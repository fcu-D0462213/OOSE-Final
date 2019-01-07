import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeManage extends ManageSystem {
    private String userName;
    private String sbeginTime;
    private String soverTime;
    private Date beginTime;
    private Date overTime;
    private double totalTime;

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
        return 0;
    }

    @Override
    public int choosePriority(String priority) {
        return 0;
    }

    @Override
    public void addItem(String itemName, double cost, int category, int priority) {

    }


    @Override
    public void output() {

    }
}
