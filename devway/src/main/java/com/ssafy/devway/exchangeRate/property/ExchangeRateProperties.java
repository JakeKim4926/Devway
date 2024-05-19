package com.ssafy.devway.exchangeRate.property;

import java.math.BigDecimal;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ExchangeRateProperties {

	private String apikey;
	private String url = "https://www.koreaexim.go.kr/site/program/financial/exchangeJSON";
	private String dataType = "AP01";
	private BigDecimal exchangeRate = null;
}
