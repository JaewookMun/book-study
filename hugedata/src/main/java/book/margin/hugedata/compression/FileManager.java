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
            FileOutputStream outputStream = new FileOutputStream(compressedFile, false);
//            out = new OutputStreamWriter(outputStream);

            for (TagData tagData : tagDataList) {

                // todo : tag name을 추가해서 암호화 할 수 있는 기능 추가
//                out.write(tagData.getTagName());
                byte[] encode = VByteCode.encode(tagData.getEntryIds());
                outputStream.write(encode);

                outputStream.write(VByteCode.CARRIAGE_RETURN);
            }
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } finally {
            if(out != null) out.close();
        }
    }

    public static void recoverCompressedFile(File compressed) throws IOException {
        FileInputStream in = new FileInputStream(compressed);

        byte[] data = in.readAllBytes();
        // todo : byte 데이터를 int 데이터로 읽어올 때 깨짐 현상 방지기능 추가
        VByteCode.decode(data);



//        BufferedReader br = null;
//        try {
//            br = new BufferedReader(new InputStreamReader(new FileInputStream(compressed)));
//
//            String line = br.readLine();
//            for( ; Optional.ofNullable(line).isPresent(); ) {
//                tagDataList.add(readValue(line));
//
//                line = br.readLine();
//            }
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            br.close();
//        }
    }

    private static String readCompressedValue(String line) {
//        TagData tagData = new TagData();
        String[] sections = line.split("\t");

        String tagName = sections[0];

        int[] decodes = VByteCode.decode(sections[1].getBytes());
        for (int decode : decodes) {
            System.out.println("decode = " + decode);
        }

        return tagName;
    }
}
