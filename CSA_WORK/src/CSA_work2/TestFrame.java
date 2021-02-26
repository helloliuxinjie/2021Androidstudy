package CSA_work2;

import java.awt.*;

/**
 * @author Liuxinjie
 * @version 1.0
 * @date 2021/2/20 020 12:42
 * @software IDEA
 */
public class TestFrame {
    public static void main(String[] args) {
        // 类怎么用: 查jdk? no, 直接查看源码!可以通过左侧的project structure来查看源码有那些方法和类
        GameFrame gameFrame1=new GameFrame(100,100,200,200,Color.green);//有个快捷键:Ctrl+d 可以复制当前代码到下一行
        GameFrame gameFrame2=new GameFrame(200,100,200,200,Color.green);
        GameFrame gameFrame3=new GameFrame(100,200,200,200,Color.green);
        GameFrame gameFrame4=new GameFrame(200,200,200,200,Color.green);
        GameFrame gameFrame5=new GameFrame(500,100,200,200,Color.green);
        GameFrame gameFrame6=new GameFrame(600,100,200,200,Color.green);

    }
}
class GameFrame extends Frame{
    static int id=0;// 可能存在多个窗口, 我们需要一个计数器
    public GameFrame(int x,int y,int w,int h,Color color){
        super("LXJ_Game: "+(++id));
        setBounds(x,y,w,h);
        setBackground(color);
        setResizable(false);
        setVisible(true);

    }
}
