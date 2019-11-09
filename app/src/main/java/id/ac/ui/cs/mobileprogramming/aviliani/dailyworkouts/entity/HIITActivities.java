package id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.R;

@Entity(tableName = "hiit_activities")
public class HIITActivities {

    @PrimaryKey(autoGenerate = true)
    private int activity_id;

    @ColumnInfo(name = "activity_name")
    private String activity_name;

    @ColumnInfo(name = "unit")
    private int number;

    @ColumnInfo(name= "image")
    private int image;

    public HIITActivities(int activity_id, String activity_name, int number, int image) {
        this.activity_id = activity_id;
        this.activity_name = activity_name;
        this.number = number;
        this.image = image;
    }

    public int getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(int activity_id) {
        this.activity_id = activity_id;
    }

    public String getActivity_name() {
        return activity_name;
    }

    public void setActivity_name(String activity_name) {
        this.activity_name = activity_name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public static HIITActivities[] populateData() {
        return new HIITActivities[] {
                new HIITActivities(1, "SIDE HOP", 30, R.drawable.sidehop),
                new HIITActivities(2, "TRUNK ROTATION", 30, R.drawable.trunkrotation),
                new HIITActivities(3, "BUTT KICKS", 30, R.drawable.buttkicks),
                new HIITActivities(4, "JUMPING JACKS", 30, R.drawable.jumpingjacks),
                new HIITActivities(5, "STANDING BICYCLE CRUNCH", 30, R.drawable.standbicyclecrunch),
                new HIITActivities(6, "SUPERMAN", 30, R.drawable.superman),
                new HIITActivities(7, "RUSSIAN TWIST", 30, R.drawable.russiantwist),
                new HIITActivities(8, "REVERSE CRUNCHES", 30, R.drawable.reversecrunch),
                new HIITActivities(9, "SKIPPING WITHOUT ROPE", 30, R.drawable.skipping),
                new HIITActivities(10, "SQUATS", 30,  R.drawable.squats),
                new HIITActivities(11, "KNEE PUSH UPS", 30, R.drawable.kneepushup),
                new HIITActivities(12, "ALTERNATING HOOKS", 30,  R.drawable.alternatinghooks),
                new HIITActivities(13, "SKATER JUMP", 30,  R.drawable.skaterjump),
                new HIITActivities(14, "RIGHT QUAT STRETCH", 15, R.drawable.quadstretch),
                new HIITActivities(15, "LEFT QUAT STRETCH", 15, R.drawable.quadstretch),
        };
    }
}
