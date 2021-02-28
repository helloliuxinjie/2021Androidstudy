package csawork2;

import java.awt.*;

/**
 * @author Liuxinjie
 * @version 1.0
 * @date 2021/2/20 020 15:13
 * @software IDEA
 */
public class TestFlowLayout {
    public static void main(String[] args) {
        Frame frame=new Frame();
        //组件:按钮
        // 快捷写法: 先new Button();然后Alt+enter+enter+enter;
        Button button1 = new Button();
        Button button2= new Button();
        Button button3 = new Button();

        //设置为流式布局
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));
        frame.setSize(200,200);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.setVisible(true);
    }
}
