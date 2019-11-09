package id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.Executors;

import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.dao.DietListDao;
import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.dao.HIITActivitiesDao;
import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.entity.DietList;
import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.entity.HIITActivities;

@Database(entities = {DietList.class, HIITActivities.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract DietListDao dietListDao();

    public abstract HIITActivitiesDao hiitActivitiesDao();

    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = buildDatabase(context);
        }
        return INSTANCE;
    }

    private static AppDatabase buildDatabase(final Context context) {
        return Room.databaseBuilder(context,
                AppDatabase.class,
                "dietList-database")
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                            @Override
                            public void run() {
                                getAppDatabase(context).dietListDao().insertAll(DietList.populateData());
                                getAppDatabase(context).hiitActivitiesDao().insertAll(HIITActivities.populateData());
//                                getAppDatabase(context).activitiesDao().insertAll(HIITActivitiesActivity.populateData());
//                                getAppDatabase(context).routinesDao().insertAll(Profile.populateData());
                            }
                        });
                    }
                })
                .build();
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
