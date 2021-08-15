package com.example.arceus;

public class Grpchat {
    String grpName,grpLastText,grpDate,grpPendingMessages,grpTyping;
    int grpDisplayPic;
    public Grpchat(String name1,String lastText1, String date1, String pendingMessages1, String typing1, int dp1)
    {
        grpName=name1;
        grpLastText=lastText1;
        grpDate=date1;
        grpPendingMessages=pendingMessages1;
        grpTyping=typing1;
        grpDisplayPic=dp1;
    }

    public String getgrpName()
    {
        return grpName;
    }
    public String getgrpLastText()
    {
        return grpLastText;
    }
    public String getgrpDate()
    {
        return grpDate;
    }
    public String getgrpPendingMessages()
    {
        return grpPendingMessages;
    }
    public String getgrpTyping()
    {
        return grpTyping;
    }
    public int getgrpDP()
    {
        return grpDisplayPic;
    }

}
