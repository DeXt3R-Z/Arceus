package com.example.arceus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ChatBox extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_box);
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
        EditText txt=findViewById(R.id.textInput);
        txt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String val=s.toString();
                if(val.isEmpty())
                {
                    send.setImageResource(R.drawable.mic);
                }
                else
                {
                    send.setImageResource(R.drawable.send);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        Bundle bundle=getIntent().getExtras();
        String nme=bundle.getString("titleName");
        int deepee=bundle.getInt("dp");
        long phNumber=bundle.getLong("phno");
        TextView titleName=findViewById(R.id.namespace);
        titleName.setText(nme);
        ImageView dp=findViewById(R.id.dp);
        dp.setImageResource(deepee);

        LinearLayout goback=findViewById(R.id.goBack);
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storemessages.clear();
                finish();
            }
        });

        ImageView call=findViewById(R.id.call);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+phNumber));
                startActivity(intent);
            }
        });

        ImageButton selfie=findViewById(R.id.selfie);
        selfie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent selfiecam=new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
                startActivity(selfiecam);
            }
        });

        ImageButton files=findViewById(R.id.files);
        files.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
                //System call Action attribute
                intent.setType("*/*");
                //Set file type
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                startActivity(intent);
                // Add Category attribute
//                try{
//                    startActivity(intent);
//                }catch(Exception e){
//                    Toast.makeText(this, "The file manager was not opened correctly", Toast.LENGTH_SHORT).show();
//                }
            }
        });

    }
}