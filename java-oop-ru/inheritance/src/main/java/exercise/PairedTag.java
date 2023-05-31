package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private final String tagBody;
    private final List<Tag> childrenList;

    public PairedTag(String tagName, Map<String, String> tagAttributes, String tagBody, List<Tag> childrenList) {
        super(tagName, tagAttributes);
        this.tagBody = tagBody;
        this.childrenList = childrenList;
    }

    @Override
    public String toString() {
        String nestedTags = childrenList.stream()
                .map(Tag::toString)
                .collect(Collectors.joining());

        var result = new StringBuilder("<");
        result.append(super.getTagName());

        String strTagAttributes = super.getTagAttributes().entrySet()
                .stream()
                .map(x -> " " + x.getKey() + "=\"" + x.getValue() + "\"")
                .collect(Collectors.joining());

        result.append(strTagAttributes).append(">").append(nestedTags).append(tagBody);
        result.append("</").append(super.getTagName()).append(">");
        return result.toString();

    }
}
// END
