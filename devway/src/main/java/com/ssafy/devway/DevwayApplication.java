package com.ssafy.devway;

import com.ssafy.devway.exchangeRate.ExchangeRateBlock;
import com.ssafy.devway.exchangeRate.ExchangeRateCountry;
import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DevwayApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(DevwayApplication.class, args);
    }

}
