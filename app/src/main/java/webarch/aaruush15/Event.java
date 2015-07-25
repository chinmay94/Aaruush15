package webarch.aaruush15;

import android.os.Bundle;

/**
 * Created by Chinmay on 18-Jul-15.
 */
public class Event {

    public String title;
    public Integer image;
    public Integer imageLarge;
    public String desc;
    public String date;
    public String price;
    public String contactname1;
    public String contactname2;
    public String contactnum1;
    public String contactnum2;

    public Bundle getAsBundle()
    {
        Bundle bundle=new Bundle();
        bundle.putString("title",title);
        bundle.putInt("image", image);
        bundle.putInt("imageLarge",imageLarge);
        bundle.putString("desc", desc);
        bundle.putString("date",date);
        bundle.putString("price",price);
        bundle.putString("contactname1",contactname1);
        bundle.putString("contactname2",contactname2);
        bundle.putString("contactnum1",contactnum1);
        bundle.putString("contactnum2",contactnum2);
        return bundle;
    }
}
