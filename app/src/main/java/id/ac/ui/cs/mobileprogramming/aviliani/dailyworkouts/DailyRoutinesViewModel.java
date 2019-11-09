package id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


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


    public int[] getAllIds() {
        return dietListRepository.getIds();
    }

    public LiveData<DietList> getDietListDetails(int day) {
        return dietListRepository.getDailyDietList(day);
    }

    public void selectDietList(String day) {
        dietListRepository.setCurrentDietList(Integer.parseInt(day));
    }

    public MutableLiveData<Integer> getSelectedDietList() {
        return dietListRepository.getCurrentDietList();
    }


//    private final MutableLiveData<String> selectedList = new MutableLiveData<String>();
//
//    private TempRepository repository = new TempRepository();
//
//    public void selectDietList(String day) {
//        selectedList.setValue(day);
//    }
//
//    public MutableLiveData<String> getSelectedDietList() {
//        return selectedList;
//    }
//
//    public String[] getDietList(){
//        return repository.getPlayers();
//    }
//
//    public DietList getDietListDetails(String name){
//        return repository.getDietListDetails(name);
//    }



}
