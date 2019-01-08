import java.util.Date;

public class ItemMoney extends Item {


    public ItemMoney(String itemName, double cost, int category, int priority) {
        super(itemName, cost, category, priority);
    }



    public String backMoneyCategory(){
        if (getCategory()==3){
            return "固定必要開銷";
        }else if (getCategory()==2){
            return "靈活必要開銷";
        }else {
            return "自由支配開銷";
        }
    }

    public String backMoneyPriority(){
        if (getPriority()==3){
            return "重要";
        }else if (getPriority()==2){
            return "次要";
        }else {
            return "不重要";
        }
    }

}
