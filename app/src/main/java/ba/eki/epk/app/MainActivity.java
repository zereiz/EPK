package ba.eki.epk.app;

import android.app.Activity;
import android.app.Fragment;
import android.content.res.TypedArray;
import android.os.Bundle;
//import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import ba.eki.epk.Model.NavigationDrawerItem;
import ba.eki.epk.Model.NavigationDrawerListAdapter;
import ba.eki.epk.R;

public class MainActivity extends Activity {

    private DrawerLayout navDrawerLayout;
    private ListView navDrawerListView;
    private ActionBarDrawerToggle navDrawerToggle;

    private CharSequence navDrawerTitle;
    private CharSequence appTitle;

    private String[] navDrawerItemTitles;
    private TypedArray navDrawerIcons;

    private ArrayList<NavigationDrawerItem> navDrawerItems;
    private NavigationDrawerListAdapter navDrawerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.appTitle = this.getTitle();
        this.navDrawerTitle = this.getTitle();

        this.navDrawerLayout = (DrawerLayout) findViewById((R.id.drawer_layout));
        this.navDrawerListView = (ListView) findViewById(R.id.lst_navBar);

        this.navDrawerItemTitles = this.getResources().getStringArray(R.array.nav_drawer_strings);
        this.navDrawerIcons = this.getResources().obtainTypedArray(R.array.nav_drawer_icons);
        this.navDrawerItems = new ArrayList<>();

        this.navDrawerItems.add(new NavigationDrawerItem(navDrawerItemTitles[0], navDrawerIcons.getResourceId(0, -1))); //, String.valueOf(Session.brojPoruka), true));
        this.navDrawerItems.add(new NavigationDrawerItem(navDrawerItemTitles[1], navDrawerIcons.getResourceId(1, -1))); //, String.valueOf(Session.brojPosjeta), true));
        this.navDrawerItems.add(new NavigationDrawerItem(navDrawerItemTitles[2], navDrawerIcons.getResourceId(2, -1)));
        this.navDrawerItems.add(new NavigationDrawerItem(navDrawerItemTitles[3], navDrawerIcons.getResourceId(3, -1)));
        this.navDrawerItems.add(new NavigationDrawerItem(navDrawerItemTitles[4], navDrawerIcons.getResourceId(4, -1)));
        this.navDrawerItems.add(new NavigationDrawerItem(navDrawerItemTitles[5], navDrawerIcons.getResourceId(5, -1)));
        //this.navDrawerItems.add(new NavigationDrawerItem(navDrawerItemTitles[5], 0));

        navDrawerIcons.recycle();

        navDrawerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                DisplayFragment(i);
                setTitle(navDrawerItemTitles[i]);
                navDrawerListView.setItemChecked(i, true);
                navDrawerLayout.closeDrawer(navDrawerListView);
            }
        });

        this.navDrawerAdapter = new NavigationDrawerListAdapter(this.getApplicationContext(), navDrawerItems);
        this.navDrawerListView.setAdapter(navDrawerAdapter);

        this.getActionBar().setDisplayHomeAsUpEnabled(true);
        this.getActionBar().setHomeButtonEnabled(true);

        this.navDrawerToggle = new ActionBarDrawerToggle(this, this.navDrawerLayout, R.string.app_name, R.string.app_name) {
            @Override
            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle(navDrawerTitle);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                getActionBar().setTitle(appTitle);
                invalidateOptionsMenu();
            }
        };

        this.navDrawerLayout.setDrawerListener(this.navDrawerToggle);

        if(savedInstanceState == null)
            DisplayFragment(7);

    }

    private void DisplayFragment(int position)
    {
        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new OglasiFragment();
                break;
            case 1:
                fragment = new OglasiFragment(); //FindAdFragment();
                break;
            case 2:
                fragment = new OglasiFragment(); //NewAdFragment();
                break;
            case 3:
                fragment = new OglasiFragment(); //AboutFragment();
                break;
            case 4:
                fragment = new OglasiFragment(); //EKIFragment();
                break;
            case 5:
                fragment = new OglasiFragment(); //ContactFragment();
                break;
            default:
                fragment = new OglasiFragment();
                break;
        }

        if(fragment != null)
            this.getFragmentManager().beginTransaction().replace(R.id.frame_container, fragment).commit();
        else
            Log.e("EPK", "Unable to create fragment!");
        //return false;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
//        menu.findItem(R.id.action_settings).setVisible(!this.navDrawerLayout.isDrawerOpen(this.navDrawerListView));
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        this.navDrawerToggle.syncState();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.activity_home, menu);
//        return true;
//    }

    @Override
    public void setTitle(CharSequence title) {
        this.getActionBar().setTitle(title);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        if(this.navDrawerToggle.onOptionsItemSelected(item))
            return true;
        switch(item.getItemId())
        {
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
