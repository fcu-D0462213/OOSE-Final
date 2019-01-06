import java.util.Scanner;

abstract class ManageSystem {

    final void PutInformation(String userName,Double totalMoney){
        boolean flag;
        //inputInitialInfo(userName,totalMoney);
        output();

    }
    public abstract void inputInitialInfo(String userName,Double totalMoney);//输入初始信息
    public abstract int chooseCategory(String category);//選擇分類
    public abstract int choosePriority(String priority);//選擇優先度
    public abstract void addItem(String itemName, double cost, int category, int priority);
    public abstract boolean askContinue();//詢問是否添加
    public abstract void output();//输出的抽象方法
}
