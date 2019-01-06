import javax.swing.*;
import java.util.*;
import java.util.TreeSet;
public class MoneyManage extends ManageSystem {
    private String userName;
    private double totalMoney;
    TreeSet<Item> moneyItems =new TreeSet<Item>();

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public void inputInitialInfo(String userName, Double totalMoney) {
        setUserName(userName);
        setTotalMoney(totalMoney);
    }

    @Override
    public int chooseCategory(String category) {
        int virtualCategory;
        if (category.equals("固定必要開銷")){
            virtualCategory = 3;
        }else if (category.equals("靈活必要開銷")){
            virtualCategory = 2;
        }else {
            virtualCategory = 1;
        }
        return virtualCategory;
    }

    @Override
    public int choosePriority(String priority) {
        int virtualPriority;
        if (priority.equals("重要")) {
            virtualPriority = 3;
        }else if (priority.equals("次要")){
            virtualPriority = 2;
        }else {
            virtualPriority = 1;
        }
        return virtualPriority;
    }

    @Override
    public void addItem(String itemName, double cost, int category, int priority) {
        Item item = new Item(itemName,cost,category,priority);
        moneyItems.add(item);
    }

    @Override
    public boolean askContinue() {
        String decision;
        Scanner scanner = new Scanner(System.in);
        //詢問是否添加物件
        System.out.println("是否添加需要购买的物件(Yes/No):");
        decision = scanner.nextLine();
        if (decision.equals("Yes") || decision.equals("yes")) {
            return true;
        } else if (decision.equals("No") || decision.equals("no")) {
            return false;
        } else {
            System.out.println("輸入錯誤！");
            return false;
        }
    }

    @Override
    public void output() {
        System.out.println("Output");

    }

    public static void main(String[] args) {
        //ManageSystem moneyManage = new MoneyManage();
        /*TreeSet<Item> moneyItems =new TreeSet<Item>();
        moneyItems.add(new Item("一",50,3,2));
        moneyItems.add(new Item("二",55,3,5));
        moneyItems.add(new Item("三",56,3,1));
        moneyItems.add(new Item("四",57,4,2));
        moneyItems.add(new Item("五",58,2,2));
        moneyItems.add(new Item("一",50,3,2));
        Iterator<Item> itemIterator = moneyItems.iterator();
        while (itemIterator.hasNext()){
            Item moneyItem = itemIterator.next();
            System.out.println("name:"+moneyItem.getItemName()+",money:"+moneyItem.getCost()+",category:"+moneyItem.getCategory()+",priority:"+
            moneyItem.getPriority());
        }*/

        //moneyManage.PutInformation();
    }
}