package com.example.arceus;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class grpchatadapter extends ArrayAdapter<grpchat> {
    public grpchatadapter(Activity context, ArrayList<grpchat> grp_chat)
    {
        super(context,0,grp_chat);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View item1=convertView;
        if(item1==null)
        {
            item1= LayoutInflater.from(getContext()).inflate(R.layout.activity_grpmainscreen,parent,false);
        }
        grpchat pos=getItem(position);
        TextView name=item1.findViewById(R.id.grpname);
        name.setText(pos.getgrpName());

        TextView date=item1.findViewById(R.id.grpdate);
        date.setText(pos.getgrpDate());

        TextView lastText=item1.findViewById(R.id.grplastMessage);
        lastText.setText(pos.getgrpLastText());

        TextView typing=item1.findViewById(R.id.grptyping);
        typing.setText(pos.getgrpTyping());

        TextView pending=item1.findViewById(R.id.grppending);
        pending.setText(pos.getgrpPendingMessages());

        ImageView dp=item1.findViewById(R.id.grpdisplayPicture);
        dp.setImageResource(pos.getgrpDP());

        return item1;
    }

}
