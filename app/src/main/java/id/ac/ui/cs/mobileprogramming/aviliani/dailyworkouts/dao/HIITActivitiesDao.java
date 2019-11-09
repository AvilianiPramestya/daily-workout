package id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.entity.HIITActivities;

@Dao
public interface HIITActivitiesDao {

    @Query("SELECT * FROM hiit_activities")
    LiveData<List<HIITActivities>> getAll();

    @Insert
    void insertAll(HIITActivities... activities);
}
