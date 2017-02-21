package sems.cnam.velib;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class ListingDesStationsActivity extends AppCompatActivity {
    private ListView listing;
    private StationsParser sp;
    private ProgressDialog progress;
    private StationsAdapter leStationsAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filtre_stations);

        listing = (ListView) findViewById(R.id.listViewFiltreStations);

        listing.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(ListingDesStationsActivity.this,MapsActivity.class);
                intent.putExtra("latitude", sp.getArrList().get(position).getLatitude());
                intent.putExtra("longitude", sp.getArrList().get(position).getLongitude());
                startActivity(intent);
            }

        });

        // a compléter par la définition de la classe interne à cette méthode
        // class ChargementDesStationsTache extends AsyncTask<Void, Void, Void>
        // ainsi que l'instanciation et le lancement de la méthode execute()
        // sur cette instance

        class ChargementDesStationsTache extends AsyncTask<Void, Void, Void> {
            protected void onPreExecute() {
                progress = ProgressDialog.show(ListingDesStationsActivity.this,
                        getResources().getString(R.string.app_name), getResources().getString(R.string.chargement_message),
                        true);
            }

            protected Void doInBackground(Void... urls) {
// charger les stations
                try {
                    sp = new StationsParser();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                leStationsAdapter = new StationsAdapter(getBaseContext(),
                        sp.getArrList());
                return null;
            }

            protected void onProgressUpdate(Void... aAfficher) {
            }

            protected void onPostExecute(Void result) {
// arréter le progressDialog
                progress.dismiss();
// mettre à jour la ListView des stations
                listing.setAdapter(leStationsAdapter);
            }
        }
        new ChargementDesStationsTache().execute();

    }
}
