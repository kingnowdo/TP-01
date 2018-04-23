package com.reinaldoveazey.movieme;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListActivity extends Activity {

    private int modo=0; // 0 = modo em que o click abre tela de detales. 1 = modo em que o click remove o filme

    private void removerItem(int pos, MyAdapter adaptador){
        String msgRem = adaptador.remover(pos).getName() + " removido!";
        Toast.makeText(ListActivity.this,msgRem,Toast.LENGTH_SHORT).show();
    }
    private void setModoLista(){
        TextView title = findViewById(R.id.title);
        title.setText("Os seus filmes");
        modo = 0;
    }
    private void setModoRemover(){
        TextView title = findViewById(R.id.title);
        title.setText("Selecione alguém para excluir");
        modo = 1;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_lista,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_remove:
                if(modo==0) setModoRemover();
                else if(modo==1) setModoLista();
                else Toast.makeText(ListActivity.this,"Algo de errado aconteceu",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_ajuda:
                AlertDialog.Builder dialogoB = new AlertDialog.Builder(this);
                dialogoB.setTitle("Ajuda");
                dialogoB.setMessage("Clique na item lixeira na barra de ações para alternar para o modo de remoção e clique nele novamente para retornar ao modo normal");
                AlertDialog dialogo = dialogoB.create();
                dialogo.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

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
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                Movie item = (Movie) adaptador.getItem(position); //Pega o filme que foi selecionado

                if(modo==0) { //O click abre tela de detales
                    Intent intent = new Intent(ListActivity.this, FilmeDetalesActivity.class);

                    Bundle args = new Bundle();
                    args.putCharSequence("tarja", item.getTarja().toString());
                    args.putCharSequence("name", item.getName());
                    args.putCharSequence("nameDir", item.getNameDir());
                    args.putCharSequence("genero", item.getGenero());
                    args.putCharSequence("ano", item.getAno().toString());
                    intent.putExtras(args);

                    startActivity(intent);
                }
                else if(modo==1){ //O click abre diálogo para excluir um filme
                    AlertDialog.Builder dialogoB = new AlertDialog.Builder(ListActivity.this);
                    String msg = "Você deseja remover o filme " + item.getName() + " da sua lista?";
                    dialogoB.setTitle("Remover");
                    dialogoB.setMessage(msg);
                    dialogoB.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                        //Remover e voltar para modo 0
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            removerItem(position,adaptador);
                            Toast.makeText(ListActivity.this,"Apagou o " + adaptador.getItemM(position).getName(),Toast.LENGTH_SHORT).show();
                            setModoLista();
                        }
                    });
                    dialogoB.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        //Voltar para modo 0
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(ListActivity.this,"Nada removido",Toast.LENGTH_SHORT).show();
                            setModoLista();
                        }
                    });
                    dialogoB.setOnCancelListener(new DialogInterface.OnCancelListener() {
                        //Fazer nada
                        @Override
                        public void onCancel(DialogInterface dialog) {
                            Toast.makeText(ListActivity.this,"Selecione algum filme para ser removido",Toast.LENGTH_SHORT).show();
                        }
                    });
                    AlertDialog dialogo = dialogoB.create();
                    dialogo.show();
                }
            }
        });
    }
}
