import java.util.Scanner;

abstract class ManageSystem {

    final void PutInformation(){
        boolean flag;
        //inputInitialInfo();
        /*if (SystemNum == 1){
            System.out.println("請輸入可支配的總時間數：");
            int totalTime = scanner.nextInt();
            System.out.println("請輸入要加入的事件數量：");
            obNum = scanner.nextInt();
        }else if (SystemNum == 2){
            System.out.println("請輸入可支配的總金錢數目：");
            int totalMoney = scanner.nextInt();
            System.out.println("請輸入要購買的物品數量：");
            obNum = scanner.nextInt();
        }else {
            System.out.println("輸入錯誤，請重新輸入！");
        }*/
        /*while(flag=askContinue()){
            //inputName();
            //chooseCategory();
            //choosePriority();
            //flag=askContinue();
        }*/
        output();

    }
    public abstract void inputInitialInfo(String userName,Double totalMoney);//输入初始信息
    public abstract int chooseCategory(String category);//選擇分類
    public abstract int choosePriority(String priority);//選擇優先度
    public abstract boolean askContinue();//詢問是否添加
    public abstract void output();//输出的抽象方法
}
