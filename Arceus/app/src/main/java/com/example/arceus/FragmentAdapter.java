package com.example.arceus;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import org.jetbrains.annotations.NotNull;

public class FragmentAdapter extends FragmentStateAdapter {

     Status status=new Status();
     Private_ChatList_Fragment private_chat=new Private_ChatList_Fragment();
     Calls call=new Calls();
     Groups_ChatList_Fragment group_chat=new Groups_ChatList_Fragment();
     //int tracker = 0;

    public FragmentAdapter(@NonNull @NotNull FragmentManager fragmentManager, @NonNull @NotNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @Override
    public Fragment createFragment(int position) {
        if (position == 0)
            return private_chat;
        else if (position == 1)
            return status;
        else if (position == 2)
            return call;
        return private_chat;
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
