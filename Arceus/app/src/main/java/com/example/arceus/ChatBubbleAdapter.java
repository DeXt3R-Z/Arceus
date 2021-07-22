package com.example.arceus;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ChatBubbleAdapter extends ArrayAdapter<IndividualText> {

    public ChatBubbleAdapter(Activity context, ArrayList<IndividualText> chatBubble)
    {
        super(context,0,chatBubble);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View item=convertView;
        if(item==null)
        {
            item= LayoutInflater.from(getContext()).inflate(R.layout.chat_holder,parent,false);
        }
        IndividualText pos=getItem(position);
        TextView message=item.findViewById(R.id.chatMesssage);
        message.setText(pos.getMessage());

        return item;
    }
}
