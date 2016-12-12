package fr.cnam.velibapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class StationListActivity extends AppCompatActivity {
    //private StationParser sp = new StationParser();
    //private List<StationVelib> stationList;

    public StationListActivity() throws Exception {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station_list);
        ListView listView = (ListView)findViewById((R.id.stationList));

        // 1- create an async task which sends a Http request
        HttpRequestTask task    = new HttpRequestTask(this, listView);
        task.execute("http://www.velib.paris.fr/service/carto");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(StationListActivity.this,MapsActivity.class);
                //intent.putExtra("latitude", StationParser.stationList.get(position).getLatitude());
                //intent.putExtra("longitude", StationParser.stationList.get(position).getLongitude());
                startActivity(intent);
            }

        });
    }


}
