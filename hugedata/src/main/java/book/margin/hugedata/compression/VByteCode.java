package book.margin.hugedata.compression;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * todo : 숫자 데이터를 byte 코드로 바꾸어 저장하여 압축하는 것은 성공하였으나 복구를 위해 읽어올 때 일부 데이터가 맞지 않는 현상 발생
 * todo : 이에 대한 해결 필요 (...)
 * 
 * {@link VByteCode} is designed for compressing and recovering the content size of file
 * {@link VByteCode} is abbreviation of VariableByte Code
 */
public class VByteCode {

    /** 콤마 ',' */
    private static final byte delimiter = 44; // ','
    /** enter */
    public static final byte CARRIAGE_RETURN = 10;
    public static final byte KEYBOARD_TAP = 9;

    public static final int BYTE_STANDARD = 128;


    public static byte[] encode(List<Integer> entryIds) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        for(int i=0; i<entryIds.size(); i++) {
            int value = entryIds.get(i);

            while (value >= BYTE_STANDARD) {
                bos.write(value % BYTE_STANDARD);
                value /= BYTE_STANDARD;
                System.out.println(value);
            }
            bos.write(value);
            bos.write(delimiter);
        }

        return bos.toByteArray();
    }

    public static int[] decode(byte[] dataSet) {
        List<Integer> result = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        int value = 0;
        int index = 0;

        for (byte data : dataSet) {
            if (data == delimiter) {
                int sum = values.stream().mapToInt(Integer::intValue).sum();
                result.add(sum);
                values.clear();
                index = 0;
            }
            else if(data == CARRIAGE_RETURN || data == KEYBOARD_TAP) {
                index = 0;
                continue;
            }
            else {
                value = data;

                for(int i=0; i<index; i++) {
                    value = value << 7;
                }
                values.add(value);
                index++;
            }
        }
        int[] array = result.stream().mapToInt(Integer::intValue).toArray();
        for (int i : array) {
            System.out.println("i = " + i);
        }


        return array;
    }


/*
    public static byte[] encode(List<Integer> entryIds, FileOutputStream outputStream) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] delimiter = {','};

        for(int i=0; i<entryIds.size(); i++) {
            int value = entryIds.get(i);
            while (value >= 0x80) {
                bos.write((byte) (value | 0x80));
                value >>>= 7;
            }
            bos.write(value);
            if(i != entryIds.size()-1) bos.write(delimiter);
        }

//        bos.writeTo(outputStream);
        return bos.toByteArray();
    }
*/
/*
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
*/
/*
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
//            System.out.println("result.get(" + i + ") = " + result.get(i));
        }
        return array;
    }
    */
}
