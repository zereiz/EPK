package ba.eki.epk.Model;

/**
 * Created by zoran.ereiz on 12.12.2015.
 */
public class NavigationDrawerItem {

    private String label;
    private int icon;
    private String counter;
    private boolean isCounterVisible;

    public NavigationDrawerItem(String label, int icon, String counter, boolean isCounterVisible) {
        this.label = label;
        this.icon = icon;
        this.counter = counter;
        this.isCounterVisible = isCounterVisible;
    }

    public NavigationDrawerItem(String label, int icon) {
        this.label = label;
        this.icon = icon;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getCounter() {
        return counter;
    }

    public void setCounter(String counter) {
        this.counter = counter;
    }

    public boolean isCounterVisible() {
        return isCounterVisible;
    }

    public void setCounterVisible(boolean isCounterVisible) {
        this.isCounterVisible = isCounterVisible;
    }
}