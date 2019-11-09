package id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.dao.DietListDao;
import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.dao.HIITActivitiesDao;
import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.database.AppDatabase;
import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.entity.DietList;
import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.entity.HIITActivities;

public class DietListRepository {

    private final DietListDao dietListDao;

    private final HIITActivitiesDao hiitActivitiesDao;

    private LiveData<List<DietList>> allDietList;

    private LiveData<List<HIITActivities>> allHIITActivities;

    private final AppDatabase db;


    public DietListRepository(Context context) {
        db = AppDatabase.getAppDatabase(context);
        dietListDao = db.dietListDao();
        hiitActivitiesDao = db.hiitActivitiesDao();
        allDietList = dietListDao.getAll();
        allHIITActivities = hiitActivitiesDao.getAll();
    }

    public LiveData<List<DietList>> getAllDietList() {
        return allDietList;
    }

    public LiveData<List<HIITActivities>> getAllHIITActivities() {
        return allHIITActivities;
    }



}
