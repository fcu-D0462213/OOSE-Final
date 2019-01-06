
abstract class ManageSystem {

    final void InformationOutput(String userName){
        System.out.println("-----------用戶"+userName+"的規劃表如下----------");
        output();
    }
    public abstract void inputInitialInfo(String userName,Double totalMoney);//输入初始信息
    public abstract int chooseCategory(String category);//選擇分類
    public abstract int choosePriority(String priority);//選擇優先度
    public abstract void addItem(String itemName, double cost, int category, int priority);//加入物件
    public abstract void output();//输出
}
