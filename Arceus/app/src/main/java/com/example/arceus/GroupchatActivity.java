package com.example.arceus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextPaint;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class GroupchatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_chat);

        //Gradient
        TextView inbox = (TextView) findViewById(R.id.inbox);
        inbox.setText("INBOX".toUpperCase());

        TextPaint ipaint = inbox.getPaint();
        float iwidth = ipaint.measureText("INBOX NEW NEW");

        Shader itextShader = new LinearGradient(0, 0, iwidth, inbox.getTextSize(),
                new int[]{
                        Color.parseColor("#eb1133"),
                        Color.parseColor("#e74f1c"),
                        Color.parseColor("#d68407"),
                }, null, Shader.TileMode.CLAMP);
        inbox.getPaint().setShader(itextShader);
        inbox.setTextColor(Color.parseColor("#eb1133"));

        ArrayList<Grpchat> group=new ArrayList<Grpchat>();
        group.add(new Grpchat("Tumpa Sona","Bhabesh: Use liya hoon","6:45 PM","3","",R.drawable.tumpasona));
        group.add(new Grpchat("App Dev","You: Ok","8:32 AM","5","",R.drawable.coding));
        group.add(new Grpchat("A-18 Unofficial","Sogbik: Ooo","8:07 PM","0","",R.drawable.a18));
        group.add(new Grpchat("IT Group","Subham: Faltu teacher","Just Now","2","typing...",R.drawable.itgroup));
        group.add(new Grpchat("NSFW memes","+91 8256347821: Image","Yesterday","1","",R.drawable.nsfw));
        group.add(new Grpchat("Fun Zone","You were added","Just Now","1","typing...",R.drawable.funzone));

        ListView grpchats=findViewById(R.id.list);
        Grpchatadapter grpdetails=new Grpchatadapter(this,group);
        grpchats.setAdapter(grpdetails);

        RelativeLayout groupsie=findViewById(R.id.Privatechan);
        groupsie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent groups=new Intent(GroupchatActivity.this,MainActivity.class);
//                startActivity(groups);
                finish();
            }
        });

        ImageView cam=findViewById(R.id.camera);
        cam.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent mintent=new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
                startActivity(mintent);
            }
        });
    }
}