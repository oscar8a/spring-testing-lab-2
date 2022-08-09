package com.testlab2.application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

    @GetMapping("/hello")
    public String shouldGreetDefault(@RequestParam(
            name = "targetName",
            defaultValue = "Oscar") String name) {
        return String.format("Hello %s", name);
    }

//    @GetMapping("/getBitcoinPrice")
//    public String getPriceOfBitcoin() {
//        return "The Price of Bitcoin is: " + cryptoPricingService.getBitcoinData();
//    }
}
