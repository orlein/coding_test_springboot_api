package com.hanbitco.coding.data;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.hanbitco.coding.system.JsonService;

import java.util.*;

@Service
public class DataService {

  private static Logger log = LoggerFactory.getLogger(DataService.class);
  private static ArrayList<String> symbols = new ArrayList<String>() {
    {
      add("BTC");
      add("EOS");
      add("ETH");
      add("BCH");
      add("XRP");
    }
  };
  private static ArrayList<String> exchanges = new ArrayList<String>() {
    {
      add("bithumb");
      add("coinone");
      add("korbit");
      add("bitfinex");
    }
  };
  @Autowired
  JsonService jsonService;

  public ArrayList<String> getSymbols() {
    return symbols;
  }

  public ArrayList<String> getExchanges() {
    return exchanges;
  }

  public String showPair() {
    Map json = jsonService.getSerializedMapFromFile();
    Map BCH_BTC = (Map)json.get("BCH_BTC");
    Map bitfinex = (Map)BCH_BTC.get("bitfinex");
    String pair = (String)bitfinex.get("convertedPair");
    log.info("pair?: {}", pair);
    //return jsonService.parseJsonFile();
    return pair;
  }

  public Map<String, Object> getExchangesByPair(String pair_with_underbar) {
    Map json = (Map)jsonService.getSerializedMapFromFile().get(pair_with_underbar);
    log.info("get Exchanges by pair from json : {}", json);
    return json;
  }

  public Map<String, Object> getLastPrices(String symbol, String symbolToSell) {
    Map<String, Object> result = new HashMap<>();

    Map json = jsonService.getSerializedMapFromFile();
    Set pairs = json.keySet();
    for(Object pair: pairs) {
      String currencyToBuy = ((String)pair).split("_")[0];
      String currencyToSell = ((String)pair).split("_")[1];
      Map dataOfPairFromEachExchanges = (Map)json.get(pair);
      if (symbol.equals(currencyToBuy) && symbolToSell.equals(currencyToSell)) {
        for (String exchange: exchanges) {
          Map dataFromExchange = (Map)dataOfPairFromEachExchanges.get(exchange);
          if (null != dataFromExchange) {
            Map<String, String> pairAndPrice = new HashMap<>();
            pairAndPrice.put("originPair", (String)dataFromExchange.get("originPair"));
            pairAndPrice.put("last", (String)dataFromExchange.get("last"));
            result.put(exchange, pairAndPrice);
          } else {
            result.put(exchange, null);
          }
        }
      }
    }
    return result;
  }

  public Map<String, Object> getLastPricesKRW(String symbolToSell) {
    Map<String, Object> result = new HashMap<>();

    Map json = jsonService.getSerializedMapFromFile();
    Set pairs = json.keySet();
    for(Object pair: pairs) {
      Map<String, Object> exchangeData = new HashMap<String, Object>();
      Map dataOfPairFromEachExchanges = (Map)json.get(pair);
      String currencyToBuy = ((String)pair).split("_")[0];
      String currencyToSell = ((String)pair).split("_")[1];
      if (symbolToSell.equals(currencyToSell) && symbols.contains(currencyToBuy)) {
        for (String exchange : exchanges) {
          Map dataFromExchange = (Map) dataOfPairFromEachExchanges.get(exchange);
          Map<String, Object> pairAndPrice = new HashMap<String, Object>();
          if (null != dataFromExchange) {
            pairAndPrice.put("originPair", dataFromExchange.get("originPair"));
            pairAndPrice.put("last", dataFromExchange.get("last"));
            exchangeData.put(exchange, pairAndPrice);
          } else {
            exchangeData.put(exchange, null);
          }
        }
        result.put((String) pair, exchangeData);
      }
    }
    return result;
  }
}