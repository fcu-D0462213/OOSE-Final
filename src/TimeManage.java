import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.TreeSet;

public class TimeManage extends ManageSystem {
    private String userName;
    private Date beginTime;
    private Date overTime;
    private double totalTime;
    TreeSet<ItemTime> timeItems = new TreeSet<ItemTime>();

    //String转日期
    public Date StrToDate(String str) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date date = null;
        date = format.parse(str);
        return date;
    }

    //日期转String
    public String DateToStr(Date data){

        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        String str = format.format(data);
        return str;
    }

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

    public void addItem(String itemName, double cost, int category, int priority,String begin,String over) {
        ItemTime item = new ItemTime(itemName,cost,category,priority,begin,over);
        timeItems.add(item);
    }

    public   void addItem(String itemName, double cost, int category, int priority) {

    }


    @Override
    public void output() {
        double sum = 0.0,remain=0.0;
        int flag=0;
        String begin="",over="",tmp="",subbegin="";
        double b=0.0,o=0.0;
        Iterator<ItemTime> itemIterator = timeItems.iterator();
        while(itemIterator.hasNext()){
            ItemTime item = itemIterator.next();
            sum += item.getCost();
            remain = getTotalTime()-sum;
            if(sum<=getTotalTime()){

                if(flag==0){
                    System.out.println("可支配時間從 "+item.getBeginTime()+"到"+item.getOverTime()+" 共可支配總時間："+getTotalTime()+"時");
                    begin=item.getBeginTime(); //第一每段開始
                    flag=1;
                }
                try {
                    b=((double)(StrToDate(begin).getTime()))/(60*60*1000)+8.0;
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                o = b+item.getCost();
                if(o<10){
                    tmp="0"+String.valueOf((int)o);
                } else {
                    tmp=String.valueOf((int)o);
                }
                subbegin = begin.substring(0,2);
                over=begin.replaceFirst(subbegin,tmp);
                System.out.println(begin+"--"+over+"  "+"活動："+item.getItemName()+"  "+"剩餘可支配時間："+remain+"時");
                begin= over;

            }
            else if(sum>getTotalTime()){
                System.out.println("超出支配時間");
                break;
            }
            else {
                System.out.println("無其他可支配！");
                break;
            }
        }


    }
}
