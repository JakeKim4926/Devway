package com.ssafy.devway.encyclopedia;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.devway.block.element.BlockElement;
import com.ssafy.devway.encyclopedia.dto.EncyclopediaResponse;
import com.ssafy.devway.encyclopedia.dto.Naver.Item;
import com.ssafy.devway.encyclopedia.dto.Naver.NaverResponse;
import com.ssafy.devway.encyclopedia.property.EncyclopediaProperties;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class EncyclopediaBlock implements BlockElement {

    @Override
    public String getName(){
        return "ENCYCLOPEDIA";
    }

    @Getter
    private List<EncyclopediaResponse> resultList;

    private final EncyclopediaProperties properties;

    public EncyclopediaBlock(String CLIENT_ID, String CLIENT_SECRET_KEY) {
        this.properties = new EncyclopediaProperties();

        properties.setClientId(CLIENT_ID);
        properties.setClientSecretKey(CLIENT_SECRET_KEY);
    }

    public void searchEncyclopedia(String query) throws JsonProcessingException {
        Integer display = properties.getDisplay();
        Integer start = properties.getStart();

        try {
            validatePagination(display, start);

            HttpHeaders headers = createHeaders();
            URI targetUrl = createTargetUrl(query, display, start);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(
                targetUrl, HttpMethod.GET, new HttpEntity<>(headers), String.class);

            processResponse(response);

        } catch (HttpClientErrorException e) {

            HttpStatusCode code = e.getStatusCode();

            if (code == HttpStatus.UNAUTHORIZED) {
                System.out.println("Client Id와 Secret Key를 다시 확인해주세요.");
            } else if (code == HttpStatus.BAD_REQUEST) {
                System.out.println("검색어(query)를 알맞게 입력해주세요.");
            }
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        } catch (JsonProcessingException e) {
            throw new RuntimeException("JSON 파싱 에러 : ", e);
        }
    }

    private void validatePagination(Integer display, Integer start) {
        if (display < 1 || display > 100) {
            throw new IllegalStateException("한 페이지 당 결과는 최소 1, 최대 100개까지 출력 가능합니다.");
        }
        if (start < 1 || start > 1000) {
            throw new IllegalStateException("검색 시작 위치는 최소 1, 최대 1000까지 가능합니다.");
        }
    }

    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Naver-Client-Id", properties.getClientId());
        headers.set("X-Naver-Client-Secret", properties.getClientSecretKey());
        return headers;
    }

    private URI createTargetUrl(String query, Integer display, Integer start) {
        return UriComponentsBuilder
            .fromUriString(properties.getUrl())
            .queryParam("query", query)
            .queryParam("display", display)
            .queryParam("start", start)
            .build()
            .encode(StandardCharsets.UTF_8)
            .toUri();
    }

    private void processResponse(ResponseEntity<String> response) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        NaverResponse naverResponse = mapper.readValue(response.getBody(), NaverResponse.class);

        if (naverResponse == null || naverResponse.getItems().isEmpty()) {
            throw new IllegalStateException("검색 결과가 없습니다.");
        }

        resultList = new ArrayList<>();
        for (Item item : naverResponse.getItems()) {
            EncyclopediaResponse blogResponse = EncyclopediaResponse.builder()
                .title(item.getTitle())
                .link(item.getLink())
                .description(item.getDescription())
                .thumbnail(item.getThumbnail())
                .build();
            resultList.add(blogResponse);
        }
    }

    private void handleClientError(HttpClientErrorException e) {
        HttpStatusCode code = e.getStatusCode();
        if (code == HttpStatus.UNAUTHORIZED) {
            System.out.println("Client Id와 Secret Key를 다시 확인해주세요.");
        } else if (code == HttpStatus.BAD_REQUEST) {
            System.out.println("검색어(query)를 알맞게 입력해주세요.");
        }
    }
}
