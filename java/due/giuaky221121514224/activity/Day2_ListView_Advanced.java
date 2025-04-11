package due.giuaky221121514224.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.List;

import due.giuaky221121514224.model.Contact;
import due.giuaky221121514224.adapter.ContactAdapterA;
import due.giuaky221121514224.R;

public class Day2_ListView_Advanced extends AppCompatActivity {

    ListView listView;
    List<Contact> contacts;
    ImageView userAvatar;
    TextView userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day2_list_view_advanced);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Day2_ListView_Advanced");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        toolbar.setNavigationOnClickListener(v -> onBackPressed());
        listView = findViewById(R.id.listViewContacts);
        userAvatar = findViewById(R.id.imgUserAvatar);
        userName = findViewById(R.id.txtUsername);

        contacts = new ArrayList<>();
        contacts.add(new Contact("Võ Văn Bảo Nguyên", "02537402938", R.drawable.ava_male));
        contacts.add(new Contact("Định Đức", "0238462831", R.drawable.default_ava));
        contacts.add(new Contact("Hồ Văn Ta", "0304735273", R.drawable.skype));
        contacts.add(new Contact("Võ Văn Bảo Nguyên", "02537402938", R.drawable.ava_male));
        contacts.add(new Contact("Định Đức", "0238462831", R.drawable.default_ava));
        contacts.add(new Contact("Hồ Văn Ta", "0304735273", R.drawable.skype));
        contacts.add(new Contact("Võ Văn Bảo Nguyên", "02537402938", R.drawable.ava_male));
        contacts.add(new Contact("Định Đức", "0238462831", R.drawable.default_ava));
        contacts.add(new Contact("Hồ Văn Ta", "0304735273", R.drawable.skype));
        contacts.add(new Contact("Võ Văn Bảo Nguyên", "02537402938", R.drawable.ava_male));
        contacts.add(new Contact("Định Đức", "0238462831", R.drawable.default_ava));
        contacts.add(new Contact("Hồ Văn Ta", "0304735273", R.drawable.skype));
        ImageView imgUser = findViewById(R.id.imgUserAvatar);
        TextView txtUsername = findViewById(R.id.txtUsername);
        ContactAdapterA adapter = new ContactAdapterA(this, contacts,imgUser, txtUsername);
        listView.setAdapter(adapter);
    }
}
