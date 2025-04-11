package due.giuaky221121514224.network;

import java.util.List;

import due.giuaky221121514224.model.Movie;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface APIMovies {
    @Headers({
            "x-rapidapi-key: cacc3107b3mshd18fa07abe9c069p1ed0afjsnf7562c6b6608",
            "x-rapidapi-host: imdb236.p.rapidapi.com"
    })
    @GET("imdb/top250-movies")
    Call<List<Movie>> getTop250Movies();
}
