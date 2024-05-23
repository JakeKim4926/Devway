package com.ssafy.devway.fcm;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.auth.oauth2.GoogleCredentials;
import com.ssafy.devway.block.element.BlockElement;
import com.ssafy.devway.fcm.dto.FcmRequestDTO;
import com.ssafy.devway.fcm.dto.FcmResponseDTO;
import com.ssafy.devway.fcm.property.FcmProperties;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestBody;

public class FcmBlock implements BlockElement {

	@Override
	public String getName() {
		return "FCM";
	}

	private final FcmProperties fcmProperties;
	private final ObjectMapper objectMapper = null;

	public FcmBlock(String projectId) {
		this.fcmProperties = new FcmProperties();
		fcmProperties.setProjectId(fcmProperties.getProjectId());
	}

	public void sendMessageToFcm(@RequestBody FcmRequestDTO requestDTO) throws IOException{
		String targetToken = requestDTO.getToken();
		String title = requestDTO.getTitle();
		String body = requestDTO.getBody();

		String message = makeMessage(targetToken, title, body);

		OkHttpClient client = new OkHttpClient();
		okhttp3.RequestBody requestbody = okhttp3.RequestBody.create(message,okhttp3.MediaType.get("application/json; charset=utf-8"));

		Request request = new Request.Builder()
			.url(fcmProperties.getUrl())
			.post(requestbody)
			.addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + getAccessToken())
			.addHeader(HttpHeaders.CONTENT_TYPE, "application/json; UTF-8")
			.build();

		Response response = client.newCall(request).execute();


	}

	private String getAccessToken() throws IOException {
		InputStream stream = FcmBlock.class.getResourceAsStream("/firebase/firebase-settings.json");
		GoogleCredentials googleCredentials = GoogleCredentials.fromStream(stream)
			.createScoped(List.of("https://www.googleapis.com/auth/cloud-platform"));

		googleCredentials.refreshIfExpired();
		return googleCredentials.getAccessToken().getTokenValue();
	}

	private String makeMessage(String targetToken, String title, String body) throws JsonProcessingException {
		FcmResponseDTO responseDTO = FcmResponseDTO.builder()
			.message(FcmResponseDTO.Message.builder()
				.token(targetToken)
				.notification(FcmResponseDTO.Notification.builder()
					.title(title)
					.body(body)
					.build()
				).build()).validatedOnly(false).build();
		return objectMapper.writeValueAsString(responseDTO);
	}


}
