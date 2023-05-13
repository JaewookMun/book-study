package book.margin.hugedata.compression;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FileManager {

    /**
     * data in file looks like below
     * -----   [example]   -----
     * ${tag name} entryId1,entryId2,entryId3 ...
     * ...
     * ...
     * -------------------------
     *
     * @param file which consists of tag data.
     * @return TagData list
     */
    public static List<TagData> convertFile(File file) throws IOException {
        List<TagData> tagDataList = new ArrayList<>();

        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

            String line = br.readLine();
            for( ; Optional.ofNullable(line).isPresent(); ) {
                tagDataList.add(readValue(line));
                line = br.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }

        return tagDataList;
    }

    /**
     * The structure of line is like below
     * tagName entryId1,entryId2,entryId3 ...
     *
     * @param line
     * @return
     */
    private static TagData readValue(String line) {
        TagData tagData = new TagData();
        System.out.println("line = " + line);
        String[] sections = line.split("\t");

        tagData.setTagName(sections[0]);
        tagData.setEntryIds(Arrays.stream(sections[1].split(",")).map(Integer::parseInt).collect(Collectors.toList()));

        return tagData;
    }

    public static void createCompressedFile(List<TagData> tagDataList, String originalPath) throws IOException {
        String path = originalPath + ".comp";
        File compressedFile = new File(path);
        OutputStreamWriter out = null;

        try {
            out = new OutputStreamWriter(new FileOutputStream(compressedFile, false));

            for (TagData tagData : tagDataList) {
                StringBuilder sb = new StringBuilder();
                sb.append(tagData.getTagName()).append("\t");
                for (Integer entryId : tagData.getEntryIds()) {
                    sb.append(VByteCode.encode(entryId)).append(",");
                }
                String line = sb.substring(0, sb.length() - 1);
                out.write(line + "\n");

                System.out.println("line = " + line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } finally {
            if(out != null) out.close();
        }
    }
}
