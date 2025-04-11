package due.giuaky221121514224.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import due.giuaky221121514224.R;
import due.giuaky221121514224.adapter.HourAdapter;
import due.giuaky221121514224.model.Weather;
import due.giuaky221121514224.network.APIWeather;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherActivity extends AppCompatActivity {

    private RecyclerView rvHour;
    private TextView tvTem;
    private TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        Toolbar toolbar = findViewById(R.id.weatherToolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Day3_Network_Weather");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        tvTem = findViewById(R.id.tvTem);
        tvStatus = findViewById(R.id.tvStatus);

        getHours();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        rvHour = findViewById(R.id.rvHour);
        rvHour.setLayoutManager(layoutManager);

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private void getHours() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIWeather.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIWeather service = retrofit.create(APIWeather.class);

        service.getHour().enqueue(new Callback<>() {
            @Override
            public void onResponse(@NonNull Call<List<Weather>> call, @NonNull Response<List<Weather>> response) {
                if (response.body() == null) return;

                List<Weather> listWeather = response.body();
                HourAdapter adapter = new HourAdapter(WeatherActivity.this, listWeather);
                rvHour.setAdapter(adapter);

                Weather weather = listWeather.get(0);
                tvTem.setText(weather.getTemperature().getValue().intValue() + "°");
                tvStatus.setText(weather.getIconPhrase());
            }

            @Override
            public void onFailure(@NonNull Call<List<Weather>> call, @NonNull Throwable t) {
                t.printStackTrace();
                Log.e("WeatherAPI", "API Call failed: " + t.getMessage());
            }
        });
    }
}