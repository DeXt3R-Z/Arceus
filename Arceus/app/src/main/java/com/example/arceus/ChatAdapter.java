package com.example.arceus;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ChatAdapter extends ArrayAdapter<Chat> {
    Chat pos;
    static String nm;
    static int DP;
    public ChatAdapter(Activity context, ArrayList<Chat> chat)
    {
        super(context,0,chat);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View item=convertView;
        if(item==null)
        {
            item= LayoutInflater.from(getContext()).inflate(R.layout.privatemessages,parent,false);
        }
        pos=getItem(position);
        TextView name=item.findViewById(R.id.name);
        nm=pos.getNaame();
        name.setText(nm);
        TextView date=item.findViewById(R.id.date);
        date.setText(pos.getDate());
        TextView lastText=item.findViewById(R.id.lastMessage);
        lastText.setText(pos.getLastText());
        //TextView typing=item.findViewById(R.id.typing);
        //typing.setText(pos.getTyping());
        TextView pending=item.findViewById(R.id.pending);
        pending.setText(pos.getPendingMessages());
        ImageView dp=item.findViewById(R.id.displayPicture);
        DP=pos.getDP();
        dp.setImageResource(DP);
        return item;
    }
    public static String getNM()
    {
        return nm;
    }

    public static int getDP()
    {
        return DP;
    }
}
