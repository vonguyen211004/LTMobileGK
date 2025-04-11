package due.giuaky221121514224.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;

import due.giuaky221121514224.R;

public class EditUserActivity extends AppCompatActivity {

    EditText edtNewUsername;
    Button btnDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Edit User");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        edtNewUsername = findViewById(R.id.edtNewUsername);
        btnDone = findViewById(R.id.btnDone);

        String currentUsername = getIntent().getStringExtra("username");
        edtNewUsername.setText(currentUsername);

        btnDone.setOnClickListener(v -> {
            String newName = edtNewUsername.getText().toString().trim();
            Intent resultIntent = new Intent();
            resultIntent.putExtra("updatedUsername", newName);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}