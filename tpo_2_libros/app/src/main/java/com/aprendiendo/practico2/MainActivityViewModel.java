package com.aprendiendo.practico2;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.aprendiendo.practico2.modelo.Libro;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private List<Libro> listaLibros = Arrays.asList(
            new Libro("El hobbit", "1234", "J.R.R Tolkien", "Mundo", "Una obra fundacional de la fantasía moderna, El Hobbit narra la transformación de Bilbo Bolsón, un hobbit apacible y hogareño, en un héroe inesperado. Invitado por el mago Gandalf a unirse a trece enanos liderados por Thorin Escudo de Roble, Bilbo se embarca en una travesía hacia la Montaña Solitaria para recuperar un tesoro custodiado por el dragón Smaug..", "Fantasia", 1937, 300),
            new Libro("El dia que Nietsche lloró", "5678", "Louis Vilton", "Campana", "Una novela filosófica y psicológica que imagina un encuentro ficticio entre el filósofo Friedrich Nietzsche y el médico vienés Josef Breuer, precursor del psicoanálisis. Ambientada en Viena en 1882, la historia comienza cuando Lou Salomé convence a Breuer de tratar a Nietzsche, quien atraviesa una profunda crisis emocional.", "Drama", 2005, 302),
            new Libro("Despierta", "1234", "Anthony De Melo", "Mundo", "Situada en el año 2060, esta novela distópica presenta un mundo donde casi toda interacción humana ocurre en línea. Maddie Freeman, hija del creador de la Escuela Digital, vive bajo estricta vigilancia y control tecnológico. Su vida da un giro cuando conoce a Justin, un joven que defiende la conexión humana real y rechaza la vida virtual.", "Autoayuda", 2010, 100),
            new Libro("Un Mundo Feliz", "9123", "Aldous Houxley", "Banana", "Una de las distopías más influyentes del siglo XX, esta novela presenta una sociedad futurista donde la estabilidad se logra mediante la manipulación genética, el condicionamiento psicológico y el consumo de una droga llamada soma. Los individuos son creados en laboratorios y divididos en castas (Alfas, Betas, Gammas, Deltas y Epsilones).", "Ciencia ficción", 2013, 235));

    private MutableLiveData<String> mutableError;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }


    public LiveData<String> getMutableError() {
        if (mutableError == null) {
            mutableError = new MutableLiveData<>();

        }
        return mutableError;

    }

    public void buscarLibro(String titulo) {

        int aux = 0;

        for (Libro libro : listaLibros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                aux++;
                Intent intent = new Intent(getApplication(), LibroActivity.class);
                intent.putExtra("libro", (Serializable) libro);
                intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
                getApplication().startActivity(intent);
            }
        }

        if (aux == 0) {
            mutableError.setValue("No se encontro el Libro");
        }
    }
}
