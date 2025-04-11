package due.giuaky221121514224.network;

import due.giuaky221121514224.model.Weather;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIWeather {
    public static String BASE_URL = "https://dataservice.accuweather.com/";

    @GET("/forecasts/v1/hourly/12hour/353412?apikey=K10MELWZFmy5yQuUzGOfDAjG8SIsbn3j&language=vi-vn&metric=true")
    Call<List<Weather>> getHour();

    @GET("/forecasts/v1/daily/5day/353412?apikey=K10MELWZFmy5yQuUzGOfDAjG8SIsbn3j&language=vi-vn&metric=true")
    Call<List<Weather>> getDay();
}

