package com.example.myapplication;

import android.content.Context;
//Import not working...
//import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import java.util.List;

public class MyCustomAdapter extends ArrayAdapter {

    private List<ContactsInfo> contactsInfoList;
    private Context context;

    public MyCustomAdapter(
            //@NonNull <- Import not working
            Context context,
            int resource,
            //@NonNull
            List objects
    ) {
        super(context, resource, objects);
        this.contactsInfoList = objects;
        this.context = context;
    }

    private class ViewHolder {
        TextView displayName;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        if (convertView == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.contact_info, null);

            holder = new ViewHolder();
            holder.displayName = (TextView) convertView.findViewById(R.id.displayName);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ContactsInfo contactsInfo = contactsInfoList.get(position);
        holder.displayName.setText(contactsInfo.getDisplayName());

        return convertView;
    }
}
