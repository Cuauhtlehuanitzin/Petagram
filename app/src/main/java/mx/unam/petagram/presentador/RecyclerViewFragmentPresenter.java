package mx.unam.petagram.presentador;

import android.content.Context;
import mx.unam.petagram.model.ConstructorMascota;
import mx.unam.petagram.model.Mascota;
import mx.unam.petagram.vista.fragment.IRecyclerViewFragmentView;
import java.util.ArrayList;

/**
 * Created by Cuauhtlehuanitl on 03/06/2016.
 */
public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascota constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public  RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerMascotas();
    }

    @Override
    public void obtenerMascotas() {
        constructorMascotas = new ConstructorMascota(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }


    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }

}
