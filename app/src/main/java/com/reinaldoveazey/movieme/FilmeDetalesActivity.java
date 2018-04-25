package com.reinaldoveazey.movieme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class FilmeDetalesActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filme_detales);

        Bundle inBundle = this.getIntent().getExtras();
        if(inBundle != null){   //Evitar null pointer exepsion
            //Pegar as entradas do bundle
            Integer tarja = Integer.parseInt(inBundle.getString("tarja")); //perigoso
            String name = inBundle.getString("name");
            String nameDir = inBundle.getString("nameDir");
            String genero = inBundle.getString("genero");
            String ano = inBundle.getString("ano");

            //Referenciar os itens do layout
            ImageView tarjaV = findViewById(R.id.detales_tarja);
            TextView nameV = findViewById(R.id.detales_nome_fil);
            TextView nameDirV = findViewById(R.id.detales_nome_dir);
            TextView generoV = findViewById(R.id.detales_genero);
            TextView anoV = findViewById(R.id.detales_ano);

            //Carregar o layout
            tarjaV.setImageResource(MyAdapter.obterImagemTarja(tarja));
            nameV.setText(name);
            nameDirV.setText(nameDir);
            generoV.setText(genero);
            anoV.setText(ano);

            Button botaoC = findViewById(R.id.detales_btCompartilha);

            //Fazer a mensagem
            String msgCompartilhar = "Veja esse filme: " + name + ", filme de " + genero + " do diretor " + nameDir + ". " + ano;
            if(tarja==0) msgCompartilhar = msgCompartilhar + ". Indicado para todos os públicos.";
            else msgCompartilhar = msgCompartilhar + ". Indicado para maiores de " + tarja + " anos.";
            final String msgCompartilharP = msgCompartilhar;

            botaoC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_TEXT, msgCompartilharP);
                    startActivity(intent);
                }
            });
        }
        else{
            Toast.makeText(this,"Algo de errado aconteceu",Toast.LENGTH_SHORT).show();
        }

    }
}
