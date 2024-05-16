package com.ssafy.devway.exchangeRate.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRateResponseDTO {

	@JsonProperty("cur_nm")
	private String curNm;

	@JsonProperty("cur_unit")
	private String curUnit;

	@JsonProperty("ttb")
	private String ttb;

	@JsonProperty("tts")
	private String tts;

	@JsonProperty("deal_bas_r")
	private String dealBasR;
}
