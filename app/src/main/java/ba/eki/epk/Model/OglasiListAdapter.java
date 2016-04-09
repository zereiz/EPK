package ba.eki.epk.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import ba.eki.epk.BusinessModel.Oglasi;
import ba.eki.epk.R;

/**
 * Created by zoran.ereiz on 12.12.2015.
 */
public class OglasiListAdapter extends ArrayAdapter<Oglasi> {

    private Oglasi[] objects;

    public OglasiListAdapter(Context context, int resource, Oglasi[] objects) {
        super(context, resource, objects);
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Oglasi term = getItem(position);

        if(convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.lst_item_oglasi, parent, false);
        }

        TextView naslov = (TextView) convertView.findViewById(R.id.txtNaslov);

        // Populate the data into the template view using the data object
        naslov.setText(term.getNaslov());

        return convertView;
    }
}
