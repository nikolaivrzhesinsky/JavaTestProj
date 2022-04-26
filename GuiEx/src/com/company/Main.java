package com.company;

import javax.swing.*;
import java.awt.*;

public class Main extends JComponent
{
    public static void main(String[] args)
    {
        JFrame f = new JFrame();

        f.setSize(400, 400);
        f.setVisible(true);

        f.add(new TestComponent());
    }

    private static final class TestComponent extends JComponent
    {
        @Override
        public void paint(Graphics g)
        {
            Graphics2D g2d = (Graphics2D) g;

            g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,
                    0, new float[]{9}, 0));
            Triangle t = new Triangle(this.getWidth() / 2, 0, 0, this.getHeight() - 2, this.getWidth(), this.getHeight() - 2);
            t.draw(g2d);

            Circle c = t.inscribedCircle();
            c.draw(g2d, Color.ORANGE);
        }
    }


}



