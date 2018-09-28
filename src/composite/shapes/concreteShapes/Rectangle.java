package composite.shapes.concreteShapes;

import java.awt.Color;
import java.awt.Graphics;

import composite.shapes.BaseShape;

public class Rectangle extends BaseShape {

    private int width;
    private int height;

    public Rectangle(final int x, final int y, final int width, final int height, final Color color) {
        super(x, y, color);
        this.width = width;
        this.height = height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(final int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(final int height) {
        this.height = height;
    }

    @Override
    public void paint(final Graphics graphics) {
        super.paint(graphics);
        graphics.drawRect(x, y, getWidth() - 1, getHeight() - 1);
    }
}