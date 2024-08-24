package com.gdsc.cmd.openapi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gdsc.cmd.openapi.domain.Meal;
import com.gdsc.cmd.openapi.domain.repository.MealRepository;
import com.gdsc.cmd.openapi.domain.type.StatusEnum;
import com.gdsc.cmd.openapi.exception.Message;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.StyleSheet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Service
@RequiredArgsConstructor
public class SchoolMealsOpenApiService {

    private final MealRepository mealRepository;


    private ResponseEntity<Message> fetchMeals() throws Exception {

        URL url = new URL("http://open.neis.go.kr/hub/mealServiceDietInfo?ATPT_OFCDC_SC_CODE=G10&SD_SCHUL_CODE=7430310&Key=21b0aabb876e40efa3e8f08a884c4544&MLSV_YMD=20240828&Type=json&pIndex=1&pSize=100");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET"); // openapi 에게 get 요청을 보냄.
      //  con.setRequestProperty(); //요청 헤더에 값을 넣어서 보냄.

        BufferedReader reader;
        if(con.getResponseCode()== HttpURLConnection.HTTP_OK) {
            reader = new BufferedReader(new InputStreamReader(con.getInputStream())); // 200 번대로 응답이 왔을 때 응답온 정상적인 응답을 읽음.
        }else {
            reader = new BufferedReader(new InputStreamReader(con.getErrorStream())); // 400 번대이상으로 오류 응답이 왔을 때 오류응답 을 읽음.
        }

        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) { //readLine 은 내용을 한줄식 읽어오고 다 읽어왔으면 null 반환 -> 모든 내용을 읽을 때까지 실행하며 append로 한줄식 저장함.
            response.append(line);
        }
        reader.close();
        parseAndSaveMeals(response);

        Message message = new Message();
        message.setStatus(StatusEnum.OK);
        message.setMessage("open api 에서 json 객체를 받아오기 성공");
        message.setJsonData(response);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    private void parseAndSaveMeals(StringBuilder response) throws Exception {

        String jsonString = response.toString();

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
