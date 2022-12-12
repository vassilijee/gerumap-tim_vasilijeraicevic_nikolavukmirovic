package dsw.gerumap.app.repository.implementation;

import dsw.gerumap.app.repository.composite.MapNode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Topic extends Element {
    private int x, y, w, h;

    public Topic(String name, MapNode parent, int a, int b) {
        super(name, parent);
        this.x = a;
        this.y = b;
        this.w = 1;
        this.h = 1;
    }

    @Override
    public void setName(String name) {
        this.w = name.length() * 15 + 10;
        this.h = 50;
        super.setName(name);
    }
}
