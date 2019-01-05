import javax.swing.*;

public class JFrameTest {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Test");
        jFrame.setLocation(300,300);//设置窗体左上角与显示屏左上角的坐标，离显示屏上边缘300像素，离显示屏左边缘300像素
        jFrame.setSize(500,400);//设定大小
        jFrame.setResizable(true);//设定是否可以调整大小
        jFrame.setVisible(true);//设定可见
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);//关闭窗口
    }
}
