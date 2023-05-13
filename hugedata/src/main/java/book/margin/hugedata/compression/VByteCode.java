package book.margin.hugedata.compression;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * type 'VByte Code in java' in chatGPT
 * and refer to response
 *
 * {@link VByteCode} is designed for compressing and recovering the content size of file
 *
 * {@link VByteCode} is abbreviation of VariableByte Code
 */
public class VByteCode {
//    public static byte[] encode(int value) {
    public static String encode(int value) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        // 0x80 : 16진수 숫자 > 10진수로 128을 나타냄
        while (value >= 0x80) {
            bos.write((byte) (value | 0x80));
            // value = value >>> 7;
            // 쉬프트 연산자도 일반적으로 사용하는 연산자처럼 표현가능하다. ex) +=
            value >>>= 7;
        }
        bos.write((byte) value);

//        return bos.toByteArray();
        return bos.toString();
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
