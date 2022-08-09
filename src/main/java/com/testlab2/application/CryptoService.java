package com.testlab2.application;

import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CryptoService {

    public CoinData getCoinData() {
        String coincapAPIURL = "http://api.coincap.io/v2/assets/bitcoin";
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(coincapAPIURL, CoinData.class);
    }

    public String getCoinPrice(CoinData coin) {
        return coin.getPriceUsd();
    }
}

@Data
class CoinData {
    private String id;
    private String symbol;
    private String priceUsd;
}
