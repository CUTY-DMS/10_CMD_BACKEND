package com.gdsc.cmd.openapi.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gdsc.cmd.openapi.domain.Meal;
import com.gdsc.cmd.openapi.domain.repository.MealRepository;
import com.gdsc.cmd.openapi.domain.type.StatusEnum;
import com.gdsc.cmd.openapi.exception.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.swing.text.DateFormatter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class SchoolMealsOpenApiService {

    private final MealRepository mealRepository;

   // @Scheduled(cron = "0 0 0 * * *")
    public void fetchMeals() throws Exception {

        LocalDate localDate = LocalDate.now(); // 현재 날짜를 객체로 받아옴.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formattedDate = localDate.format(formatter); // 객체를 openAPI url 형식에 맞게 string 으로 바꿔줌.


        URL url = new URL("http://open.neis.go.kr/hub/mealServiceDietInfo?ATPT_OFCDC_SC_CODE=G10&SD_SCHUL_CODE=7430310&Key=21b0aabb876e40efa3e8f08a884c4544&MLSV_YMD=20240825&Type=json&pIndex=1&pSize=100");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET"); // openapi 에게 get 요청을 보냄.


        int status = con.getResponseCode();
        if (status == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            String jsonString = response.toString();
            parseAndSaveMeals(jsonString);
        } else {
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            StringBuilder errorResponse = new StringBuilder();
            String line;
            while ((line = errorReader.readLine()) != null) {
                errorResponse.append(line);
            }
            errorReader.close();
            System.out.println("Error Response: " + errorResponse.toString());
            throw new IOException("HTTP error code: " + status);
        }

    }


    private void parseAndSaveMeals(String jsonString) throws Exception {


        System.out.println("22435345dfgghffgfgf");

        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode rootNode = objectMapper.readTree(jsonString);

        JsonNode mealServiceDietInfoNode = rootNode.path("mealServiceDietInfo");

        JsonNode rowNode = mealServiceDietInfoNode.get(1).path("row");

        for(JsonNode row : rowNode) {
            Meal meal = Meal.builder()
                    .MMEAL_SC_NM(row.path("NMEAL_SC_NM").asText())
                    .MLSV_YMD(row.path("MLSV_YMD").asText())
                    .DDISH_NM(row.path("DDISH_NM").asText())
                    .CAL_INFO(row.path("CAL_INFO").asText())
                    .build();

            mealRepository.save(meal);
        }
    }
}
