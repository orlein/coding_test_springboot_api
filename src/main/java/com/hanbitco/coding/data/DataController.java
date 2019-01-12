package com.hanbitco.coding.data;


import com.hanbitco.coding.system.ResponseBodyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/data")
public class DataController {

    @Autowired
    private DataService dataService;

    @Autowired
    private ResponseBodyService responseBodyService;

    private static Logger log = LoggerFactory.getLogger(DataController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome() {
        return "Hello world";
    }

    @RequestMapping(value = "/currency", method = RequestMethod.GET)
    public ResponseEntity<Map> getAllCurrenciesDataInKRW() {
        Map body = dataService.getLastPricesKRW("KRW");
        Map result = responseBodyService.makeResponseBody(body);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/currency/{currencyToBuy}", method = RequestMethod.GET)
    public ResponseEntity<Map> getCurrencyDataInKRW(@PathVariable String currencyToBuy) {
        Map body = dataService.getLastPrices(currencyToBuy, "KRW");
        Map result = responseBodyService.makeResponseBody(body);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/currency/{currencyToBuy}/{currencyToSell}", method = RequestMethod.GET)
    public ResponseEntity<Map> getCurrencyDataInKRW(@PathVariable String currencyToBuy, @PathVariable String currencyToSell) {
        Map body = dataService.getLastPrices(currencyToBuy, currencyToSell);
        Map result = responseBodyService.makeResponseBody(body);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
