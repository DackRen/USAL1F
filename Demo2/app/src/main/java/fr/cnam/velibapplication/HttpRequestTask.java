package fr.cnam.velibapplication;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;

import org.xml.sax.InputSource;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by fabrice on 09/11/2016.
 */

public class HttpRequestTask extends AsyncTask<String, Void, Void> {
    private Context context;
    private ListView listView;
    private List<StationVelib> stationList;
    public HttpRequestTask(Context ctx, ListView lv) {
        context = ctx;
        listView = lv;
    }
    @Override
    protected void onPreExecute() {
        Log.i("HttpRequestTask", "Beginning of task");
    }

    @Override
    protected Void doInBackground(String... strings) {
        if (strings.length == 1) {
            String urlValue = strings[0];
            try {
                URL urlVelib        = new URL(urlValue);
                // source is the XML stream
                InputSource source  = new InputSource(urlVelib.openStream());
                SAXParserFactory factory    = SAXParserFactory.newInstance();
                // parser analyze the input source
                SAXParser parser            = factory.newSAXParser();
                StationParser stationParser = new StationParser();
                parser.parse(source, stationParser);
                stationList                 = stationParser.getStationList();
            } catch (Exception e) {
                Log.e("HttpRequestTask", e.getMessage());
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        // 2- configure the list view
        listView.setAdapter(new StationAdapter(context, stationList));
    }
}
