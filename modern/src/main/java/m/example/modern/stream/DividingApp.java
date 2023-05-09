package m.example.modern.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.partitioningBy;

// 2부터 n까지의 자연수를 소수(prime)와 비소수(nonprime)로 나누는 프로그램
public class DividingApp {

    public static boolean primeChecker(int n) {
//        long count = IntStream.rangeClosed(1, n).filter(i -> n % i == 0).count();
//
//        return count == 2 ? true : false;
        return IntStream.range(2, n).noneMatch(i -> n%i == 0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("enter number> ");
        String inputNumber = br.readLine();

        if(inputNumber.matches("[a-zA-Z]")) System.out.println("Don't use character. it's for number!!");

        int number = Integer.parseInt(inputNumber);
        Map<Boolean, List<Integer>> map = IntStream.rangeClosed(2, number).boxed().collect(partitioningBy(DividingApp::primeChecker));

        for (Boolean bool : map.keySet()) {
            List<Integer> integers = map.get(bool);
            System.out.println(bool + " = " + integers);
        }



    }
}
