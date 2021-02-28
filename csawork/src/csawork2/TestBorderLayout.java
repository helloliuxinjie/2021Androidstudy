package csawork2;

import java.awt.*;

/**
 * @author Liuxinjie
 * @version 1.0
 * @date 2021/2/20 020 15:35
 * @software IDEA
 */
public class TestBorderLayout {
    public static void main(String[] args) {
//        Frame frame = new Frame("testborderLayaout");
        Frame frame = new Frame("testGridLayaout");

        Button east = new Button("东");
        Button west = new Button("西");
        Button north = new Button("北");
        Button south= new Button("南");
        Button center= new Button("中");

        frame.setLayout(new GridLayout(2,3));

        frame.add(east,BorderLayout.EAST);
        frame.add(west,BorderLayout.WEST);
        frame.add(north,BorderLayout.NORTH);
        frame.add(south,BorderLayout.SOUTH);
        frame.add(center,BorderLayout.CENTER);

        frame.add(east);
        frame.add(west);
        frame.add(north);
        frame.add(center);
        frame.add(south);


        frame.pack();
        frame.setSize(300,300);
        frame.setVisible(true);

    }
}
