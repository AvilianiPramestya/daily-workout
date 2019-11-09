//package id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts;
//
//import java.util.HashMap;
//
//public class TempRepository {
//    private String dietList[];
//    private HashMap<String, DietList> dietListDetails;
//    public String[] getPlayers(){
//        if(dietList == null){
//            dietList = new String[5];
//            dietList[0] = "Hari ke-1";
//            dietList[1] = "Hari ke-2";
//            dietList[2] = "Hari ke-3";
//            dietList[3] = "Hari ke-4";
//            dietList[4] = "Hari ke-5";
//        }
//
//        return dietList;
//    }
//
//    public DietList getDietListDetails(String day){
//        if(dietListDetails == null){
//            createDietListDetailsMap();
//        }
//        return dietListDetails.get(day);
//    }
//
//    public void createDietListDetailsMap(){
//        dietListDetails = new HashMap<String, DietList>();
//
//        DietList dietList = new DietList();
//        dietList.setName("Hari ke-1");
//        dietList.setBreakfast("Nasi Goreng");
//        dietList.setLunch("Ayam Goreng");
//        dietList.setDinner("Steak");
//
//        dietListDetails.put("Hari ke-1", dietList);
//
//        dietList = new DietList();
//        dietList.setName("Hari ke-2");
//        dietList.setBreakfast("Nasi Kuning");
//        dietList.setLunch("Rendang");
//        dietList.setDinner("Mie");
//
//        dietListDetails.put("Hari ke-2", dietList);
//
//        dietList = new DietList();
//        dietList.setName("Hari ke-3");
//        dietList.setBreakfast("Roti");
//        dietList.setLunch("Nasi Padang");
//        dietList.setDinner("Pudding");
//
//        dietListDetails.put("Hari ke-3", dietList);
//
//        dietList = new DietList();
//        dietList.setName("Hari ke-4");
//        dietList.setBreakfast("Nasi Kuning");
//        dietList.setLunch("Rendang");
//        dietList.setDinner("Mie");
//
//        dietListDetails.put("Hari ke-4", dietList);
//
//        dietList = new DietList();
//        dietList.setName("Hari ke-5");
//        dietList.setBreakfast("Roti");
//        dietList.setLunch("Nasi Padang");
//        dietList.setDinner("Pudding");
//
//        dietListDetails.put("Hari ke-5", dietList);
//
//    }
//
//}
