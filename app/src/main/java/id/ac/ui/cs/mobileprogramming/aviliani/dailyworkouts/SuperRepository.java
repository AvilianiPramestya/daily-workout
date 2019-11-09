//package id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts;
//
//import java.util.HashMap;
//
//public class SuperRepository {
//    private String dietList[];
//    private HashMap<String, DietList> superListDetails;
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
//        if(superListDetails == null){
//            createDietListDetailsMap();
//        }
//        return superListDetails.get(day);
//    }
//
//    public void createDietListDetailsMap(){
//        superListDetails = new HashMap<String, DietList>();
//
//        DietList dietList = new DietList();
//        dietList.setName("Hari ke-1");
//        dietList.setBreakfast("Nasi Goreng");
//        dietList.setLunch("Ayam Goreng");
//        dietList.setDinner("Steak");
//
//        superListDetails.put("Hari ke-1", dietList);
//
//        dietList = new DietList();
//        dietList.setName("Hari ke-2");
//        dietList.setBreakfast("Nasi Kuning");
//        dietList.setLunch("Rendang");
//        dietList.setDinner("Mie");
//
//        superListDetails.put("Hari ke-2", dietList);
//
//        dietList = new DietList();
//        dietList.setName("Hari ke-3");
//        dietList.setBreakfast("Roti");
//        dietList.setLunch("Nasi Padang");
//        dietList.setDinner("Pudding");
//
//        superListDetails.put("Hari ke-3", dietList);
//
//        dietList = new DietList();
//        dietList.setName("Hari ke-4");
//        dietList.setBreakfast("Nasi Kuning");
//        dietList.setLunch("Rendang");
//        dietList.setDinner("Mie");
//
//        superListDetails.put("Hari ke-4", dietList);
//
//        dietList = new DietList();
//        dietList.setName("Hari ke-5");
//        dietList.setBreakfast("Roti");
//        dietList.setLunch("Nasi Padang");
//        dietList.setDinner("Pudding");
//
//        superListDetails.put("Hari ke-5", dietList);
//
//    }
//
//
//}
