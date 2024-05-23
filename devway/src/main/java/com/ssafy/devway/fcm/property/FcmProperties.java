package com.ssafy.devway.fcm.property;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class FcmProperties {

	private String projectId;
	private String url = "https://fcm.googleapis.com/v1/projects/" + projectId +"/messages:send";

}
