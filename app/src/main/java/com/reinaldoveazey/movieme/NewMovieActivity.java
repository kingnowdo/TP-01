package com.reinaldoveazey.movieme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewMovieActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_movie);

        final EditText nome = findViewById(R.id.editar_nome);
        final EditText idade = findViewById(R.id.editar_idade);
        final EditText diretor = findViewById(R.id.editar_diretor);
        final EditText genero = findViewById(R.id.editar_genero);
        final EditText ano = findViewById(R.id.editar_ano);

        Button botaoOk = findViewById(R.id.editar_ok);

        botaoOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("nome",nome.getText().toString());
                bundle.putString("idade",idade.getText().toString());
                bundle.putString("diretor",diretor.getText().toString());
                bundle.putString("genero",genero.getText().toString());
                bundle.putString("ano",ano.getText().toString());

                Intent intent = new Intent();
                intent.putExtras(bundle);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
