package mx.unam.petagram.pojo;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toolbar;

import java.util.ArrayList;

import mx.unam.petagram.adapter.MascotaAdaptador;
import mx.unam.petagram.R;
import mx.unam.petagram.db.BaseDatos;
import mx.unam.petagram.model.Mascota;


public class Favoritos extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;
    private Context context;

    private android.support.v7.widget.Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }


        rvMascotas = (RecyclerView) findViewById(R.id.rvFavoritos); //Manipulación del objeto definido en el layout, dentro de java

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //GridLayoutManager glm = new GridLayoutManager(this,2);

        rvMascotas.setLayoutManager(llm); //El recyclerview se comporte como linearlayout
        inicializarListaMascotas();
        inicializarAdaptador();
        //obtenerUltimos5();
    }

    public MascotaAdaptador adaptador;
    public void inicializarAdaptador() {
        adaptador = new MascotaAdaptador(mascotas);
        rvMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas() {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.puppy4, "Puppy 4", 2));
        mascotas.add(new Mascota(R.drawable.puppy6, "Puppy 6", 5));
        mascotas.add(new Mascota(R.drawable.puppy9, "Puppy 9", 2));
        mascotas.add(new Mascota(R.drawable.puppy2, "Puppy 2", 1));
        mascotas.add(new Mascota(R.drawable.puppy7, "Puppy 7", 3));

    }

    public ArrayList<Mascota> obtenerUltimos5(){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerUltimos5Contactos();
    }


}
