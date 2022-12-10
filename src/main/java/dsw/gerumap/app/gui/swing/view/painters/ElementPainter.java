package dsw.gerumap.app.gui.swing.view.painters;

import dsw.gerumap.app.repository.implementation.Element;
import dsw.gerumap.app.repository.implementation.elements.DiagramElement;

import java.awt.*;

public abstract class ElementPainter {
    public ElementPainter(DiagramElement element) {	}

    public abstract void paint(Graphics2D g, DiagramElement element);

    public abstract boolean elementAt(DiagramElement element, Point pos);


}
