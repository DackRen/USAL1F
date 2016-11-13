package fr.cnam.velibapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by fabrice on 09/11/2016.
 */

public class StationAdapter extends ArrayAdapter<StationVelib> {
    private List<StationVelib> stationList;

    public StationAdapter(Context context, List<StationVelib> list) {
        super(context, R.layout.activity_station_list);
        stationList = list;
    }

    @Override
    public int getCount() {
        return stationList.size();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 1- create a view with a number and an address
        View line = null;
        if (convertView == null) {
            // Create un inflater for transforming an XML file into an object
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            line  = inflater.inflate(R.layout.station_velib, parent, false);
        } else {
            line = convertView;
        }
        StationVelib sv = stationList.get(position);
        TextView number = (TextView) line.findViewById(R.id.number);
        number.setText(sv.getNumero());
        TextView address = (TextView) line.findViewById(R.id.address);
        address.setText(sv.getNom());
        return line;
    }

}
