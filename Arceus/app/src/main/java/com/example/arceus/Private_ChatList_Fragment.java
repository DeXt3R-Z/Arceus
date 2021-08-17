package com.example.arceus;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;


public class Private_ChatList_Fragment extends Fragment {

    public Private_ChatList_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_private_chat_list_, container, false);
        //ArrayList
        final ArrayList<Chat> block=new ArrayList<Chat>();
        block.add(new Chat("Siddharth","PUBG aa bsdk","6:45 PM","3", 7905177085L,R.drawable.sid));
        block.add(new Chat("Raj","Delete maar de bhai pls","8:32 AM","5",9334443820L,R.drawable.rajni));
        block.add(new Chat("Ayanabha","Bahut paelenge bsdk","8:07 PM","0",8918829811L,R.drawable.ayanabha));
        block.add(new Chat("Tanmay","Aareh yaar firse marr gya mai","Just Now","2",7073809694L,R.drawable.tanmay));
        block.add(new Chat("Subham","Mera aaj net khtm hai","Yesterday","1",7605860213L,R.drawable.subham));
        block.add(new Chat("Arunesh","DSA wala kitna door takk hua?","Just Now","1",6387149263L,R.drawable.arunesh));
        block.add(new Chat("Siddharth","PUBG aa bsdk","6:45 PM","3", 7905177085L,R.drawable.sid));
        block.add(new Chat("Raj","Delete maar de bhai pls","8:32 AM","5",9334443820L,R.drawable.rajni));
        block.add(new Chat("Ayanabha","Bahut paelenge bsdk","8:07 PM","0",8918829811L,R.drawable.ayanabha));
        block.add(new Chat("Tanmay","Aareh yaar firse marr gya mai","Just Now","2",7073809694L,R.drawable.tanmay));
        block.add(new Chat("Subham","Mera aaj net khtm hai","Yesterday","1",7605860213L,R.drawable.subham));
        block.add(new Chat("Arunesh","DSA wala kitna door takk hua?","Just Now","1",6387149263L,R.drawable.arunesh));
        block.add(new Chat("Siddharth","PUBG aa bsdk","6:45 PM","3", 7905177085L,R.drawable.sid));
        block.add(new Chat("Raj","Delete maar de bhai pls","8:32 AM","5",9334443820L,R.drawable.rajni));
        block.add(new Chat("Ayanabha","Bahut paelenge bsdk","8:07 PM","0",8918829811L,R.drawable.ayanabha));
        block.add(new Chat("Tanmay","Aareh yaar firse marr gya mai","Just Now","2",7073809694L,R.drawable.tanmay));
        block.add(new Chat("Subham","Mera aaj net khtm hai","Yesterday","1",7605860213L,R.drawable.subham));
        block.add(new Chat("Arunesh","DSA wala kitna door takk hua?","Just Now","1",6387149263L,R.drawable.arunesh));
        block.add(new Chat("Siddharth","PUBG aa bsdk","6:45 PM","3",7905177085L,R.drawable.sid));
        block.add(new Chat("Raj","Delete maar de bhai pls","8:32 AM","5",9334443820L,R.drawable.rajni));
        block.add(new Chat("Ayanabha","Bahut paelenge bsdk","8:07 PM","0",8918829811L,R.drawable.ayanabha));
        block.add(new Chat("Tanmay","Aareh yaar firse marr gya mai","Just Now","2",7073809694L,R.drawable.tanmay));
        block.add(new Chat("Subham","Mera aaj net khtm hai","Yesterday","1",7605860213L,R.drawable.subham));
        block.add(new Chat("Arunesh","DSA wala kitna door takk hua?","Just Now","1",6387149263L,R.drawable.arunesh));
        ListView chats=(ListView)view.findViewById(R.id.list);
        ChatAdapter details=new ChatAdapter(getActivity(),block);
        chats.setAdapter(details);
        chats.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View convertView, int position, long id) {
//                TextView titleName=findViewById(R.id.namespace);
//                ImageView dp=findViewById(R.id.dp);
                Bundle bundle=new Bundle();
                Intent i=new Intent(getActivity(),ChatBox.class);
                bundle.putString("titleName",block.get(position).getNaame());
                bundle.putInt("dp",block.get(position).getDP());
                bundle.putLong("phno",block.get(position).getPhoneNumber());
                i.putExtras(bundle);
//                ImageView pp=convertView.findViewById(R.id.displayPicture);
//                pp.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        //this
//                    }
//                });
                startActivity(i);
            }
        });
        return view;
    }
}