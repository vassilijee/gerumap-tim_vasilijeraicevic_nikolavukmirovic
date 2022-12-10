package dsw.gerumap.app.gui.swing.view.painters;

import dsw.gerumap.app.repository.implementation.elements.DiagramElement;
import dsw.gerumap.app.repository.implementation.elements.SubjectElement;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class SubjectPainter extends DevicePainter {

    public SubjectPainter(DiagramElement device) {
        super(device);
        SubjectElement rectangle = (SubjectElement) device;

        shape = new GeneralPath();
        ((GeneralPath) shape).moveTo(rectangle.getPosition().x, rectangle.getPosition().y);

        ((GeneralPath) shape).lineTo(rectangle.getPosition().x + rectangle.getSize().width, rectangle.getPosition().y);

        ((GeneralPath) shape).lineTo(rectangle.getPosition().x + rectangle.getSize().width, rectangle.getPosition().y + rectangle.getSize().height);

        ((GeneralPath) shape).lineTo(rectangle.getPosition().x, rectangle.getPosition().y + rectangle.getSize().height);

        ((GeneralPath) shape).closePath();

    }
}
