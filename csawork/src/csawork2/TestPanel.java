package csawork2;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Liuxinjie
 * @version 1.0
 * @date 2021/2/20 020 14:36
 * @software IDEA
 */
// panel 是在容器里面的,可以看成一个空间, 但是不能单独存在
public class
TestPanel {
    public static void main(String[] args) {
        Frame frame=new Frame();
        Panel panel=new Panel();
        //设置布局
        frame.setLayout(null);

        //坐标
        frame.setBounds(200,300,200,300);
        frame.setBackground(new Color(145, 45, 61));

        //panel 设置坐标,相对于frame
        panel.setBackground(new Color(56, 241, 77));
        panel.setBounds(50,50,100,100);

        //panel在Frame里面
        frame.add(panel);

        frame.setVisible(true);

        //监听事件,监听窗口关闭事件, 强制退出使用System.exit(0);
        //适配器模型:
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }
}
