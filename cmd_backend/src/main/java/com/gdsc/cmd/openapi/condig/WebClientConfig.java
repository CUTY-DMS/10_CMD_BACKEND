package com.gdsc.cmd.openapi.condig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        return builder
                .baseUrl("http://open.neis.go.kr/hub/mealServiceDietInfo?ATPT_OFCDC_SC_CODE=G10&SD_SCHUL_CODE=7430310&Key=21b0aabb876e40efa3e8f08a884c4544&Type=json&pIndex=1&pSize=100&MLSV_YMD=")
                .build();

    }
}
