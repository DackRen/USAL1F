package fr.cnam.velibapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class StationListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station_list);
        ListView listView       = (ListView)findViewById((R.id.stationList));
        // 1- create an async task which sends a Http request
        HttpRequestTask task    = new HttpRequestTask(this, listView);
        task.execute("http://www.velib.paris.fr/service/carto");
    }


}
