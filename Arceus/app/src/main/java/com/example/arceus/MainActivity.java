package com.example.arceus;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.Size;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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

        ArrayList<Chat> block=new ArrayList<Chat>();
        block.add(new Chat("Siddharth","PUBG aa bsdk","6:45 PM","3","",R.drawable.sid));
        block.add(new Chat("Raj","Delete maar de bhai pls","8:32 AM","5","",R.drawable.rajni));
        block.add(new Chat("Ayanabha","Bahut paelenge bsdk","8:07 PM","0","",R.drawable.ayanabha));
        block.add(new Chat("Tanmay","Aareh yaar firse marr gya mai","Just Now","2","typing...",R.drawable.tanmay));
        block.add(new Chat("Subham","Mera aaj net khtm hai","Yesterday","1","",R.drawable.subham));
        block.add(new Chat("Arunesh","DSA wala kitna door takk hua?","Just Now","1","typing...",R.drawable.arunesh));

        ListView chats=findViewById(R.id.list);
        ChatAdapter details=new ChatAdapter(this,block);
        chats.setAdapter(details);
    }
}