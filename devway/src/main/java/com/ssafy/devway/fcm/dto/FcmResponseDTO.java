package com.ssafy.devway.fcm.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class FcmResponseDTO {

	private boolean validatedOnly;
	private Message message;

	@Builder
	@AllArgsConstructor
	@Getter
	public static class Message{
		private Notification notification;
		private String token;
	}

	@Builder
	@AllArgsConstructor
	@Getter
	public static class Notification{
		private String title;
		private String body;
	}


}
