package m.example.modern.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.*;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class TransactionApp {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // 1. 2011년에 일어난 모든 트랜잭션을 찾아 값을 오름 차순으로 정리하시오.
        transactions.stream()
                .filter(t -> t.getYear() == 2011)
//                .map(t -> t.getValue())
//                .sorted()
                .sorted(comparing(Transaction::getValue))
//                .sorted(comparing(Transaction::getValue).reversed())
//                .forEach(System.out::println);
                .collect(toList());

        // 2. 거래자가 근무하는 모든 도시를 중복 없이 나열하시오.
        List<String> answer2 = transactions.stream()
                .map(t -> t.getTrader().getCity())
//                .map(trader -> trader.getCity())
                .distinct()
                .collect(toList());

        // 3. 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오
        List<Trader> answer3 = transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().equals("Cambridge"))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(toList());

        // 4. 모든 거래자의 이름을 알파벳순으로 정렬해서 반환하시오
        List<String> answer4 = transactions.stream()
                .map(t -> t.getTrader().getName())
//                .map(t -> t.getName())
                .distinct()
                .sorted()
                .collect(toList());

        // 5. 밀라노에 거래자가 있는가?
        boolean isTraderInMilano = transactions.stream()
//                .map(t -> t.getTrader())
//                .map(Transaction::getTrader)
                .anyMatch(t -> t.getTrader().getCity().equals("Milano"));

        // 6. 케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력하시오.
        transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .forEach(t -> System.out.println(t.getValue()));

        // 7. 전체 트랜잭션 중 최댓값은 얼마인가?
        int maxValue = transactions.stream()
//                .max((t1, t2) -> t1.getValue() - t2.getValue()).get().getValue();
                .max(comparing(Transaction::getValue))
                .get().getValue();

        // 8. 전체 트랜잭션 중 최솟값은 얼마인가?
        int minValue = transactions.stream()
//                .min((t1, t2) -> t1.getValue() - t2.getValue())
                .min(comparing(Transaction::getValue))
                .get().getValue();



    }
}