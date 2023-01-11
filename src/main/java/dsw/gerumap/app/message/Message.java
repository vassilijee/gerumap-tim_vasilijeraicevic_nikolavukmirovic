package dsw.gerumap.app.message;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {
    private String text;

    public Message(String text) {
        this.text = text;
    }
}
