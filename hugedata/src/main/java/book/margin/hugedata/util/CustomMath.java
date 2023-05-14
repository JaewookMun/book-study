package book.margin.hugedata.util;

import book.margin.hugedata.compression.VByteCode;

public class CustomMath {

    private static int BYTE_STANDARD = VByteCode.BYTE_STANDARD;

    public static int pow(int a, int b) {
        int result = 1;
        for (int i=0; i<b; i++) {
            result *= a;
        }

        return result;
    }

    public static int getByteSize(int number) {
        int byteSize = 1;

        while(number >= BYTE_STANDARD) {
            byteSize++;
            number >>>= 7;
        }

        return byteSize;
    }
}
