package com.aprendiendo.practico2;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.aprendiendo.practico2.modelo.Libro;

public class LibroActivityViewModel extends AndroidViewModel {
    private MutableLiveData<Libro> libroRecuperado;

    public LibroActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<Libro> getLibroRecuperado() {
        if (libroRecuperado == null) {
            libroRecuperado = new MutableLiveData<>();
        }
        return libroRecuperado;
    }

    public void recuperarLibro(Intent intent) {
        Libro libroRecibido = (Libro) intent.getSerializableExtra("libro");
        libroRecuperado.setValue(libroRecibido);
    }
}
