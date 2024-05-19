package com.ssafy.devway.typoConversion;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.devway.block.element.BlockElement;
import com.ssafy.devway.typoConversion.dto.TypoConversionResponseDTO;
import com.ssafy.devway.typoConversion.property.TypoConversionProperties;
import java.net.URI;
import java.nio.charset.StandardCharsets;
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

public class TypoConversionBlock implements BlockElement {

    @Override
    public String getName() {
        return "TYPO_CONVERSION";
    }

    private final TypoConversionProperties properties;

    public TypoConversionBlock(String CLIENT_ID, String CLIENT_SECRET_KEY) {
        this.properties = new TypoConversionProperties();

        properties.setClientId(CLIENT_ID);
        properties.setClientSecretKey(CLIENT_SECRET_KEY);
    }

    public void conversion(String query) {
        try {
            HttpHeaders headers = createHeaders();
            URI targetUrl = createTargetUrl(query);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(
                targetUrl, HttpMethod.GET, new HttpEntity<>(headers), String.class);

            processResponse(response);

        } catch (HttpClientErrorException e) {
            HttpStatusCode code = e.getStatusCode();
            handleClientError(e);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        } catch (JsonProcessingException e) {
            throw new RuntimeException("JSON 파싱 에러 : ", e);
        }
    }

    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Naver-Client-Id", properties.getClientId());
        headers.set("X-Naver-Client-Secret", properties.getClientSecretKey());
        return headers;
    }

    private URI createTargetUrl(String query) {
        return UriComponentsBuilder
            .fromUriString(properties.getUrl())
            .queryParam("query", query)
            .build()
            .encode(StandardCharsets.UTF_8)
            .toUri();
    }

    private void processResponse(ResponseEntity<String> response) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        TypoConversionResponseDTO errata = mapper.readValue(response.getBody(), TypoConversionResponseDTO.class);

        if (errata.getErrata().isEmpty()) {
            System.out.println("변환할 오타가 없습니다.");
        } else {
            System.out.println(errata.getErrata());
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
