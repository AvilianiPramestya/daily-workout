package id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import java.util.List;

import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.entity.DietList;
import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.repository.DietListRepository;

public class DailyRoutinesViewModel extends AndroidViewModel {

    private DietListRepository dietListRepository;
    private LiveData<List<DietList>> allDietList;

    public DailyRoutinesViewModel(@NonNull Application application) {
        super(application);
        dietListRepository = new DietListRepository(application);
        allDietList = dietListRepository.getAllDietList();
    }

    public LiveData<List<DietList>> getAllDietList() {
        return allDietList;
    }



}
