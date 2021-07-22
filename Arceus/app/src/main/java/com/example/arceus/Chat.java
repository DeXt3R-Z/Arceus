package com.example.arceus;

import android.graphics.drawable.Drawable;

public class Chat {
    public static String mName;
    String mLastText,mDate,mPendingMessages,mTyping;
    int mDisplayPic;
    public Chat(String name,String lastText, String date, String pendingMessages, String typing, int dp)
    {
        mName=name;
        mLastText=lastText;
        mDate=date;
        mPendingMessages=pendingMessages;
        mTyping=typing;
        mDisplayPic=dp;
    }
    public static String getNaame()
    {
        return mName;
    }
    public String getLastText()
    {
        return mLastText;
    }
    public String getDate()
    {
        return mDate;
    }
    public String getPendingMessages()
    {
        return mPendingMessages;
    }
    public String getTyping()
    {
        return mTyping;
    }
    public int getDP()
    {
        return mDisplayPic;
    }


}
