package com.example.arceus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ChatBox extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_box);
        TextView headName=findViewById(R.id.namespace);
        headName.setText(ChatAdapter.getNM());
        ArrayList<IndividualText> storemessages=new ArrayList<IndividualText>();
        ImageView send=findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText text=findViewById(R.id.textInput);
                ListView messageList=findViewById(R.id.ChatList);
                ChatBubbleAdapter cba=new ChatBubbleAdapter(ChatBox.this,storemessages);
                String store=text.getText().toString();
                if(!store.equals(""))
                {
                storemessages.add(new IndividualText(store));
                messageList.setAdapter(cba);
                text.setText("");
                store="";
                }
//                messageList.setTranscriptMode(ListView.TRANSCRIPT_MODE_NORMAL);
//                messageList.setStackFromBottom(true);




                //EditText text=findViewById(R.id.textInput);
//                String store=text.getText().toString();
//                LinearLayout pv=findViewById(R.id.LinearLayout);
//                TextView chatBubble=new TextView(ChatBox.this);
                //chatBubble.setGravity(Gravity.RIGHT);
//                chatBubble.setTextSize(19);
//                chatBubble.setPadding(10,3,10,5);
//                chatBubble.setBackgroundResource(R.drawable.chat_bubble);
//                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
//                        LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
//
//                layoutParams.setMargins(5, 12, 15, 0);
//                //chatBubble.setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
//                chatBubble.setTextColor(Color.parseColor("#171717"));
//                chatBubble.setText(store);
//                pv.addView(chatBubble);
//                text.setText("");
//                store="";
            }
        });


        LinearLayout goback=findViewById(R.id.goBack);
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storemessages.clear();
                finish();
            }
        });

    }
}