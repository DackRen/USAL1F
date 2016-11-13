package fr.cnam.velibapplication;


import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fabrice on 09/11/2016.
 */

public class StationParser extends DefaultHandler {
    private List<StationVelib> stationList;

    public StationParser() {
        stationList = new ArrayList<>();
    }

    @Override
    public void startDocument() throws SAXException {
        Log.i("StationParser", "Open the XML Stream");
    }

    @Override
    public void endDocument() throws SAXException {
        Log.i("StationParser", "Close the XML Stream");;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("marker")) {
            StationVelib stationVelib = new StationVelib();
            String numero   = attributes.getValue("number");
            stationVelib.setNumero(numero);
            String adresse  = attributes.getValue("address");
            stationVelib.setNom(adresse);
            stationList.add(stationVelib);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        Log.i("StationParser", "end qName : "+qName);
    }

    public List<StationVelib> getStationList() {
        return stationList;
    }
}
