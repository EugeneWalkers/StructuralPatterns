package composite.shapes.concreteShapes;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import composite.shapes.BaseShape;
import composite.shapes.Shape;

public class CompoundShape extends BaseShape {
    protected List<Shape> children = new ArrayList<>();

    public CompoundShape(final Shape... components) {
        super(0, 0, Color.BLACK);
        add(components);
    }

    public void add(final Shape component) {
        children.add(component);
    }

    public void add(final Shape... components) {
        children.addAll(Arrays.asList(components));
    }

    public void remove(final Shape child) {
        children.remove(child);
    }

    public void remove(final Shape... components) {
        children.removeAll(Arrays.asList(components));
    }

    public void clear() {
        children.clear();
    }

    @Override
    public int getX() {
        if (children.isEmpty()) {
            return 0;
        }
        int x = children.get(0).getX();
        for (final Shape child : children) {
            if (child.getX() < x) {
                x = child.getX();
            }
        }
        return x;
    }

    @Override
    public int getY() {
        if (children.isEmpty()) {
            return 0;
        }
        int y = children.get(0).getY();
        for (final Shape child : children) {
            if (child.getY() < y) {
                y = child.getY();
            }
        }
        return y;
    }

    @Override
    public int getWidth() {
        int maxWidth = 0;
        final int x = getX();
        for (final Shape child : children) {
            final int childsRelativeX = child.getX() - x;
            final int childWidth = childsRelativeX + child.getWidth();
            if (childWidth > maxWidth) {
                maxWidth = childWidth;
            }
        }
        return maxWidth;
    }

    @Override
    public int getHeight() {
        int maxHeight = 0;
        final int y = getY();
        for (final Shape child : children) {
            final int childsRelativeY = child.getY() - y;
            final int childHeight = childsRelativeY + child.getHeight();
            if (childHeight > maxHeight) {
                maxHeight = childHeight;
            }
        }
        return maxHeight;
    }

    @Override
    public void move(final int x, final int y) {
        for (final Shape child : children) {
            child.move(x, y);
        }
    }

    @Override
    public boolean isInsideBounds(final int x, final int y) {
        for (final Shape child : children) {
            if (child.isInsideBounds(x, y)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void unSelect() {
        super.unSelect();
        for (final Shape child : children) {
            child.unSelect();
        }
    }

    public boolean selectChildAt(final int x, final int y) {
        for (final Shape child : children) {
            if (child.isInsideBounds(x, y)) {
                child.select();
                return true;
            }
        }
        return false;
    }

    @Override
    public void paint(final Graphics graphics) {
        if (isSelected()) {
            enableSelectionStyle(graphics);
            graphics.drawRect(getX() - 1, getY() - 1, getWidth() + 1, getHeight() + 1);
            disableSelectionStyle(graphics);
        }

        for (final Shape child : children) {
            child.paint(graphics);
        }
    }
}