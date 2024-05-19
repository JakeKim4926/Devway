package com.ssafy.devway.exchangeRate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.devway.block.element.BlockElement;
import com.ssafy.devway.exchangeRate.dto.ExchangeRateResponseDTO;
import com.ssafy.devway.exchangeRate.property.ExchangeRateProperties;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

public class ExchangeRateBlock implements BlockElement {

	@Override
	public String getName(){
		return "EXCHANGERATE";
	}

	private final ExchangeRateProperties properties;

	public ExchangeRateBlock(String API_KEY) {
		this.properties = new ExchangeRateProperties();
		properties.setApikey(API_KEY);
	}

	public void todayExchangeRate(ExchangeRateCountry exchangeRateCountry){
		String selectedCountry = exchangeRateCountry.getTextMode();
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		String strToday = today.format(formatter);

		StringBuilder urlBuilder = new StringBuilder(properties.getUrl());
		try{
			urlBuilder.append("?" + URLEncoder.encode("authkey", "UTF-8")+ "=" +properties.getApikey());
			urlBuilder.append(
				"&" + URLEncoder.encode("searchdate", "UTF-8") + "=" + strToday);
			urlBuilder.append("&" + URLEncoder.encode("data", "UTF-8") + "=AP01");
			urlBuilder.append("&" + URLEncoder.encode("cur_unit", "UTF-8") + "=" + selectedCountry);

			RestTemplate restTemplate = new RestTemplate();
			String url = urlBuilder.toString();
			String jsonResponse = restTemplate.getForObject(url, String.class);

			ObjectMapper objectMapper = new ObjectMapper();
			List<ExchangeRateResponseDTO> responseList = objectMapper.readValue(jsonResponse,
				new TypeReference<List<ExchangeRateResponseDTO>>() {
				});

		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}catch (HttpClientErrorException e) {
			if (e.getStatusCode() == HttpStatus.UNAUTHORIZED) {
				System.out.println("API 키를 찾을 수 없습니다. 다시 입력해 주세요.");
			} else if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
				System.out.println("나라를 찾을 수 없습니다. 다시 입력해 주세요.");
			} else {
				System.out.println("기타 클라이언트 오류: " + e.getMessage());
			}

		}catch (HttpServerErrorException e){
			System.out.println("서버 오류: " + e.getMessage());
		}catch (Exception e){
			System.out.println("알 수 없는 오류 발생: " + e.getMessage());
		}
	}
}
