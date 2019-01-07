import javax.swing.*;

public class RationButton {
    //選擇RadioButton
    public static JRadioButton selectRadioButton(JRadioButton rb1,JRadioButton rb2,JRadioButton rb3){
        if (rb1.isSelected()){
            return rb1;
        }else if (rb2.isSelected()){
            return rb2;
        }else {
            return rb3;
        }
    }
    //判斷RadioButton是否被選中
    public static boolean checkRationButton(JRadioButton rb1,JRadioButton rb2,JRadioButton rb3){
        if ((rb1.isSelected()||rb2.isSelected()||rb3.isSelected())==false){
            return false;
        }else {
            return true;
        }
    }
}
