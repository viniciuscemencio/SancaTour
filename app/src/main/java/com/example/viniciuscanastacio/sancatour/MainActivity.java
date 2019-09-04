package com.example.viniciuscanastacio.sancatour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.viniciuscanastacio.sancatour.adapter.TarefaAdapter;
import com.example.viniciuscanastacio.sancatour.modelos.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<Tarefa> tarefas = new ArrayList<>();
    private ArrayAdapter<Tarefa> arrayAdapterTarefa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        criarTarefas();



        listView = findViewById(R.id.listView);
        arrayAdapterTarefa = new TarefaAdapter(MainActivity.this,
                (ArrayList<Tarefa>) tarefas);
        listView.setAdapter(arrayAdapterTarefa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               /* Toast toast =  Toast.makeText(getApplicationContext(),
                        tarefas.get(position).getNome(), Toast.LENGTH_LONG);
                toast.show(); */

                Intent intent = new Intent(MainActivity.this, TarefaActivity.class);
                intent.putExtra("TITULO", tarefas.get(position).getNome());
                intent.putExtra("DESCRICAO", tarefas.get(position).getDescricao());
                startActivity(intent);
            }
        });


    }
    public void criarTarefas(){

        tarefas.add(new Tarefa("1", "Shoppping","2.8 Km"));
        tarefas.add(new Tarefa("2", "Catedral", "1.2 Km"));

    }

    /*public void imagem (String nome){
        if (nome.equals("Shopping")){
            imageView.setImageResource(R.drawable.shopping);
            tarefas.add(new Tarefa("1", "Shoppping","2.8 Km"));

        }
    }*/
}
