package due.giuaky221121514224.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.List;

import due.giuaky221121514224.R;
import due.giuaky221121514224.model.Movie;
import due.giuaky221121514224.network.Retrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Day3_Network_Basic extends AppCompatActivity {

    private TextView txtTitle, txtDate, txtDescription;
    private ImageView imgPoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day3_network_basic);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Day3_Network_Basic");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        txtTitle = findViewById(R.id.txtTitle);
        txtDate = findViewById(R.id.txtDate);
        txtDescription = findViewById(R.id.txtDescription);
        imgPoster = findViewById(R.id.imgPoster);

        loadFirstMovie();
    }

    private void loadFirstMovie() {
        Retrofit.getApiService().getTop250Movies().enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                if (response.isSuccessful() && response.body() != null && !response.body().isEmpty()) {
                    Movie movie = response.body().get(0);
                    txtTitle.setText(movie.getPrimaryTitle());
                    txtDate.setText(movie.getReleaseDate());
                    txtDescription.setText(movie.getDescription());

                    String imageUrl = movie.getPrimaryImage() != null ? movie.getPrimaryImage() : "";
                    Glide.with(Day3_Network_Basic.this).load(imageUrl).into(imgPoster);
                } else {
                    Toast.makeText(Day3_Network_Basic.this, "Không có dữ liệu", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                Toast.makeText(Day3_Network_Basic.this, "Không thể kết nối API", Toast.LENGTH_SHORT).show();
                Log.e("API", "Error: ", t);
            }
        });
    }
}
