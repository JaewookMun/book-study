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
//        String rootDir = "D:\\sample-data\\hugedatabook_samplecode\\hgdata_example\\06\\";
        String rootDir = "D:\\sample-data\\";
        String samplePath = rootDir + "eid_tags.txt";
        String compressedFilePath = rootDir + "eid_tags.txt.comp";

        File file = new File(samplePath);

        // read file
        List<TagData> tagDataList = FileManager.convertFile(file);
        System.out.println("[INFO]: Application has been read original file");

        // create compressed file
        FileManager.createCompressedFile(tagDataList, samplePath);
        System.out.println("[INFO]: The file has been compressed");

        // recover compressed file and create
        FileManager.recoverCompressedFile(new File(compressedFilePath));
        System.out.println("[INFO]: compressed file has been recovered");

        System.out.println("[END]: HugeDataProjectApp main process has been closed");
    }
}
