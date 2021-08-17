package com.example.arceus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextPaint;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.online);
        textView.setText("ONLINE".toUpperCase());

        TextPaint paint = textView.getPaint();
        float width = paint.measureText("ONLINE NEW NEW");

        Shader textShader = new LinearGradient(0, 0, width, textView.getTextSize(),
                new int[]{
                        Color.parseColor("#eb1133"),
                        Color.parseColor("#e74f1c"),
                        Color.parseColor("#d68407"),
                }, null, Shader.TileMode.CLAMP);
        textView.getPaint().setShader(textShader);
        textView.setTextColor(Color.parseColor("#eb1133"));


        //Gradient 2
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



        //ArrayList
//        final ArrayList<Chat> block=new ArrayList<Chat>();
//        block.add(new Chat("Siddharth","PUBG aa bsdk","6:45 PM","3", 7905177085L,R.drawable.sid));
//        block.add(new Chat("Raj","Delete maar de bhai pls","8:32 AM","5",9334443820L,R.drawable.rajni));
//        block.add(new Chat("Ayanabha","Bahut paelenge bsdk","8:07 PM","0",8918829811L,R.drawable.ayanabha));
//        block.add(new Chat("Tanmay","Aareh yaar firse marr gya mai","Just Now","2",7073809694L,R.drawable.tanmay));
//        block.add(new Chat("Subham","Mera aaj net khtm hai","Yesterday","1",7605860213L,R.drawable.subham));
//        block.add(new Chat("Arunesh","DSA wala kitna door takk hua?","Just Now","1",6387149263L,R.drawable.arunesh));
//        block.add(new Chat("Siddharth","PUBG aa bsdk","6:45 PM","3", 7905177085L,R.drawable.sid));
//        block.add(new Chat("Raj","Delete maar de bhai pls","8:32 AM","5",9334443820L,R.drawable.rajni));
//        block.add(new Chat("Ayanabha","Bahut paelenge bsdk","8:07 PM","0",8918829811L,R.drawable.ayanabha));
//        block.add(new Chat("Tanmay","Aareh yaar firse marr gya mai","Just Now","2",7073809694L,R.drawable.tanmay));
//        block.add(new Chat("Subham","Mera aaj net khtm hai","Yesterday","1",7605860213L,R.drawable.subham));
//        block.add(new Chat("Arunesh","DSA wala kitna door takk hua?","Just Now","1",6387149263L,R.drawable.arunesh));
//        block.add(new Chat("Siddharth","PUBG aa bsdk","6:45 PM","3", 7905177085L,R.drawable.sid));
//        block.add(new Chat("Raj","Delete maar de bhai pls","8:32 AM","5",9334443820L,R.drawable.rajni));
//        block.add(new Chat("Ayanabha","Bahut paelenge bsdk","8:07 PM","0",8918829811L,R.drawable.ayanabha));
//        block.add(new Chat("Tanmay","Aareh yaar firse marr gya mai","Just Now","2",7073809694L,R.drawable.tanmay));
//        block.add(new Chat("Subham","Mera aaj net khtm hai","Yesterday","1",7605860213L,R.drawable.subham));
//        block.add(new Chat("Arunesh","DSA wala kitna door takk hua?","Just Now","1",6387149263L,R.drawable.arunesh));
//        block.add(new Chat("Siddharth","PUBG aa bsdk","6:45 PM","3",7905177085L,R.drawable.sid));
//        block.add(new Chat("Raj","Delete maar de bhai pls","8:32 AM","5",9334443820L,R.drawable.rajni));
//        block.add(new Chat("Ayanabha","Bahut paelenge bsdk","8:07 PM","0",8918829811L,R.drawable.ayanabha));
//        block.add(new Chat("Tanmay","Aareh yaar firse marr gya mai","Just Now","2",7073809694L,R.drawable.tanmay));
//        block.add(new Chat("Subham","Mera aaj net khtm hai","Yesterday","1",7605860213L,R.drawable.subham));
//        block.add(new Chat("Arunesh","DSA wala kitna door takk hua?","Just Now","1",6387149263L,R.drawable.arunesh));
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_chatList,new Private_ChatList_Fragment()).commit();

        RelativeLayout pmessages=findViewById(R.id.PrivateMessages);
        RelativeLayout gmessages=findViewById(R.id.GroupMessages);
        VerticalTextView privMessages=findViewById(R.id.verticalTextView2);
        VerticalTextView grpMessages=findViewById(R.id.verticalTextView3);

        pmessages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent groups=new Intent(MainActivity.this,GroupchatActivity.class);
//                startActivity(groups);
                Private_ChatList_Fragment priv=new Private_ChatList_Fragment();
                FragmentTransaction pchats=getSupportFragmentManager().beginTransaction();
                pchats.replace(R.id.fragment_chatList,priv);
                pchats.commit();
                pmessages.setBackgroundResource(R.drawable.side_tab);
                gmessages.setBackgroundResource(R.color.transparent);
                privMessages.setTextColor(getResources().getColor(R.color.floating));
                grpMessages.setTextColor(getResources().getColor(R.color.nonHighlighted));

            }
        });

        gmessages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Groups_ChatList_Fragment grp=new Groups_ChatList_Fragment();
                FragmentTransaction gchats=getSupportFragmentManager().beginTransaction();
                gchats.replace(R.id.fragment_chatList,grp).commit();
                gmessages.setBackgroundResource(R.drawable.side_tab);
                pmessages.setBackgroundResource(R.color.transparent);
                grpMessages.setTextColor(getResources().getColor(R.color.floating));
                privMessages.setTextColor(getResources().getColor(R.color.nonHighlighted));
            }
        });

        //Intent for opening camera
        ImageView cam=findViewById(R.id.camera);
        cam.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent mintent=new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
                startActivity(mintent);
            }
        });

//        ListView chats=findViewById(R.id.list);
//        ChatAdapter details=new ChatAdapter(this,block);
//        chats.setAdapter(details);
//        chats.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View convertView, int position, long id) {
////                TextView titleName=findViewById(R.id.namespace);
////                ImageView dp=findViewById(R.id.dp);
//                Bundle bundle=new Bundle();
//                Intent i=new Intent(MainActivity.this,ChatBox.class);
//                bundle.putString("titleName",block.get(position).getNaame());
//                bundle.putInt("dp",block.get(position).getDP());
//                bundle.putLong("phno",block.get(position).getPhoneNumber());
//                i.putExtras(bundle);
//                startActivity(i);
//            }
//        });

    }
}