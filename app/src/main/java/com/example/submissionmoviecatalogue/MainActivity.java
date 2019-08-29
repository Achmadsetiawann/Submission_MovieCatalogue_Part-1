package com.example.submissionmoviecatalogue;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {

/*

Structure MainActivity =>  fragment_daftar_film.xml => DaftarFilm.java


*/

    private String[] dataName = {"Cut Nyak Dien","Ki Hajar Dewantara","Moh Yamin","Patimura","R A Kartini","Sukarno"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_daftar_film);

        ListView listView = findViewById(R.id.lv_dasboard_film);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, dataName);
        listView.setAdapter(adapter);

    }



}




