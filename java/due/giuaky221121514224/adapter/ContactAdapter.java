package due.giuaky221121514224.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import due.giuaky221121514224.model.Contact;
import due.giuaky221121514224.R;

public class ContactAdapter extends BaseAdapter {
    Context context;
    int layout;
    ArrayList<Contact> list;

    public ContactAdapter(Context context, int layout, ArrayList<Contact> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    static class ViewHolder {
        TextView txtName, txtPhone;
        ImageView imgAvatar;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(layout, parent, false);
            holder = new ViewHolder();
            holder.txtName = view.findViewById(R.id.txtName);
            holder.txtPhone = view.findViewById(R.id.txtPhone);
            holder.imgAvatar = view.findViewById(R.id.imgAvatar);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        Contact contact = list.get(i);
        holder.txtName.setText(contact.getName());
        holder.txtPhone.setText(contact.getPhone());
        holder.imgAvatar.setImageResource(contact.getAvatar());

        return view;
    }
}
