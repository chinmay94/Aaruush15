package webarch.aaruush15;

import java.util.ArrayList;

import webarch.aaruush15.WorkshopFragments.Workshop;

/**
 * Created by Chinmay on 18-Jul-15.
 */
public class EventHandler {

    int number=6;
    String[] titles={"Crack The Code","Techie Trick","Whats The Fuss About"};
    Integer[] images={R.drawable.eyeroboticssmall,R.drawable.surveillancequadcoptersmall,R.drawable.tallbuildingdesignsmall};
    Integer[] imagesLarge={R.drawable.eyerobotics,R.drawable.surveillancequadcopter,R.drawable.tallbuildingdesign};
    String[] desc={"The quick brown fox jumped over the lazy dog."};
    String[] dates={"6-7 September"};
    String[] prices={"Rs. 1100/-"};
    String[] contactnames1={"Rishi Raj Dayma"};
    String[] contactnames2={"Karan Katliwala"};
    String[] contactnums1={"9790766596"};
    String[] contactnums2={"9445480845"};
    public ArrayList<Event> getEvents()
    {
        ArrayList<Event> list=new ArrayList<>();
        for(int i=0;i<number;i++){
            Event obj=new Event();
            obj.title=titles[i%3];
            obj.image=images[i%3];
            obj.imageLarge=imagesLarge[i%3];
            obj.desc=desc[0];
            obj.date=dates[0];
            obj.price=prices[0];
            obj.contactname1=contactnames1[0];
            obj.contactname2=contactnames2[0];
            obj.contactnum1=contactnums1[0];
            obj.contactnum2=contactnums2[0];
            list.add(obj);
        }
        return list;
    }
}
