//package id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.repository;
//
//import android.content.Context;
//
//import androidx.lifecycle.MutableLiveData;
//
//import java.util.List;
//
//import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.dao.HIITActivitiesDao;
//import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.dao.ProfileDao;
//import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.database.AppDatabase;
//import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.entity.HIITActivitiesActivity;
//import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.entity.Profile;
//
//public class RoutinesRepository {
//
//    private final ProfileDao routinesDao;
//
//    private final HIITActivitiesDao activitiesDao;
//
//    private List<Profile> getAllDailyRoutines;
//
//    private List<HIITActivitiesActivity> getAllDailyActivity;
//
//    private String getUnit;
//
//    private int numOfDays;
//
//    private MutableLiveData<Integer> insertResult = new MutableLiveData<Integer>();
//
//    public RoutinesRepository(Context context) {
//        AppDatabase db = AppDatabase.getAppDatabase(context);
//        routinesDao = db.routinesDao();
//        activitiesDao = db.activitiesDao();
//        numOfDays = routinesDao.numOfDay()/5;
//        getAllDailyRoutines = routinesDao.findDailyRoutines(insertResult.getValue());
//
//        for (int i = 0; i < numOfDays; i++) {
//            getAllDailyActivity.add(activitiesDao.getActivityById(getAllDailyRoutines.get(i).getHeight()));
//        }
//    }
//
//    public int getNumOfDays() {
//        return numOfDays;
//    }
//
//    public List<Profile> getDailyRoutines() {
//        return getAllDailyRoutines;
//    }
//
//    public String getActivityUnit() {
//
//        return getUnit;
//    }
//
////    public void insertActivity(HIITActivitiesActivity activities) {
////        insertAsync(activities);
////    }
////
////    public void insertRoutines(Profile routines) {
////        insertAsyncRoutines(routines);
////    }
//
//    public void setInsertResult(Integer curr) {
//        insertResult.setValue(curr);
//    }
//
//
//    public MutableLiveData<Integer> getInsertResult() {
//        return insertResult;
//    }
//
////    private void insertAsync(final HIITActivitiesActivity activities) {
////
////        new Thread(new Runnable() {
////            @Override
////            public void run() {
////                try {
////                    routinesDao.insertAll();
////                    insertResult.postValue(1);
////                } catch (Exception e) {
////                    insertResult.postValue(0);
////                }
////            }
////        }).start();
////
////    }
////
////    private void insertAsyncRoutines(final Profile routines) {
////        new Thread(new Runnable() {
////            @Override
////            public void run() {
////                try {
////                    activitiesDao.insertAll();
////                    insertResult.postValue(1);
////                } catch (Exception e) {
////                    insertResult.postValue(0);
////                }
////            }
////        }).start();
////
////    }
//
//}
