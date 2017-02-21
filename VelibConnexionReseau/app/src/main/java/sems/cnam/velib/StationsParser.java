package sems.cnam.velib;


import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import static java.lang.Double.parseDouble;

/**
 * Created by Jean-marc on 25/10/2016.
 */

public class StationsParser extends DefaultHandler {
    private ArrayList<StationVelib> arrList;
    private XMLReader xr;

    public ArrayList<StationVelib> getArrList() {   return arrList; }
    public void setArrList(ArrayList<StationVelib> arrList) {
        this.arrList = arrList;
    }

    public static double parseDouble (String s){
        return Double.parseDouble(s);
    }

    public StationsParser() throws Exception {
        URL urlBase = new URL("http://www.velib.paris.fr/service/carto");
        InputSource is = new InputSource(urlBase.openStream());

        // traitement du parsing XML : factory XML, ...
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser();
        xr = sp.getXMLReader();
        xr.setContentHandler(this);

        xr.parse(is);
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        arrList = new ArrayList<StationVelib>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if (localName.equals("marker")) {
            StationVelib s = new StationVelib();
            s.setNom(attributes.getValue("name"));
            s.setNumero(attributes.getValue("number"));
            //set latitude and longitude
            s.setLatitude(parseDouble(attributes.getValue("lat")));
            s.setLongitude(parseDouble(attributes.getValue("lng")));
            arrList.add(s);
        }
    }
}

