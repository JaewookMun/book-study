package book.margin.hugedata.operator;

import book.margin.hugedata.util.CustomMath;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BitOperator {

    public static void orOperator(int a, int b) {
        // OR 연산자
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("a | b = " + (byte) (a | b));
        System.out.println("Integer.toBinaryString(a) = " + Integer.toBinaryString(a));
        System.out.println("Integer.toBinaryString(b) = " + Integer.toBinaryString(b));
        System.out.println("Integer.toBinaryString(a | b) = " + Integer.toBinaryString(a | b));
        System.out.println(Integer.toBinaryString(3|3));
    }

    public static String toBinary(int i) {
        return Integer.toBinaryString(i);
    }

    public static int pow(int a, int b) {
        int result = 1;
        for (int i=0; i<b; i++) {
            result *= a;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        int a = 3;
        int b = 8;

        int STANDARD_NUMBER = 128; // 2^7
        int value = 10731564;
        System.out.println("value = " + value);

//        orOperator(a, b);
        // VByte code -> 첫 비트는 플래그

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        int byteSize = CustomMath.getByteSize(value);
        int targetUnit = pow(STANDARD_NUMBER, byteSize-1);
        System.out.println("byteSize = " + byteSize);

        byte[] temp = new byte[byteSize];
        int index = 0;
        while (value >= STANDARD_NUMBER) {
//            bos.write(value / pow(STANDARD_NUMBER, byteSize-1));
            temp[index++] = (byte) (value / targetUnit);
            value %= targetUnit;
            byteSize--;
            targetUnit >>>= 7;
        }
//        bos.write(value);
        temp[index] = (byte) value;

        for(int i=0; i<temp.length; i++) {
            bos.write(temp[index--]);
        }
        byte[] deli = {','};
        byte d = ',';

        bos.write(deli);
        bos.write(d);



        byte[] bytes = bos.toByteArray();
        for (byte aByte : bytes) {
            System.out.println("aByte = " + aByte);
        }

        // decode
        List<Integer> integer = new ArrayList<>();

        byteSize = 1;
        for (byte aByte : bytes) {
            integer.add(aByte * pow(STANDARD_NUMBER, byteSize-1));
            byteSize++;
        }

        System.out.println("result = " + integer.stream().mapToInt(Integer::intValue).sum());

    }
}
