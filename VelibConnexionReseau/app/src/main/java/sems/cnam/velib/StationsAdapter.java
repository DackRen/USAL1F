package sems.cnam.velib;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jean-marc on 25/10/2016.
 */


public class StationsAdapter extends ArrayAdapter<StationVelib> {
    private ArrayList<StationVelib> arrList;

    public StationsAdapter(Context ctx, ArrayList<StationVelib> arrList) {
        super(ctx, R.layout.ligne_station, arrList);
        this.arrList = arrList;
    }

    /**
     * La méthode ci dessous construit l'item de la ListView,
     * qui sera à l'indice position
     * et retourne cet item
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Un LayoutInflater est un constructeur de View à partir d'une source XML
        // On l'obtient (et on ne le construit pas par new !)
        // par exemple par LayoutInflater.from(getContext());
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View row = inflater.inflate(R.layout.ligne_station, null);
        // le second argument est l'éventuel parent de la vue récupérée

        TextView label = (TextView) row.findViewById(R.id.item1);
        label.setText(arrList.get(position).getNom());

        return row;
    }

}