package ba.eki.epk.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ba.eki.epk.R;

/**
 * Created by zoran.ereiz on 12.12.2015.
 */
public class NavigationDrawerListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<NavigationDrawerItem> NavDrawerItems;

    public NavigationDrawerListAdapter(Context context, ArrayList<NavigationDrawerItem> navDrawerItems) {
        this.context = context;
        NavDrawerItems = navDrawerItems;
    }

    @Override
    public int getCount() {
        return NavDrawerItems.size();
    }

    @Override
    public Object getItem(int i) {
        return NavDrawerItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.nav_lst_item, null);
        }

        ImageView icon = (ImageView) convertView.findViewById(R.id.icon);
        TextView title = (TextView) convertView.findViewById(R.id.title);
        //TextView counter = (TextView) convertView.findViewById(R.id.counter);

        icon.setImageResource(NavDrawerItems.get(position).getIcon());
        title.setText(NavDrawerItems.get(position).getLabel());

       /* if (NavDrawerItems.get(position).isCounterVisible())
            counter.setText(NavDrawerItems.get(position).getCounter());
        else
            counter.setVisibility(View.GONE);*/

        return convertView;
    }
}

