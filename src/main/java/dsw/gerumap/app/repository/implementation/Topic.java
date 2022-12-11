package dsw.gerumap.app.repository.implementation;

import dsw.gerumap.app.repository.composite.MapNode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Topic extends Element{
    private int x, y, w, h;
    public Topic(String name, MapNode parent, int a, int b) {
        super(name, parent);
        this.x = a;
        this.y = b;
        this.w = 200;
        this.h = 100;
    }
}
