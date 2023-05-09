package m.example.modern.dsl.sequence;

import m.example.modern.dsl.Stock;

public class StockBuilder {
    public Stock stock = new Stock();


    public void symbol(String symbol) {
        stock.setSymbol(symbol);
    }

    public void market(String market) {
        stock.setMarket(market);
    }

}
