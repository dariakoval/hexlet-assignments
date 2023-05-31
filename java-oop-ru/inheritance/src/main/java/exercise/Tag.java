package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public class Tag {
    private final String tagName;
    private final Map<String, String> tagAttributes;

    public Tag(String tagName, Map<String, String> tagAttributes) {
        this.tagName = tagName;
        this.tagAttributes = tagAttributes;
    }

    public String getTagName() {
        return tagName;
    }

    public Map<String, String> getTagAttributes() {
        return tagAttributes;
    }

    @Override
    public String toString() {
        String result = tagAttributes.entrySet()
                .stream()
                .map(x -> " " + x.getKey() + "=\"" + x.getValue() + "\"")
                .collect(Collectors.joining());

        return "<" + tagName + result + ">";
    }
}
// END
