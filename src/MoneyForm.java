import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

public class MoneyForm extends JFrame {
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
    private JButton FinishButton;
    private JLabel CategoryLabel;
    private JLabel PriorityLabel;
    private JPanel Panel3;
    private JLabel InitialInformationOutputLabel;
    private JLabel ItemOutputLabel;
    public JButton ConfirmButton;
    public JLabel ItemMoneyLabel;
    public JTextField ItemMoneyText;

    public MoneyForm() {
        super("MoneyManageSystem");
        setContentPane(Panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        MoneyForm moneyForm = new MoneyForm();
        ManageSystem moneyManage = new MoneyManage();

        //輸入信息按鈕實作
        moneyForm.InitialInformationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (moneyForm.NameText.getText().isEmpty()|| moneyForm.TotalMoneyText.getText().isEmpty()){
                    JOptionPane.showMessageDialog(moneyForm.Panel1,"您有信息還未輸入！請重新輸入！");
                    //System.out.println("您有信息還未輸入！請重新輸入！");
                }else {
                    moneyManage.inputInitialInfo(moneyForm.NameText.getText(),Double.parseDouble(moneyForm.TotalMoneyText.getText()));
                    moneyForm.InitialInformationOutputLabel.setText("您的姓名為："+ moneyForm.NameText.getText()+"，您的輸入的總金額為："
                    + moneyForm.TotalMoneyText.getText()+"元");
                    JOptionPane.showMessageDialog(moneyForm.Panel1,"OK！");
                }
            }
        });

        //輸入物件按鈕實作
        moneyForm.ItemOutputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (moneyForm.ItemNameText.getText().isEmpty()){
                    JOptionPane.showMessageDialog(moneyForm.Panel1,"開銷名稱未輸入！");
                    //System.out.println("開銷名稱未輸入！");
                }else if (moneyForm.ItemMoneyText.getText().isEmpty()){
                    JOptionPane.showMessageDialog(moneyForm.Panel1,"開銷金額未輸入！");
                    //System.out.println("開銷金額未輸入！");
                }else if (RationButton.checkRationButton(moneyForm.CategoryRadioButton1, moneyForm.CategoryRadioButton2, moneyForm.CategoryRadioButton3)==false){
                    JOptionPane.showMessageDialog(moneyForm.Panel1,"開銷種類未選擇！");
                    //System.out.println("開銷種類未選擇！");
                }else if (RationButton.checkRationButton(moneyForm.PriorityRadioButton1, moneyForm.PriorityRadioButton2, moneyForm.PriorityRadioButton3)==false){
                    JOptionPane.showMessageDialog(moneyForm.Panel1,"開銷優先度未選擇！");
                    //System.out.println("開銷優先度未選擇！");
                }else {
                    JOptionPane.showMessageDialog(moneyForm.Panel1,"OK！");
                    moneyForm.ItemOutputLabel.setText("您輸入的開銷名稱為："+ moneyForm.ItemNameText.getText()+"，該物品開銷為："+ moneyForm.ItemMoneyText.getText()
                            +"元，該物品的種類為："+RationButton.selectRadioButton(moneyForm.CategoryRadioButton1, moneyForm.CategoryRadioButton2, moneyForm.CategoryRadioButton3).getText()
                            +", 該物品的優先度為："+RationButton.selectRadioButton(moneyForm.PriorityRadioButton1, moneyForm.PriorityRadioButton2, moneyForm.PriorityRadioButton3).getText());
                }
            }
        });

        //加入item按钮实作
        moneyForm.ConfirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (moneyForm.ItemNameText.getText().isEmpty()|| moneyForm.ItemMoneyText.getText().isEmpty()||
                        (RationButton.checkRationButton(moneyForm.CategoryRadioButton1, moneyForm.CategoryRadioButton2, moneyForm.CategoryRadioButton3)==false)
                        || (RationButton.checkRationButton(moneyForm.PriorityRadioButton1, moneyForm.PriorityRadioButton2, moneyForm.PriorityRadioButton3)==false)){
                    JOptionPane.showMessageDialog(moneyForm.Panel1,"您還有信息未輸入！");
                    //System.out.println("您還有信息未輸入！");
                }else {
                    JOptionPane.showMessageDialog(moneyForm.Panel1,"確認添加！");
                    moneyManage.addItem(moneyForm.ItemNameText.getText(),Double.parseDouble(moneyForm.ItemMoneyText.getText()),
                            moneyManage.chooseCategory(RationButton.selectRadioButton(moneyForm.CategoryRadioButton1, moneyForm.CategoryRadioButton2, moneyForm.CategoryRadioButton3).getText()),
                            moneyManage.choosePriority(RationButton.selectRadioButton(moneyForm.PriorityRadioButton1, moneyForm.PriorityRadioButton2, moneyForm.PriorityRadioButton3).getText()));
                }
            }
        });

        //finish按钮实作
       moneyForm.FinishButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
                   JOptionPane.showMessageDialog(moneyForm.Panel1,"添加完成");
                   System.out.println("--------當前用戶信息----------");
                   System.out.println("姓名:"+((MoneyManage) moneyManage).getUserName()+",金錢總量:"+((MoneyManage) moneyManage).getTotalMoney()+"元");
                   System.out.println("--------規劃開銷項目---------");
                   Iterator<Item> itemIterator = ((MoneyManage) moneyManage).moneyItems.iterator();
                   while (itemIterator.hasNext()) {
                       Item moneyItem = itemIterator.next();
                       System.out.println("開銷名稱：" + moneyItem.getItemName() + ",所需金錢:" + moneyItem.getCost() + "元,開銷種類:" + moneyItem.backMoneyCategory() + ",開銷優先度:" +
                               moneyItem.backMoneyPriority());
                   }

           }
       });

        //output按钮实作
        moneyForm.OutputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(moneyForm.Panel1,"輸出成功！");
                moneyManage.InformationOutput(((MoneyManage) moneyManage).getUserName());
            }
        });
    }


}
