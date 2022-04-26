package com.company;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Circle  {
    public final int x1, y1, width, height;

    public Circle(int centerX, int centerY, int radius)
    {
        this.x1 = centerX - radius;
        this.y1 = centerY - radius;
        this.width = radius * 2;
        this.height = radius * 2;
    }

    public void draw(Graphics2D g, Color c)
    {
        g.setColor(c);
        g.fillOval(this.x1, this.y1, this.width, this.height);
        //g.drawOval(this.x1, this.y1, this.width, this.height);
    }

}
