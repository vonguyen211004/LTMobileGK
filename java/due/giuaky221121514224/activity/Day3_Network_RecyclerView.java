package due.giuaky221121514224.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.List;

import due.giuaky221121514224.R;
import due.giuaky221121514224.adapter.MovieAdapter;
import due.giuaky221121514224.databinding.ActivityDay3NetworkRecyclerViewBinding;
import due.giuaky221121514224.model.Movie;
import due.giuaky221121514224.network.Retrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Day3_Network_RecyclerView extends AppCompatActivity {

    private ActivityDay3NetworkRecyclerViewBinding binding;
    private MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDay3NetworkRecyclerViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Day3_Network_RecyclerView");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit.getApiService().getTop250Movies().enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    adapter = new MovieAdapter(Day3_Network_RecyclerView.this, response.body());
                    binding.recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(Day3_Network_RecyclerView.this, "Failed to load data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                Toast.makeText(Day3_Network_RecyclerView.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
