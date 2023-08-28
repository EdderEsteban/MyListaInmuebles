package com.ddrssoft.mylistainmuebles;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ddrssoft.mylistainmuebles.modelo.Inmueble;

import java.util.ArrayList;
import java.util.List;

public class ViewModelMainActivity extends AndroidViewModel {
    //Declaracion y encapsulamiento de Variables
    private Context contexto;
    private List<Inmueble> inmueble;
    private MutableLiveData<List<Inmueble>> mutableInmueble;
    // Constructor
    public ViewModelMainActivity(@NonNull Application application) {
        super(application);
        contexto = application.getApplicationContext();
        inmueble = new ArrayList<>();
    }

    // Inicializacion del Mutable
    public LiveData<List<Inmueble>> getMutableInmueble(){
        if (mutableInmueble == null){
            mutableInmueble = new MutableLiveData<>();
        }
        return mutableInmueble;
    }

    // Funcion para agregar los Inmuebles a la Lista
    public void agregarInmueble(){
        inmueble.add(new Inmueble("San Luis", 250000, R.drawable.edificio1));
        inmueble.add(new Inmueble("Villa Mercedes", 350000, R.drawable.edificio2));
        inmueble.add(new Inmueble("Juana Koslay", 260000, R.drawable.edificio3));
        inmueble.add(new Inmueble("La Punta", 200000, R.drawable.edificio4));

        //Declararle al Mutable cual es la lista que esta esperando.
        mutableInmueble.setValue(inmueble);
    }

}
