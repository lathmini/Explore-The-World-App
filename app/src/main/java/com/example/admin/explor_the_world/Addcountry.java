package com.example.admin.explor_the_world;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Addcountry extends AppCompatActivity {


    ListView listView;

    // Define string array.
    String[] listviewTitle = new String[]{



            "Afghanistan","Albania","Algeria","Andorra",
            "Angola","Antigua and Barbuda","Argentina","Armenia",
            "Australia","Austria","Azerbaijan","Bahamas",
            "Bahrain","Bangladesh","Barbados","Belarus",
            "Belgium","Belize","Benin","Bhutan",
            "Bolivia","Bosnia and Herzegovina","Botswana","Brazil",
            "Brunei","Bulgaria","Burkina Faso","Burundi",
            "Cote d'Ivoire","Cabo Verde","Cambodia","Cameroon",
            "Canada","Central African Republic","Chad","Chile",
            "China","Colombia","Comoros","Congo",
            "Costa Rica","Croatia","Cuba","Cyprus",
            "Czechia" ,"Democratic Republic of the Congo","Denmark","Djibouti",
            "Dominica",	"Dominican Republic","Ecuador","Egypt",
            "El Salvador","Equatorial Guinea","Eritrea","Estonia",
            "Eswatini" ,"Ethiopia","Fiji","Finland",
            "France","Gabon","Gambia","Georgia",
            "Germany","Ghana","Greece","Grenada",
            "Guatemala","Guinea","Guinea-Bissau","Guyana",
            "Haiti","Holy See","Honduras","Hungary",
            "Iceland","India","Indonesia","Iran",
            "Iraq","Ireland","Israel","Italy",
            "Jamaica","Japan","Jordan","Kazakhstan",
            "Kenya","Kiribati","Kuwait","Kyrgyzstan",
            "Laos","Latvia","Lebanon","Lesotho",
            "Liberia","Libya","Liechtenstein","Lithuania",
            "Luxembourg","Madagascar","Malawi","Malaysia",
            "Maldives","Mali","Malta","Marshall Islands",
            "Mauritania","Mauritius","Mexico","Micronesia",
            "Moldova","Monaco","Mongolia","Montenegro",
            "Morocco","Mozambique","Myanmar","Namibia",
            "Nauru","Nepal","Netherlands","New Zealand",
            "Nicaragua","Niger","Nigeria","North Korea",
            "North Macedonia","Norway","Oman","Pakistan",
            "Palau","Palestine State","Panama","Papua New Guinea",
            "Paraguay","Peru","Philippines","Poland",
            "Portugal","Qatar","Romania","Russia",
            "Rwanda","Saint Kitts and Nevis","Saint Lucia","Saint Vincent and the Grenadines",
            "Samoa","San Marino","Sao Tome and Principe","Saudi Arabia",
            "Senegal","Serbia","Seychelles","Sierra Leone",
            "Singapore"	,"Slovakia","Slovenia","Solomon Islands",
            "Somalia","South Africa","South Korea","South Sudan",
            "Spain","Sri Lanka","Sudan","Suriname",
            "Sweden","Switzerland","Syria","Tajikistan",
            "Tanzania","Thailand","Timor-Leste","Togo",
            "Tonga","Trinidad and Tobago","Tunisia","Turkey",
            "Turkmenistan","Tuvalu","Uganda","Ukraine",
            "United Arab Emirates","United Kingdom","United States of America","Uruguay",
            "Uzbekistan","Vanuatu","Venezuela","Vietnam",
            "Yemen","Zambia","Zimbabwe"
    };
    int[] listviewImage = new int[]{

            R.drawable.afghanistan, R.drawable.albania, R.drawable.algeria, R.drawable.andorra,
            R.drawable.angola, R.drawable.antigua_and_barbuda, R.drawable.argentina, R.drawable.armenia,
            R.drawable.australia, R.drawable.austria, R.drawable.azerbaijan, R.drawable.bahamas,
            R.drawable.bahrain, R.drawable.bangladesh, R.drawable.barbados, R.drawable.belarus,
            R.drawable.belgium, R.drawable.belize, R.drawable.benin, R.drawable.bhutan,
            R.drawable.bolivia, R.drawable.bosnia_and_herzegovina, R.drawable.botswana, R.drawable.brazil,
            R.drawable.brunei, R.drawable.bulgaria, R.drawable.burkina_faso, R.drawable.burundi,
            R.drawable.c_te_d_ivoire, R.drawable.cape_verde, R.drawable.cambodia, R.drawable.cameroon,
            R.drawable.canada, R.drawable.central_african_republic, R.drawable.chad, R.drawable.chile,
            R.drawable.chaina,R.drawable.colombia,R.drawable.comoros,R.drawable.congo,
            R.drawable.costa_rica,R.drawable.croatia,R.drawable.cuba,R.drawable.cyprus,
            R.drawable.czechia ,R.drawable.democratic,R.drawable.denmark,R.drawable.djibouti,
            R.drawable.dominica,R.drawable.dominican_republic,R.drawable.ecuador,R.drawable.egypt,
            R.drawable.el_salvador,R.drawable.equatorial_guinea,R.drawable.eritrea,R.drawable.estonia,
            R.drawable.eswatini ,R.drawable.ethiopia,R.drawable.fiji,R.drawable.finland,
            R.drawable.france,R.drawable.gabon,R.drawable.gambia,R.drawable.georgia,
            R.drawable.germany,R.drawable.ghana,R.drawable.greece,R.drawable.grenada,
            R.drawable.guatemala,R.drawable.guinea,R.drawable.guinea_bissau,R.drawable.guyana,
            R.drawable.haiti,R.drawable.holy_see,R.drawable.honduras,R.drawable.hungary,
            R.drawable.iceland,R.drawable.indi,R.drawable.indonesia,R.drawable.iran,
            R.drawable.iraq,R.drawable.ireland,R.drawable.israel,R.drawable.italy,
            R.drawable.jamaica,R.drawable.japanaya,R.drawable.jordan,R.drawable.kazakhstan,
            R.drawable.kenya,R.drawable.kilarge,R.drawable.kuwait,R.drawable.kirgiziztan,
            R.drawable.laos,R.drawable.latvia,R.drawable.lebanon,R.drawable.lesotho,
            R.drawable.liberia,R.drawable.libya,R.drawable.liechtenstein,R.drawable.lithuania,
            R.drawable.luxembourg,R.drawable.madagascar,R.drawable.malawi,R.drawable.malaya,
            R.drawable.maldives,R.drawable.mali,R.drawable.malta,R.drawable.marshall_islands,
            R.drawable.mauritania,R.drawable.mauritius,R.drawable.mexico,R.drawable.micronesia,
            R.drawable.moldova,R.drawable.monaco,R.drawable.mongolia,R.drawable.montenegro,
            R.drawable.morocco,R.drawable.mozambique,R.drawable.myanmar,R.drawable.namibia,
            R.drawable.nauru,R.drawable.nepal,R.drawable.netherlands,R.drawable.newzilandd,
            R.drawable.nicaragua,R.drawable.niger,R.drawable.nigeria,R.drawable.north_korea,
            R.drawable.north_macedonia,R.drawable.norway,R.drawable.oman,R.drawable.pakistan,
            R.drawable.palau,R.drawable.palestine,R.drawable.panama,R.drawable.papuwa,
            R.drawable.paraguay,R.drawable.peru,R.drawable.philip,R.drawable.poland,
            R.drawable.portugal,R.drawable.qatar,R.drawable.romania,R.drawable.russia,
            R.drawable.rwanda,R.drawable.saint_kitts,R.drawable.saint_lucia,R.drawable.saint_vincent,
            R.drawable.samoa,R.drawable.san_marino,R.drawable.sao_tome_principe,R.drawable.saudi_arabia,
            R.drawable.senegal,R.drawable.serbia,R.drawable.seychelles,R.drawable.sierra_leone,
            R.drawable.singapore	,R.drawable.slovakia,R.drawable.slovakia,R.drawable.solomon,
            R.drawable.somalia,R.drawable.southafrica,R.drawable.southkoreya,R.drawable.southsudan,
            R.drawable.spain,R.drawable.sriflag,R.drawable.sudan,R.drawable.suriname,
            R.drawable.sweden,R.drawable.switzerland,R.drawable.syria,R.drawable.tajikistan,
            R.drawable.tanzania,R.drawable.thailand,R.drawable.timor,R.drawable.togo,
            R.drawable.tonga,R.drawable.trinided,R.drawable.tunisia,R.drawable.turkey,
            R.drawable.turkmenistan,R.drawable.tuvalu,R.drawable.uganda,R.drawable.ukraine,
            R.drawable.arab_emirates,R.drawable.uk,R.drawable.usa,R.drawable.uruguay,
            R.drawable.usbekistan,R.drawable.vanuatu,R.drawable.venezuela,R.drawable.vietnam,
            R.drawable.yemen,R.drawable.zambia,R.drawable.zimbabwe
    };


    String[] listviewShortDescription = new String[]{
            "the Islamic Republic of Afghanistan","the Republic of Albania","the People's Democratic Republic of Algeria","the Principality of Andorra",
            "the Republic of Angola","Antigua and Barbuda","the Argentine Republic","the Republic of Armenia",
            "Australia","the Republic of Austria","the Republic of Azerbaijan","the Commonwealth of the Bahamas",
            "the Kingdom of Bahrain","the People's Republic of Bangladesh","Barbados","the Republic of Belarus",
            "the Kingdom of Belgium","Belize","the Republic of Benin","the Kingdom of Bhutan",
            "the Plurinational State of Bolivia","Bosnia and Herzegovina","the Republic of Botswana","the Federative Republic of Brazil",
            "Brunei Darussalam","the Republic of Bulgaria","Burkina Faso","the Republic of Burundi",
            "the Republic of Cote d'Ivoire","Republic of Cabo Verde","the Kingdom of Cambodia","the Republic of Cameroon",
            "Canada","the Central African Republic","the Republic of Chad","the Republic of Chile",
            "the People's Republic of China","the Republic of Colombia","the Union of the Comoros","the Republic of the Congo",
            "the Republic of Costa Rica","the Republic of Croatia","the Republic of Cuba","the Republic of Cyprus",
            "the Czech Republic" ,"Democratic Republic of the Congo","the Kingdom of Denmark","the Republic of Djibouti",
            "the Commonwealth of Dominica",	"the Dominican Republic","the Republic of Ecuador","the Arab Republic of Egypt",
            "the Republic of El Salvador","the Republic of Equatorial Guinea","the State of Eritrea","the Republic of Estonia",
            "the Kingdom of Eswatini" ,"the Federal Democratic Republic of Ethiopia","the Republic of Fiji","the Republic of Finland",
            "the French Republic","the Gabonese Republic","the Republic of the Gambia","Georgia",
            "the Federal Republic of Germany","the Republic of Ghana","the Hellenic Republic","Grenada",
            "the Republic of Guatemala","the Republic of Guinea","the Republic of Guinea-Bissau","the Co-operative Republic of Guyana",
            "the Republic of Haiti","Holy See","the Republic of Honduras","Hungary",
            "the Republic of Iceland","the Republic of India","the Republic of Indonesia","the Islamic Republic of Iran",
            "the Republic of Iraq","Ireland","the State of Israel","the Republic of Italy",
            "Jamaica","Japan","the Hashemite Kingdom of Jordan","the Republic of Kazakhstan",
            "the Republic of Kenya","the Republic of Kiribati","the State of Kuwait","the Kyrgyz Republic",
            "the Lao People's Democratic Republic ","the Republic of Latvia","the Lebanese Republic","the Kingdom of Lesotho",
            "the Republic of Liberia","State of Libya","Liechtenstein","the Republic of Lithuania",
            "the Grand Duchy of Luxembourg","the Republic of Madagascar","the Republic of Malawi","Malaysia",
            "the Republic of Maldives","the Republic of Mali","the Republic of Malta","the Republic of the Marshall Islands",
            "the Islamic Republic of Mauritania","the Republic of Mauritius","the United Mexican States","the Federated States of Micronesia ",
            "the Republic of Moldova","the Principality of Monaco","Mongolia","Montenegro",
            "the Kingdom of Morocco","the Republic of Mozambique","the Republic of the Union of Myanmar","the Republic of Namibia",
            "the Republic of Nauru","the Federal Democratic Republic of Nepal","the Kingdom of the Netherlands","New Zealand",
            "the Republic of Nicaragua","the Republic of the Niger","the Federal Republic of Nigeria","North Korea",
            "the Republic of North Macedonia","the Kingdom of Norway","the Sultanate of Oman","the Islamic Republic of Pakistan",
            "the Republic of Palau","Palestine State","the Republic of Panama","Independent State of Papua New Guinea",
            "the Republic of Paraguay","the Republic of Peru","the Republic of the Philippines","Poland",
            "the Portuguese Republic","the State of Qatar","Romania","the Russian Federation",
            "the Republic of Rwanda","Saint Kitts and Nevis","Saint Lucia","Saint Vincent and the Grenadines",
            "the Independent State of Samoa","the Republic of San Marino","the Democratic Republic of Sao Tome and Principe","Saudi Arabia",
            "the Republic of Senegal","the Republic of Serbia","the Republic of Seychelles","the Republic of Sierra Leone",
            "the Republic of Singapore"	,"the Slovak Republic","the Republic of Slovenia","Solomon Islands",
            "the Federal Republic of Somalia","the Republic of South Africa","South Korea","the Republic of South Sudan",
            "the Kingdom of Spain","the Democratic Socialist Republic of Sri Lanka","the Republic of the Sudan","the Republic of Suriname",
            "the Kingdom of Sweden","the Swiss Confederation","the Syrian Arab Republic","the Republic of Tajikistan",
            "the United Republic of Tanzania ","the Kingdom of Thailand","the Democratic Republic of Timor-Leste","the Togolese Republic",
            "the Kingdom of Tonga","the Republic of Trinidad and Tobago","the Republic of Tunisia","the Republic of Turkey",
            "Turkmenistan","Tuvalu","the Republic of Uganda","Ukraine",
            "the United Arab Emirates","the United Kingdom of Great Britain and Northern Ireland","United States of America","Uruguay",
            "Uzbekistan","the Republic of Vanuatu","the Bolivarian Republic of Venezuela ","the Socialist Republic of VietNam",
            "the Republic of Yemen","the Republic of Zambia","the Republic of Zimbabwe"


    };



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learn);

        listView = (ListView)findViewById(R.id.list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_2, android.R.id.text1, listviewTitle);

        listView.setAdapter(adapter);

        // ListView on item selected listener.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub

                // Getting listview click value into String variable.
                String TempListViewClickedValue = listviewTitle[position].toString();


                Intent intent = new Intent(Addcountry.this,Countrydetails.class);

                // Sending value to another activity using intent.
                intent.putExtra("ListViewClickedValue", TempListViewClickedValue);

                startActivity(intent);

            }
        });


        List<HashMap<String,String>> aList = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < 195; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("listview_title", listviewTitle[i]);
            hm.put("listview_discription", listviewShortDescription[i]);
            hm.put("listview_image", Integer.toString(listviewImage[i]));
            aList.add(hm);
        }
        String[] from = {"listview_image", "listview_title","listview_discription" };
        int[] to = {R.id.listview_image, R.id.listview_item_title, R.id.listview_item_short_description};
        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList,
                R.layout.listview, from, to);
        ListView androidListView = (ListView) findViewById(R.id.list_view);
        androidListView.setAdapter(simpleAdapter);

    }
}
