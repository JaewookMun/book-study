package book.margin.hugedata.compression;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter @Setter
@ToString
public class TagData {
    private String tagName;
    private List<Integer> entryIds;
}
