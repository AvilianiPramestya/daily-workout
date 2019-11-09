package id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.entity.HIITActivities;
import id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts.repository.DietListRepository;

public class HIITActivitiesViewModel extends AndroidViewModel {

    private DietListRepository dietListRepository;
    private LiveData<List<HIITActivities>> allHIITActivities;

    public HIITActivitiesViewModel(@NonNull Application application) {
        super(application);
        dietListRepository = new DietListRepository(application);
        allHIITActivities = dietListRepository.getAllHIITActivities();
    }

    public LiveData<List<HIITActivities>> getAllActivities() {
        return allHIITActivities;
    }


}
