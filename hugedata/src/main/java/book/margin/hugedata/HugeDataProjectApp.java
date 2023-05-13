package book.margin.hugedata;

import book.margin.hugedata.compression.FileManager;
import book.margin.hugedata.compression.TagData;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class HugeDataProjectApp {
    public static void main(String[] args) throws IOException {
        System.out.println("[START]: '대규모 서비스를 지탱하는 기술' 과제 - implemented by margin");

        // setup info
//        String samplePath = "D:\\sample-data\\sample.txt";
        String samplePath = "D:\\sample-data\\hugedatabook_samplecode\\hgdata_example\\06\\eid_tags.txt";
        File file = new File(samplePath);

        // read file
        List<TagData> tagDataList = FileManager.convertFile(file);

        // create compressed file
        FileManager.createCompressedFile(tagDataList, samplePath);


        System.out.println("[END]: HugeDataProjectApp has been closed");
    }
}
