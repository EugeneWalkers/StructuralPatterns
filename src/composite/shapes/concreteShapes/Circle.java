package composite.shapes.concreteShapes;

import java.awt.Color;
import java.awt.Graphics;

import composite.shapes.BaseShape;

public class Circle extends BaseShape {

    private int radius;

    public Circle(final int x, final int y, final int radius, final Color color) {
        super(x, y, color);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(final int radius) {
        this.radius = radius;
    }

    @Override
    public int getWidth() {
        return radius * 2;
    }

    @Override
    public int getHeight() {
        return radius * 2;
    }

    public void paint(final Graphics graphics) {
        super.paint(graphics);
        graphics.drawOval(x, y, getWidth() - 1, getHeight() - 1);
    }
}