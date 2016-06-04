package mx.unam.petagram.vista.fragment;

import java.util.ArrayList;

import mx.unam.petagram.adapter.MascotaAdaptador;
import mx.unam.petagram.model.Mascota;

/**
 * Created by Cuauhtlehuanitl on 03/06/2016.
 */
public interface IRecyclerViewFragmentView {
    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> contactos);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
