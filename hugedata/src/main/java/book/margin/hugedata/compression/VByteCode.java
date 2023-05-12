package book.margin.hugedata.compression;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * type 'VByte Code in java' in chatGPT
 * and refer to response
 *
 * {@link VByteCode} is abbreviation of VariableByte Code
 */
public class VByteCode {
    public static byte[] encode(int[] data) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        for (int value : data) {
            while (value >= 0x80) {
                bos.write((byte) (value | 0x80));
                value >>>= 7;
            }
            bos.write((byte) value);
        }
        return bos.toByteArray();
    }

    public static int[] decode(byte[] data) {
        List<Integer> result = new ArrayList<>();
        int value = 0;
        for (byte b : data) {
            if ((b & 0x80) == 0) {
                value = (value << 7) | b;
                result.add(value);
                value = 0;
            } else {
                value = (value << 7) | (b & 0x7f);
            }
        }
        int[] array = new int[result.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = result.get(i);
        }
        return array;
    }
}
