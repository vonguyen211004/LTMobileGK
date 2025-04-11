package due.giuaky221121514224.network;

import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit {
    private static final String BASE_URL = "https://imdb236.p.rapidapi.com/";

    private static retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static APIMovies getApiService() {
        return retrofit.create(APIMovies.class);
    }
}
