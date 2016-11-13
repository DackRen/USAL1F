package fr.cnam.velibapplication;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 1- have access to the list view
        listView = (ListView) findViewById(R.id.item_list);
        // 2- define an array of String
        String[] mainItems  = getResources().getStringArray(R.array.main_items);
        // 3- create a String adapter of String array to the ListView model
        ArrayAdapter<String> mainItemsAdapter
                = new ArrayAdapter<String>(this, R.layout.main_item, R.id.item_name, mainItems);
        // 4- configure the ListView and its adapter
        listView.setAdapter(mainItemsAdapter);
        // 5- add interaction an the ListView
        listView.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView adapterView, View view, int position, long id) {
        Toast.makeText(this, "position = "+ position, Toast.LENGTH_LONG).show();
        Intent msg = null;
        switch (position) {
            case 0:
                msg = new Intent(this, StationListActivity.class);
                break;
            case 1:
                msg = new Intent(this, AboutActivity.class);
                break;
        }
        startActivity(msg);
    }
}
