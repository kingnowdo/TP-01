package com.reinaldoveazey.movieme;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class ListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // faz a ligação entre a ListView e o Adapter
        ListView placesListView = findViewById(R.id.listmain);
        MyAdapter adaptador = new MyAdapter(this);
        placesListView.setAdapter(adaptador);
    }
}
