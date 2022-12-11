package dsw.gerumap.app.repository.implementation;

import dsw.gerumap.app.repository.composite.MapNode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Link extends Element{
    private Topic topidOd;
    private Topic topicDo;
    public Link(String name, MapNode parent) {
        super(name, parent);
    }
}
