package com.example.guest.switchboard.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.guest.switchboard.R;
import com.example.guest.switchboard.models.Ask;

import java.util.ArrayList;

/**
 * Created by Guest on 10/27/15.
 */
public class AskAdapter extends BaseAdapter{
    private Context mContext;
    private ArrayList<Ask> mAsks;

    public AskAdapter(Context context, ArrayList<Ask> asks) {
        mAsks = asks;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mAsks.size();
    }

    @Override
    public Object getItem(int position) {
        return mAsks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.ask_list_item, null);
            holder = new ViewHolder();
            holder.askLabel = (TextView) convertView.findViewById(R.id.askLabel);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Ask ask = mAsks.get(position);

        holder.askLabel.setText(ask.getContent());

        return convertView;
    }

    private static class ViewHolder {
        TextView askLabel;
    }

}
