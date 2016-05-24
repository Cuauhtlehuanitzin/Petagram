package mx.unam.petagram.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.unam.petagram.R;
import mx.unam.petagram.adapter.MascotaAdaptador;
import mx.unam.petagram.pojo.Mascota;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Asigna la clase de java al layout fragment_recyclerview (layout dentro del objeto "v")
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas); //Manipulación del objeto definido en el layout dentro de java

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //GridLayoutManager glm = new GridLayoutManager(this, 2);

        rvMascotas.setLayoutManager(llm); //El recyclerview se comporte como linearlayout
        inicializarDatos();
        inicializarAdaptador();

        return v;
    }

    public RecyclerViewFragment() {
        // Required empty public constructor
    }

    public void inicializarDatos() {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.pastor, "Huitzi", "9"));
        mascotas.add(new Mascota(R.drawable.bulldog, "Miztli", "7"));
        mascotas.add(new Mascota(R.drawable.chihuahua, "Grandote", "2"));
        mascotas.add(new Mascota(R.drawable.xolo, "Itzcuintli", "10"));
        mascotas.add(new Mascota(R.drawable.salchicha, "Hot dog", "4"));

    }

    public MascotaAdaptador adaptador;
    public void inicializarAdaptador() {
        adaptador = new MascotaAdaptador(mascotas,getActivity());
        rvMascotas.setAdapter(adaptador);
    }




}
