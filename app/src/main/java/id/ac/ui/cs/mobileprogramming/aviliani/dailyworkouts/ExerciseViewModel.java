//package id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts;
//
//import androidx.lifecycle.MutableLiveData;
//import androidx.lifecycle.ViewModel;
//
//public class ExerciseViewModel extends ViewModel {
//
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
//
//}
