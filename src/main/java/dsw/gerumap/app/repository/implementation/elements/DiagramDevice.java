package dsw.gerumap.app.repository.implementation.elements;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Setter
@Getter

public class DiagramDevice extends DiagramElement {
    protected Dimension size;
    protected Point position;

    public DiagramDevice(Point position, Dimension size, Stroke stroke, Paint paint) {
        super(stroke, paint);
        this.size = size;
        this.position = position;
    }

}
