package composite;

import composite.editor.ImageEditor;
import composite.shapes.concreteShapes.Circle;
import composite.shapes.concreteShapes.CompoundShape;
import composite.shapes.concreteShapes.Dot;
import composite.shapes.concreteShapes.Rectangle;

import static java.awt.Color.BLUE;
import static java.awt.Color.GREEN;
import static java.awt.Color.RED;

public final class Demo {

    public static void main(final String[] args) {
        final ImageEditor editor = new ImageEditor();

        editor.loadShapes(
                new Circle(10, 10, 10, BLUE),

                new CompoundShape(
                        new Circle(110, 110, 50, RED),
                        new Dot(160, 160, RED)
                ),

                new CompoundShape(
                        new Rectangle(250, 250, 100, 100, GREEN),
                        new Dot(240, 240, GREEN),
                        new Dot(240, 360, GREEN),
                        new Dot(360, 360, GREEN),
                        new Dot(360, 240, GREEN)
                )
        );

    }

}
