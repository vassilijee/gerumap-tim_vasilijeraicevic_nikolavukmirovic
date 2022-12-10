package dsw.gerumap.app.repository.implementation.elements;

import dsw.gerumap.app.gui.swing.view.painters.SubjectPainter;

import java.awt.*;

public class SubjectElement extends DiagramDevice {

    public SubjectElement(Point position, Dimension size, Stroke stroke, Paint paint) {
        super(position, size, stroke, paint);
        elementPainter = new SubjectPainter(this);
    }
}
