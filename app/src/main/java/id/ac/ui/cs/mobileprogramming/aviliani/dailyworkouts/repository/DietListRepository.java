package id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

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

    private MutableLiveData<Integer> currentDietList = new MutableLiveData<Integer>();

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



    public int[] getIds() {
        return dietListDao.getAllDays();
    }

    public MutableLiveData<Integer> getCurrentDietList() {
        return currentDietList;
    }

    public void setCurrentDietList(int day) {
        currentDietList.setValue(day);
    }

    public LiveData<DietList> getDailyDietList(int day) {
        return dietListDao.getDailyDietList(day);
        //        return new GetUsersAsyncTask(day).execute();
    }



//    class GetUsersAsyncTask extends AsyncTask<Void, Void, DietList>
//    {
//
//        private int day;
//
//        GetUsersAsyncTask(int day) {
//            this.day = day;
//        }
//        @Override
//        protected DietList doInBackground(Void... url) {
//            return db.dietListDao().getDailyDietList(day);
//        }
//
//        @Override
//        protected void onPostExecute(DietList result) {
//            super.onPostExecute(result);
//        }
//    }
}
