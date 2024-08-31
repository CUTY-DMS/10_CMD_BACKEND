package com.gdsc.cmd.openapi.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gdsc.cmd.openapi.domain.Meal;
import com.gdsc.cmd.openapi.domain.repository.MealRepository;
import com.gdsc.cmd.openapi.domain.type.StatusEnum;
import com.gdsc.cmd.openapi.exception.Message;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class SchoolMealsOpenApiService {
    private final WebClient webClient;
    private final MealRepository mealRepository;

    // @Scheduled(cron = "0 0 0 * * *")

    @SneakyThrows
    public void fetchMeals() throws Exception {

        LocalDate localDate = LocalDate.of(2024,8,29); // 현재 날짜를 객체로 받아옴. 나중에 .now 로 바꿔주기
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formattedDate = localDate.format(formatter); // 객체를 openAPI url 형식에 맞게 string 으로 바꿔줌.


        String jsonString = webClient
                .get()
                .uri("https://open.neis.go.kr/hub/mealServiceDietInfo?ATPT_OFCDC_SC_CODE=G10&SD_SCHUL_CODE=7430310&Key=21b0aabb876e40efa3e8f08a884c4544&MLSV_YMD="+formattedDate+"&Type=json&pIndex=1&pSize=100")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        parseAndSaveMeals(jsonString);
    }


    public void parseAndSaveMeals(String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();

         {
            try {
                JsonNode rootNode = objectMapper.readTree(jsonString);
                JsonNode mealServiceDietInfoNode = rootNode.path("mealServiceDietInfo");
                JsonNode rowNode = mealServiceDietInfoNode.get(1).path("row");

                for (JsonNode row : rowNode) {
                    Meal meal = Meal.builder()
                            .MMEAL_SC_NM(row.path("NMEAL_SC_NM").asText())
                            .date(row.path("MLSV_YMD").asText())
                            .DDISH_NM(row.path("DDISH_NM").asText())
                            .CAL_INFO(row.path("CAL_INFO").asText())
                            .build();

                    mealRepository.save(meal);
                }

            } catch (IOException e) {
                throw new RuntimeException("Parsing error: " + e.getMessage(), e);
            }
        }
    }

}





