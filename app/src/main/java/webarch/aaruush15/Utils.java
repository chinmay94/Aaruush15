package webarch.aaruush15;



import java.util.ArrayList;
import java.util.List;

import webarch.aaruush15.model.Friend;


public class Utils {
    public static final List<Friend> friends = new ArrayList<>();

    static {
        friends.add(new Friend(R.drawable.member, "Chinmay Kapoor", R.color.sienna, "Mobile App Domain Head"));
        friends.add(new Friend(R.drawable.memberr, " Pratik Shenoy ", R.color.saffron, "Mobile App Domain Head"));
        friends.add(new Friend(R.drawable.member, "Chinmay Kapoor", R.color.green, "Mobile App Domain Head"));
        friends.add(new Friend(R.drawable.memberr, " Pratik Shenoy ", R.color.pink, "Mobile App Domain Head"));
        friends.add(new Friend(R.drawable.member, "Chinmay Kapoor", R.color.orange, "Mobile App Domain Head"));
        friends.add(new Friend(R.drawable.memberr, " Pratik Shenoy ", R.color.saffron, "Mobile App Domain Head"));
        friends.add(new Friend(R.drawable.member, "Chinmay Kapoor", R.color.green, "Mobile App Domain Head"));
        friends.add(new Friend(R.drawable.memberr, " Pratik Shenoy ", R.color.purple, "Mobile App Domain Head"));
    }
}
