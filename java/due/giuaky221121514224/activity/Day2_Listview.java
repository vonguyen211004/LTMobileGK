package due.giuaky221121514224.activity;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;

import due.giuaky221121514224.model.Contact;
import due.giuaky221121514224.adapter.ContactAdapter;
import due.giuaky221121514224.R;

public class Day2_Listview extends AppCompatActivity {

    ListView listView;
    ArrayList<Contact> contactList;
    ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day2_listview);

        listView = findViewById(R.id.listview_contact);
        contactList = new ArrayList<>();

        contactList.add(new Contact("Võ Văn Bảo Nguyên", "0345678314", R.drawable.ava_male));
        contactList.add(new Contact("Nguyễn Ánh", "0234567314", R.drawable.default_ava));
        contactList.add(new Contact("Lê Tuấn Kiệt", "0902222222", R.drawable.skype));
        contactList.add(new Contact("Võ Văn Bảo Nguyên", "0345678314", R.drawable.ava_male));
        contactList.add(new Contact("Nguyễn Ánh", "0234567314", R.drawable.default_ava));
        contactList.add(new Contact("Lê Tuấn Kiệt", "0902222222", R.drawable.skype));
        contactList.add(new Contact("Võ Văn Bảo Nguyên", "0345678314", R.drawable.ava_male));
        contactList.add(new Contact("Nguyễn Ánh", "0234567314", R.drawable.default_ava));
        contactList.add(new Contact("Lê Tuấn Kiệt", "0902222222", R.drawable.skype));
        contactList.add(new Contact("Võ Văn Bảo Nguyên", "0345678314", R.drawable.ava_male));
        contactList.add(new Contact("Nguyễn Ánh", "0234567314", R.drawable.default_ava));
        contactList.add(new Contact("Lê Tuấn Kiệt", "0902222222", R.drawable.skype));
        contactList.add(new Contact("Võ Văn Bảo Nguyên", "0345678314", R.drawable.ava_male));
        contactList.add(new Contact("Nguyễn Ánh", "0234567314", R.drawable.default_ava));
        contactList.add(new Contact("Lê Tuấn Kiệt", "0902222222", R.drawable.skype));


        adapter = new ContactAdapter(this, R.layout.item_contact, contactList);
        listView.setAdapter(adapter);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Day2_ListView");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}