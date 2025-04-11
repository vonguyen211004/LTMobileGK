package due.giuaky221121514224.adapter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

import due.giuaky221121514224.model.Contact;
import due.giuaky221121514224.R;

public class ContactAdapterA extends ArrayAdapter<Contact> {
    private final Activity context;
    private final List<Contact> contactList;
    private final ImageView userAvatar;
    private final TextView userName;

    public ContactAdapterA(Activity context, List<Contact> list, ImageView avatar, TextView name) {
        super(context, R.layout.list_item, list);
        this.context = context;
        this.contactList = list;
        this.userAvatar = avatar;
        this.userName = name;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder();
            holder.imgAvatar = convertView.findViewById(R.id.imgAvatar);
            holder.txtName = convertView.findViewById(R.id.txtName);
            holder.txtPhone = convertView.findViewById(R.id.txtPhone);
            holder.btnCall = convertView.findViewById(R.id.btnCall);
            holder.btnEdit = convertView.findViewById(R.id.btnEdit);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Contact contact = contactList.get(position);
        holder.imgAvatar.setImageResource(contact.getAvatar());
        holder.txtName.setText(contact.getName());
        holder.txtPhone.setText(contact.getPhone());

        holder.btnCall.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + contact.getPhone()));
            context.startActivity(intent);
        });

        holder.btnEdit.setOnClickListener(v -> {
            userAvatar.setImageResource(contact.getAvatar());
            userName.setText(contact.getName());
        });

        return convertView;
    }

    static class ViewHolder {
        ImageView imgAvatar;
        TextView txtName;
        TextView txtPhone;
        ImageButton btnCall;
        ImageButton btnEdit;
    }
}
