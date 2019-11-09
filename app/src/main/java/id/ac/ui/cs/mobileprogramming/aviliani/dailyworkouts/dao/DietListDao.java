package id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.entity.DietList;

@Dao
public interface DietListDao {

    @Query("SELECT * FROM dietList")
    LiveData<List<DietList>> getAll();

    @Query("SELECT * FROM dietList WHERE id = :day")
    LiveData<DietList> getDailyDietList(int day);

    @Query("SELECT dietList.id FROM dietList")
    int[] getAllDays();

    @Insert
    void insertAll(DietList... dietLists);
}
