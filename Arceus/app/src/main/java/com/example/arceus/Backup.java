package com.example.arceus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextPaint;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class Backup extends AppCompatActivity {

    ViewPager2 viewpager;
    TabLayout tab;
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

        viewpager=findViewById(R.id.viewpager);
        tab=findViewById(R.id.TabLayout);
        FragmentManager fm=getSupportFragmentManager();
        FragmentAdapter fa=new FragmentAdapter(fm,getLifecycle());
        viewpager.setAdapter(fa);
        viewpager.setOffscreenPageLimit(3);
        tab.setSelectedTabIndicator(R.drawable.selected_tab_underline);
        tab.setSelectedTabIndicatorHeight(3);
        tab.setTabTextColors(Color.parseColor("#414141"),Color.parseColor("#EF7A22"));
        viewpager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tab.selectTab(tab.getTabAt(position));
            }
        });
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //Gradient 2
//        TextView inbox = (TextView) findViewById(R.id.inbox);
//        inbox.setText("INBOX".toUpperCase());
//
//        TextPaint ipaint = inbox.getPaint();
//        float iwidth = ipaint.measureText("INBOX NEW NEW");
//
//        Shader itextShader = new LinearGradient(0, 0, iwidth, inbox.getTextSize(),
//                new int[]{
//                        Color.parseColor("#eb1133"),
//                        Color.parseColor("#e74f1c"),
//                        Color.parseColor("#d68407"),
//                }, null, Shader.TileMode.CLAMP);
//        inbox.getPaint().setShader(itextShader);
//        inbox.setTextColor(Color.parseColor("#eb1133"));

//        getSupportFragmentManager().beginTransaction().add(R.id.fragment_chatList,new Private_ChatList_Fragment()).commit();

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
//                FragmentManager fm=getSupportFragmentManager();
//                FragmentTransaction pchats=fm.beginTransaction();
//                pchats.replace(R.id.fragment_chatList,priv);
//                pchats.commit();
                viewpager.setCurrentItem(0);

                //Styling
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
//                FragmentTransaction gchats=getSupportFragmentManager().beginTransaction();
//                gchats.add(R.id.fragment_chatList,grp).commit();
                viewpager.setCurrentItem(3);
                gmessages.setBackgroundResource(R.drawable.side_tab);
                pmessages.setBackgroundResource(R.color.transparent);
                grpMessages.setTextColor(getResources().getColor(R.color.floating));
                privMessages.setTextColor(getResources().getColor(R.color.nonHighlighted));
            }
        });

//        TextView test=findViewById(R.id.status);
//        test.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentTransaction test=getSupportFragmentManager().beginTransaction();
//                test.add(R.id.flaotingDp,new FloatingDp()).commit();
//                LinearLayout center=findViewById(R.id.flaotingDp);
//                //center.setGravity(Gravity.CENTER);
//            }
//        });

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
//    public void dpFragmentReplace()
//    {
//        FloatingDp x=new FloatingDp();
//        FragmentTransaction f=getSupportFragmentManager().beginTransaction();
//        f.add(R.id.flaotingDp,x).commit();
//    }
}