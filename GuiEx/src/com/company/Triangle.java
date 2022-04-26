package com.company;

import java.awt.*;

public class Triangle {
    public final int x1, y1, x2, y2, x3, y3; // point 1 must be top point

    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    public void draw(Graphics2D g)
    {
        g.drawPolygon(new int[] { x1, x2, x3 },  new int[] { y1, y2, y3 }, 3);
    }
    private float length(int x1, int y1, int x2, int y2)
    {
        return (float) Math.sqrt(
                Math.pow((x2 - x1), 2d) +
                        Math.pow((y2 - y1), 2d));
    }

    public Circle inscribedCircle()
    {
        float a = length(x1, y1, x2, y2);

        float b = length(x2, y2, x3, y3);

        int radius = (int) (b / 2f * (float) Math.sqrt((2f * a - b) / (2f * a + b)));

        int x1 = Math.abs(x3 - x2) / 2;
        int y1 = y2 - radius;

        return new Circle(x1, y1, radius);
    }
}
