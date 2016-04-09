package ba.eki.epk.app;

import android.app.Fragment;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ba.eki.epk.BusinessModel.Oglasi;
import ba.eki.epk.Model.OglasiListAdapter;
import ba.eki.epk.R;
import ba.eki.epk.controller.HttpManager;

/**
 * Created by zoran.ereiz on 12.12.2015.
 */
public class OglasiFragment extends Fragment {

    private ListView lvOglasi;

    public OglasiFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View MyView = inflater.inflate(R.layout.fragment_oglasi, container, false);

        lvOglasi = (ListView) MyView.findViewById(R.id.lvOglasi);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        String podaci = HttpManager.responseFromUrlGet("http://192.168.0.181:8080/servisi_EPK/oglasi.php");

        Gson gson = new GsonBuilder().create();
        Oglasi[] rezultat = gson.fromJson(podaci, Oglasi[].class);

        Toast.makeText(MyView.getContext(), "Učitavanje podataka u toku", Toast.LENGTH_SHORT).show();

        OglasiListAdapter adapter = new OglasiListAdapter(MyView.getContext(), R.layout.lst_item_oglasi, rezultat);

        lvOglasi.setAdapter(adapter);

        return MyView;
    }


}
