package sems.cnam.velib;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView laListe = (ListView) findViewById(R.id.listMenu);
        Resources res = getResources();
        String[] lesItems = new String[]{
                res.getString(R.string.seeAllStations),
                res.getString(R.string.aboutUs),
                res.getString(R.string.whereAmI)
        };
        laListe.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item, lesItems));

        laListe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    String message = "En cours de développement";
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), ListingDesStationsActivity.class);
                    startActivity(i);
                } else if (position == 1) {
                    Intent i = new Intent(getApplicationContext(), AProposVelibActivity.class);
                    startActivity(i);
                 }
                else{
                    Intent i = new Intent(MainActivity.this,MapsActivity.class);
                    i.putExtra("latitude", 0);
                    i.putExtra("longitude", 0);
                    startActivity(i);
                }
            }
        });
    }
}
