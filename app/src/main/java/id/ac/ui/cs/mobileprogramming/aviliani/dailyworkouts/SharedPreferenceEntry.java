package id.ac.ui.cs.mobileprogramming.aviliani.dailyworkouts;

/**
 * Model class containing personal information that will be saved to SharedPreferences.
 */
public class SharedPreferenceEntry {

    private final String prefName;

    private final String prefHeight;

    private final String prefWeight;

    public SharedPreferenceEntry(String name, String height, String weight) {
        prefName = name;
        prefHeight = height;
        prefWeight = weight;
    }

    public String getName() {
        return prefName;
    }

    public String getHeight() { return prefHeight; }

    public String getWeight() { return prefWeight; }
}