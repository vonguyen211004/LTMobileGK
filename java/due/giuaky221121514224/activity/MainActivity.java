package due.giuaky221121514224.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import due.giuaky221121514224.R;
import due.giuaky221121514224.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Demo");

            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_home)
                .setOpenableLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_day1_layout) {
                startActivity(new Intent(this, Day1_Layout.class));
            } else if (id == R.id.nav_day1_linear) {
                startActivity(new Intent(this, Day1_LinearLayout.class));
            } else if (id == R.id.nav_day2_listview) {
                startActivity(new Intent(this, Day2_Listview.class));
            } else if (id == R.id.nav_day2_activity) {
                startActivity(new Intent(this, Day2_Activity.class));
            } else if (id == R.id.nav_day2_listview_adv) {
                startActivity(new Intent(this, Day2_ListView_Advanced.class));
            } else if (id == R.id.nav_day3_network_basic) {
                startActivity(new Intent(this, Day3_Network_Basic.class));
            } else if (id == R.id.nav_day3_network_recycler) {
                startActivity(new Intent(this, Day3_Network_RecyclerView.class));
            } else if (id == R.id.nav_day3_network_weather) {
                startActivity(new Intent(this, WeatherActivity.class));
            }

            binding.drawerLayout.closeDrawers();
            return true;
        });
    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
