package com.example.arceus;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class Groups_ChatList_Fragment extends Fragment {

    public Groups_ChatList_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_groups_chat_list, container, false);
        ArrayList<Grpchat> group=new ArrayList<Grpchat>();
        group.add(new Grpchat("Tumpa Sona","Bhabesh: Use liya hoon","6:45 PM","3","",R.drawable.tumpasona));
        group.add(new Grpchat("App Dev","You: Ok","8:32 AM","5","",R.drawable.coding));
        group.add(new Grpchat("A-18 Unofficial","Sogbik: Ooo","8:07 PM","0","",R.drawable.a18));
        group.add(new Grpchat("IT Group","Subham: Faltu teacher","Just Now","2","typing...",R.drawable.itgroup));
        group.add(new Grpchat("NSFW memes","+91 8256347821: Image","Yesterday","1","",R.drawable.nsfw));
        group.add(new Grpchat("Fun Zone","You were added","Just Now","1","typing...",R.drawable.funzone));

        ListView grpchats=(ListView)view.findViewById(R.id.list);
        Grpchatadapter grpdetails=new Grpchatadapter(getActivity(),group);
        grpchats.setAdapter(grpdetails);
        return view;
    }
}