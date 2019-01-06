public class Item implements Comparable{
    private String itemName;
    private double cost;
    private int category;
    private int priority;

    public Item(String itemName, double cost, int category, int priority) {
        this.itemName = itemName;
        this.cost = cost;
        this.category = category;
        this.priority = priority;
    }

    public String getItemName() {
        return itemName;
    }

    public double getCost() {
        return cost;
    }

    public int getCategory() {
        return category;
    }

    public int getPriority() {
        return priority;
    }

    public String backCategory(){
        if (getCategory()==3){
            return "固定必要開銷";
        }else if (getCategory()==2){
            return "靈活必要開銷";
        }else {
            return "自由支配開銷";
        }
    }

    public String backPriority(){
        if (getPriority()==3){
            return "重要";
        }else if (getPriority()==2){
            return "次要";
        }else {
            return "不重要";
        }
    }

    //重寫比較
    @Override
    public int compareTo(Object o) {

        Item item = (Item) o;
        if (this.getCategory()>item.getCategory()){
            return -1;
        }else if (this.getCategory()==item.getCategory()){
            if (this.getPriority()>item.getPriority()){
                return -1;
            }else if (this.getPriority()<item.getPriority()){
                return 1;
            }else {
                if (this.getItemName().compareTo(item.getItemName())==0&&this.getCost()==item.getCost()){
                    return 0;
                }else {
                    return -1;
                }
            }
        }else {
            return 1;
        }
    }
}
