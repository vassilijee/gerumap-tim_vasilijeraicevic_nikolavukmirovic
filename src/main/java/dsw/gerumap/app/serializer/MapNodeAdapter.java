package dsw.gerumap.app.serializer;

import com.google.gson.*;
import dsw.gerumap.app.repository.composite.MapNode;

import java.lang.reflect.Type;

public class MapNodeAdapter implements JsonSerializer<MapNode>, JsonDeserializer<MapNode> {

    @Override
    public MapNode deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String type1 = jsonObject.get("type").getAsString();
        JsonElement element = jsonObject.get("properties");
        try {
            return jsonDeserializationContext.deserialize(element, Class.forName("dsw.gerumap.app.repository.implementation." + type1));
        } catch (ClassNotFoundException cnfe) {
            throw new JsonParseException("Unknown element type: " + type1, cnfe);
        }
    }

    @Override
    public JsonElement serialize(MapNode mapNode, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject result = new JsonObject();
        result.add("type", new JsonPrimitive(mapNode.getClass().getSimpleName()));
        result.add("properties", jsonSerializationContext.serialize(mapNode, mapNode.getClass()));
        return result;
    }
}
