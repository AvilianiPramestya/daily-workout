package id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "dietList")
public class DietList {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name="snack")
    private String snack;

    @ColumnInfo(name = "breakfast")
    private String breakfast;

    @ColumnInfo(name = "lunch")
    private String lunch;

    @ColumnInfo(name = "dinner")
    private String dinner;

    public DietList(int id, String breakfast, String snack, String lunch, String dinner) {
        this.id = id;
        this.breakfast = breakfast;
        this.snack = snack;
        this.lunch = lunch;
        this.dinner = dinner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public String getSnack() {
        return snack;
    }

    public void setSnack(String snack) {
        this.snack = snack;
    }

    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
    }

    public static DietList[] populateData() {
        return new DietList[] {
                new DietList(1, "Oatmeal porridge", "Any no-salted nuts", "2 pieces of whole-grain toast with vegetables", "Chicken salad"),
                new DietList(2, "Oats with fat-free milk", "1 cookie", "Vegetable salad", "Any grilled or boiled fish or seafood"),
                new DietList(3, "2 scrambled eggs", "Yogurt", "Brown rice with boiled vegetables", "3 baked potatoes with boiled lean meats"),
                new DietList(4, "2 pieces of whole-grain toast with vegetables", "Fat-free yogurt", "Any grilled or boiled fish or seafood", "Cooked or boiled corn"),
                new DietList(5, "2 scrambled eggs", "Any no-salted nuts", "Cooked or baked beans", "Smoothie or low-fat yogurt"),
                new DietList(6, "Oats with fat-free milk", "Some hummus or mashed potatoes", "Cooked or boiled vegetables", "Fruit salad"),
                new DietList(7, "Cooked or boiled corn with vegetables", "1 cookie", "Omelet out of three eggs and some vegetables", "Vegetable salad"),
                new DietList(8, "2 pieces of whole-grain toast with vegetables", "Fat-free yogurt with some berries", "Boiled noodles with boiled potatoes", "Any vegetable soup with no salt added"),
                new DietList(9, "Oatmeal porridge", "1 cookie", "Any grilled or boiled lean meats", "Chicken salad"),
                new DietList(10, "Cooked or boiled corn with vegetables", "Some hummus or mashed potatoes", "Cooked or baked beans", "Any grilled or boiled fish or seafood"),
                new DietList(11, "2 scrambled eggs and whole-grain toast", "Yogurt", "Cooked or boiled vegetables", "Any grilled or boiled lean meats"),
                new DietList(12, "Oats with fat-free milk", "Any no-salted nuts", "Brown rice with vegetable soup with no salted added", "Chicken salad"),
                new DietList(13, "Omelet out of three eggs and some vegetables", "1 cookie", "Smoothie or low-fat yogurt", "Any grilled or boiled fish or seafood"),
                new DietList(14, "Oats with fat-free milk", "Any no-salted nuts", "Chicken salad", "3 baked or boiled potatoes"),
                new DietList(15, "Oatmeal porridge", "1 cookie", "Smoothie or low-fat yogurt", "Yogurt"),
                new DietList(16, "1 piece of whole-grain bread or toast", "Fat-free yourt or milk with some berries", "Oats with fat-free milk", "Any vegetable soup with no salt added"),
                new DietList(17, "Omelet out of three eggs and some vegetables", "Some hummus or mashed potatoes", "Brown rice or boiled vegetables", "Fruit salad"),
                new DietList(18, "Oats with fat-free milk", "Some cooked or boiled corn", "Oatmeal porridge", "Vegetable salad"),
                new DietList(19, "Cooked or boiled corn with vegetables", "1 pieces of cheese", "Omelet out of three eggs and some vegetables", "Cooked or boiled vegetables"),
                new DietList(20, "2 scrambled eggs", "Some hummus or mashed potatoes", "Oatmeal porridge", "3 baked or boiled potatoes"),
                new DietList(21, "Cooked or boiled corn with vegetables", "Some hummus or mashed potatoes", "2 pieces of whole-grain toast with vegetables", "Fat-free yogurt with some berries"),
                new DietList(22, "Oatmeal porridge", "Any no-salted nuts", "Chicken salad", "Vegetable salad"),
                new DietList(23, "1 piece of whole-grain bread or toast", "1 cookie", "Cooked or boiled corn with vegetables", "Any grilled or boiled fish or seafood"),
                new DietList(24, "Oats with fat-free milk", "1 piece of cheese", "2 pieces of whole-grain toast with vegetables", "Cooked or boiled vegetables"),
                new DietList(25, "Oats with fat-free milk", "Any no-salted nuts", "Cooked or boiled vegetables", "Smoothie or law-fat yogurt"),
                new DietList(26, "Omelet out of three eggs and some vegetables", "1 cookie", "Brown rice with 3 bakes or boiled potatoes", "Any grilled or boiled fish or seafood"),
                new DietList(27, "Oatmeal porridge", "Fat-free yogurt or milk with some berries", "Oats with fat-free milk", "Fruit salad"),
                new DietList(28, "1 piece of whole-grain bread or toast", "1 cookie", "Fruit salad", "Chicken salad"),
                new DietList(29, "Omelet out of three eggs and some vegetables", "Any no-salted nuts", "Brown rice with cooked or boiled vegetables", "Any grilled or boiled lean meats"),
                new DietList(30, "2 scrambled eggs", "Cooked or boiled corn", "Oatmeal porridge", "Any grilled or boiled fish or seafood"),
        };
    }
}
