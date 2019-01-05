import javax.swing.*;
import java.util.Scanner;

public class MoneyManage extends ManageSystem {
    String UserName;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    @Override
    public void inputInitialInfo(String userName) {
        System.out.println("用戶姓名為："+userName);
    }

    @Override
    public void inputName() {
        System.out.println("input name");

    }

    @Override
    public void chooseCategory() {
        System.out.println("choose Category");

    }

    @Override
    public void choosePriority() {
        System.out.println("choose Priority");

    }

    @Override
    public boolean askContinue() {
        String decision;
        Scanner scanner = new Scanner(System.in);
        //詢問是否添加物件
        System.out.println("是否添加需要购买的物件(Yes/No):");
        decision = scanner.nextLine();
        if (decision.equals("Yes")||decision.equals("yes")){
            return true;
        }else if (decision.equals("No")||decision.equals("no")){
            return false;
        }else {
            System.out.println("輸入錯誤！");
            return false;
        }
    }

    @Override
    public void output() {
        System.out.println("Output");

    }

/*    public static void main(String[] args) {
        ManageSystem moneyManage = new MoneyManage();
        TestForm testForm = new TestForm();
        JFrame frame = new JFrame("TestForm");
        frame.setContentPane(testForm.Panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }*/
}
