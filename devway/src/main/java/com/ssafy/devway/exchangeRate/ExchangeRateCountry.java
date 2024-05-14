package com.ssafy.devway.exchangeRate;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExchangeRateCountry {
	NORMAL(""),
	ARAB_EMIRATES("AED"),
	AUSTRALIA("AUD"),
	BAHRAIN("BHD"),
	BRUNEI("BND"),
	CANADA("CAD"),
	SWISS("CHF"),
	CHINA("CNH"),
	DENMARK("DKK"),
	EUROPE("EUR"),
	UNITED_KINGDOM("GBP"),
	HONG_KONG("HKD"),
	INDONESIA("IDR(100)"),
	JAPAN("JPY(100)"),
	KOREA("KRW"),
	KUWAIT("KWD"),
	MALAYSIA("MYR"),
	NORWAY("NOK"),
	NEW_ZEALAND("NZD"),
	SAUDI_ARABIA("SAR"),
	SWEDEN("SEK"),
	SINGAPORE("SGD"),
	THAILAND("THB"),
	UNITED_STATES_OF_AMERICA("USD"),
	;

	private final String textMode;

}
