package com.reinaldoveazey.movieme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // faz a ligação entre a ListView e o Adapter
        ListView moviesListView = findViewById(R.id.listmain);
        final MyAdapter adaptador = new MyAdapter(this);
        moviesListView.setAdapter(adaptador);

        //Definir a ação de click
        moviesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListActivity.this,FilmeDetalesActivity.class);

                Bundle args = new Bundle();
                Movie item = (Movie) adaptador.getItem(position); //Pega o filme que foi selecionado
                args.putCharSequence("tarja",item.getTarja().toString());
                args.putCharSequence("name",item.getName());
                args.putCharSequence("nameDir",item.getNameDir());
                args.putCharSequence("genero",item.getGenero());
                args.putCharSequence("ano",item.getAno().toString());
                intent.putExtras(args);

                startActivity(intent);
            }
        });
    }
}
