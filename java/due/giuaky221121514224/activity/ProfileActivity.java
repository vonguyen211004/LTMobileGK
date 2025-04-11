package due.giuaky221121514224.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.appbar.MaterialToolbar;

import due.giuaky221121514224.R;

public class ProfileActivity extends AppCompatActivity {

    TextView txtUsername;
    Button btnEdit;
    String username;
    final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Profile");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        toolbar.setNavigationOnClickListener(v -> onBackPressed());
        txtUsername = findViewById(R.id.txtUsername);
        btnEdit = findViewById(R.id.btnEdit);

        username = getIntent().getStringExtra("username");
        txtUsername.setText( username);

        btnEdit.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, EditUserActivity.class);
            intent.putExtra("username", username);
            startActivityForResult(intent, REQUEST_CODE);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            username = data.getStringExtra("updatedUsername");
            txtUsername.setText( username);
        }
    }
}