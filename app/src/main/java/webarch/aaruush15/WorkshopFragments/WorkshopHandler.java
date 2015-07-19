package webarch.aaruush15.WorkshopFragments;

import java.util.ArrayList;

import webarch.aaruush15.R;

/**
 * Created by Chinmay on 18-Jul-15.
 */
public class WorkshopHandler {

    int number=7;
    String[] titles={"Eye Robotics","Surveilance Quadcopter","Tall Building Design","Vehicle Over Hauling","Hacktrack","Digipreneur","Big Data Analysis"};
    Integer[] images={R.drawable.eyerobotics,R.drawable.surveillancequadcopter,R.drawable.tallbuildingdesign,R.drawable.vehicleoverhauling,R.drawable.hacktrack,R.drawable.digipreneur,R.drawable.bigdataanalysis};
    String[] descriptions={"The quick brown fox jumped over the lazy dog. The quick brown fox jumped over the lazy dog. The quick brown fox jumped over the lazy dog. The quick brown fox jumped over the lazy dog. The quick brown fox jumped over the lazy dog."};
    String[] dates={"6-7 September"};
    String[] prices={"Rs. 1100/-"};
    String[] contactnames1={"Rishi Raj Dayma"};
    String[] contactnames2={"Karan Katliwala"};
    String[] contactnums1={"9790766596"};
    String[] contactnums2={"9445480845"};
    public ArrayList<Workshop> getWorkshops()
    {
        ArrayList<Workshop> list=new ArrayList<>();
        for(int i=0;i<number;i++){
            Workshop obj=new Workshop();
            obj.title=titles[i];
            obj.image=images[i];
            obj.description=descriptions[0];
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
