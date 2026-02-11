package com.afsar.myFirstProject.api_response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
public class WeatherResponse {

    public Current current;

    @Data
    public class Current{
        public int temperature;

        @JsonProperty("weather_descriptions")
        public ArrayList<String> weatherDescriptions;

        @JsonProperty("feelslike")
        public int feelsLike;

    }

}



