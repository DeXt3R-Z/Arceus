package com.example.arceus;

import android.graphics.drawable.Drawable;

public class Chat {
    String mName,mLastText,mDate,mPendingMessages;
    int mDisplayPic;
    long mPhoneNumber;
    public Chat(String name,String lastText, String date, String pendingMessages, long phoneNumber, int dp)
    {
        mName=name;
        mLastText=lastText;
        mDate=date;
        mPendingMessages=pendingMessages;
        mPhoneNumber=phoneNumber;
        mDisplayPic=dp;
    }
    public String getNaame()
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
    public long getPhoneNumber()
    {
        return mPhoneNumber;
    }
    public int getDP()
    {
        return mDisplayPic;
    }


}
