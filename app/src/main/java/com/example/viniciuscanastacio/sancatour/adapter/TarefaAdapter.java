package com.example.viniciuscanastacio.sancatour.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.viniciuscanastacio.sancatour.R;
import com.example.viniciuscanastacio.sancatour.modelos.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class TarefaAdapter extends ArrayAdapter<Tarefa> {
    private Context context;
    private List<Tarefa> tarefas;
    private ImageView imageView;

    public TarefaAdapter(Context context, ArrayList<Tarefa> tarefas){
        super(context, 0, tarefas);
        this.tarefas = tarefas;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listaItem = convertView;
        if (listaItem == null) {
            listaItem = LayoutInflater.from(context).
                    inflate(R.layout.layout_lista_tarefa, parent, false);
        }
        Tarefa tarefaAtual = tarefas.get(position);

        TextView textViewNome = listaItem.findViewById(R.id.textViewNome);
        TextView textViewDistancia = listaItem.findViewById(R.id.textViewDistancia);
        ImageView imageViewLocal = listaItem.findViewById(R.id.imageView);
        textViewDistancia.setText(tarefaAtual.getDescricao());
        textViewNome.setText(tarefaAtual.getNome());






        return listaItem;


    }


}
