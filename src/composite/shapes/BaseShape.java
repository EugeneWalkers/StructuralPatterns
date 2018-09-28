package composite.shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public abstract class BaseShape implements Shape {

    protected int x;
    protected int y;
    protected Color color;
    private boolean selected = false;

    protected BaseShape(final int x, final int y, final Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    protected void enableSelectionStyle(final Graphics graphics) {
        graphics.setColor(Color.LIGHT_GRAY);

        final Graphics2D g2 = (Graphics2D) graphics;
        final float[] dash1 = {2.0f};
        g2.setStroke(new BasicStroke(1.0f,
                BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER,
                2.0f, dash1, 0.0f));
    }

    protected void disableSelectionStyle(final Graphics graphics) {
        graphics.setColor(color);
        final Graphics2D g2 = (Graphics2D) graphics;
        g2.setStroke(new BasicStroke());
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public void move(final int x, final int y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public boolean isInsideBounds(final int x, final int y) {
        return x > getX() && x < (getX() + getWidth()) &&
                y > getY() && y < (getY() + getHeight());
    }

    @Override
    public void select() {
        selected = true;
    }

    @Override
    public void unSelect() {
        selected = false;
    }

    @Override
    public boolean isSelected() {
        return selected;
    }

    @Override
    public void paint(final Graphics graphics) {
        if (isSelected()) {
            enableSelectionStyle(graphics);
        } else {
            disableSelectionStyle(graphics);
        }

        // ...
    }
}