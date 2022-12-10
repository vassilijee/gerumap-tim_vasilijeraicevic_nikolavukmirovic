package dsw.gerumap.app.repository.implementation.elements;

import dsw.gerumap.app.gui.swing.view.painters.ElementPainter;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public abstract class DiagramElement {
    protected Paint paint;
    protected Stroke stroke;

    protected String name;

    protected ElementPainter elementPainter;

    public DiagramElement(Stroke stroke, Paint paint) {
        this.stroke = stroke;
        this.paint = paint;
    }

}
