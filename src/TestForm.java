import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class TestForm extends JFrame {
    private JPanel Panel1;
    private JButton OutputButton;
    private JPanel Panel2;
    private JTextField NameText;
    private JLabel NameLabel;
    private JLabel TotalMoneyLabel;
    private JButton InitialInformationButton;
    private JTextField TotalMoneyText;
    private JLabel ItemNameLabel;
    private JTextField ItemNameText;
    private JButton ItemOutputButton;
    private JRadioButton CategoryRadioButton1;
    private JRadioButton CategoryRadioButton2;
    private JRadioButton CategoryRadioButton3;
    private JRadioButton PriorityRadioButton1;
    private JRadioButton PriorityRadioButton2;
    private JRadioButton PriorityRadioButton3;
    private JButton ContinueButton;
    private JButton FinishButton;
    private JLabel CategoryLabel;
    private JLabel PriorityLabel;
    private JPanel Panel3;
    private JLabel InitialInformationOutputLabel;
    private JLabel ItemOutputLabel;
    public JButton ConfirmButton;
    public JLabel ItemMoneyLabel;
    public JTextField ItemMoneyText;

    public TestForm() {
        super("Test");
        setContentPane(Panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    //選擇RadioButton
    public JRadioButton selectRadioButton(JRadioButton rb1,JRadioButton rb2,JRadioButton rb3){
        if (rb1.isSelected()){
            return rb1;
        }else if (rb2.isSelected()){
            return rb2;
        }else {
            return rb3;
        }
    }
    //判斷RadioButton是否被選中
    public boolean checkRationButton(JRadioButton rb1,JRadioButton rb2,JRadioButton rb3){
        if ((rb1.isSelected()||rb2.isSelected()||rb3.isSelected())==false){
            return false;
        }else {
            return true;
        }
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        TestForm testForm = new TestForm();
        ManageSystem moneyManage = new MoneyManage();
        //輸入信息按鈕實作
        testForm.InitialInformationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (testForm.NameText.getText().isEmpty()||testForm.TotalMoneyText.getText().isEmpty()){
                    testForm.InitialInformationOutputLabel.setText("您有信息還未輸入！請重新輸入！");
                    //System.out.println("您有信息還未輸入！請重新輸入！");
                }else {
                    moneyManage.inputInitialInfo(testForm.NameText.getText(),Double.parseDouble(testForm.TotalMoneyText.getText()));
                    testForm.InitialInformationOutputLabel.setText("您的姓名為："+testForm.NameText.getText()+"，您的輸入的總金額為："
                    +testForm.TotalMoneyText.getText());
                }
            }
        });
        //輸入物件按鈕實作
        testForm.ItemOutputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (testForm.ItemNameText.getText().isEmpty()){
                    testForm.ItemOutputLabel.setText("開銷名稱未輸入！");
                    System.out.println("開銷名稱未輸入！");
                }else if (testForm.ItemMoneyText.getText().isEmpty()){
                    testForm.ItemOutputLabel.setText("開銷金額未輸入！");
                    System.out.println("開銷金額未輸入！");
                }else if (testForm.checkRationButton(testForm.CategoryRadioButton1,testForm.CategoryRadioButton2,testForm.CategoryRadioButton3)==false){
                    testForm.ItemOutputLabel.setText("開銷種類未選擇！");
                    System.out.println("開銷種類未選擇！");
                }else if (testForm.checkRationButton(testForm.PriorityRadioButton1,testForm.PriorityRadioButton2,testForm.PriorityRadioButton3)==false){
                    testForm.ItemOutputLabel.setText("開銷優先度未選擇！");
                    System.out.println("開銷優先度未選擇！");
                }else {
                    testForm.ItemOutputLabel.setText("您輸入的開銷名稱為："+testForm.ItemNameText.getText()+"，該物品開銷為："+testForm.ItemMoneyText.getText()
                            +"元，該物品的種類為："+testForm.selectRadioButton(testForm.CategoryRadioButton1,testForm.CategoryRadioButton2,testForm.CategoryRadioButton3).getText()
                            +", 該物品的優先度為："+testForm.selectRadioButton(testForm.PriorityRadioButton1,testForm.PriorityRadioButton2,testForm.PriorityRadioButton3).getText());
                }
            }
        });

        testForm.ConfirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (testForm.ItemNameText.getText().isEmpty()||testForm.ItemMoneyText.getText().isEmpty()||
                        (testForm.checkRationButton(testForm.CategoryRadioButton1,testForm.CategoryRadioButton2,testForm.CategoryRadioButton3)==false)
                        || (testForm.checkRationButton(testForm.PriorityRadioButton1,testForm.PriorityRadioButton2,testForm.PriorityRadioButton3)==false)){
                    testForm.ItemOutputLabel.setText("您還有信息未輸入！");
                    //System.out.println("您還有信息未輸入！");
                }else {

                    //testForm.ItemOutputLabel.setText("ok");
                    //System.out.println("ok!");
                }
            }
        });
        testForm.OutputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("user name:"+((MoneyManage) moneyManage).getUserName()+",user money:"+((MoneyManage) moneyManage).getTotalMoney());
            }
        });
    }


}
