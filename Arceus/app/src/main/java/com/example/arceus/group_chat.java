package com.example.arceus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class group_chat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_chat);

        ArrayList<grpchat> group=new ArrayList<grpchat>();
        group.add(new grpchat("Sid","Bhag bsdk","6:45 PM","3","",R.drawable.sid));
        group.add(new grpchat("Raj","Delete maar pls","8:32 AM","5","",R.drawable.rajni));
        group.add(new grpchat("Aorobh","Gand fad denge bsdk","8:07 PM","0","",R.drawable.ayanabha));
        group.add(new grpchat("Tanmay","Aareh yaar firse marr gya mai","Just Now","2","typing...",R.drawable.tanmay));
        group.add(new grpchat("LeonKennedy","Mera aaj net khtm hai","Yesterday","1","",R.drawable.subham));
        group.add(new grpchat("Arunesh","DSA wala kitna door takk hua?","Just Now","1","typing...",R.drawable.arunesh));

        ListView grpchats=findViewById(R.id.list);
        grpchatadapter grpdetails=new grpchatadapter(this,group);
        grpchats.setAdapter(grpdetails);
    }
}