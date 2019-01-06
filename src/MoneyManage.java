import java.util.TreeSet;
public class MoneyManage extends ManageSystem {
    private String userName=null;
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
    public void output() {
        System.out.println("Output");
    }

}