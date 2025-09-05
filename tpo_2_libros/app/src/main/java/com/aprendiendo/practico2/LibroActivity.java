package com.aprendiendo.practico2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.aprendiendo.practico2.databinding.ActivityLibroBinding;
import com.aprendiendo.practico2.modelo.Libro;

public class LibroActivity extends AppCompatActivity {

    private ActivityLibroBinding binding;
    private LibroActivityViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLibroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(LibroActivityViewModel.class);
        vm.getLibroRecuperado().observe(this, new Observer<Libro>() {
            @Override
            public void onChanged(Libro libro) {
                binding.tvTitulo.setText(libro.getTitulo());
                binding.tvEtiqueta.setText(libro.getEtiqueta());
                binding.tvAutor.setText(libro.getAutor());
                binding.tvAnio.setText(String.valueOf(libro.getAnio()));
                binding.tvPaginas.setText(String.valueOf(libro.getPaginas()));
                binding.tvDescripcion.setText(libro.getDescripcion());
                binding.tvEditorialISBN.setText("Editorial: " + libro.getEditorial() + "   -   ISBN: " + libro.getISNB() + ".");
                binding.imgPortada.setImageResource(libro.getImagen());
                binding.tvEtiqueta.setBackgroundColor(Color.parseColor(libro.getColorFondo()));
                binding.tvEtiqueta.setTextColor(Color.parseColor(libro.getColorTexto()));
            }
        });

        binding.ibRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LibroActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        vm.recuperarLibro(getIntent());

    }
}


//
//        binding.tvTitulo.setText(libroRecibido.getTitulo());
//        binding.tvEtiqueta.setText(libroRecibido.getEtiqueta());
//        binding.tvAutor.setText(libroRecibido.getAutor());
//        binding.tvAnio.setText(String.valueOf(libroRecibido.getAnio()));
//        binding.tvPaginas.setText(String.valueOf(libroRecibido.getPaginas()));
//        binding.tvDescripcion.setText(libroRecibido.getDescripcion());
//        binding.tvEditorialISBN.setText("Editorial: " + libroRecibido.getEditorial() + "   -   ISBN: " + libroRecibido.getISNB() + ".");
//        binding.imgPortada.setImageResource(libroRecibido.getImagen());
//        binding.tvEtiqueta.setBackgroundColor(Color.parseColor(libroRecibido.getColorFondo()));
//        binding.tvEtiqueta.setTextColor(Color.parseColor(libroRecibido.getColorTexto()));

//        switch (libroRecibido.getTitulo()) {
//            case "El hobbit":
//                binding.imgPortada.setImageResource(R.drawable.el_hobbit);
//                binding.tvEtiqueta.setBackgroundColor(Color.parseColor("#C2431F"));
//                binding.tvEtiqueta.setTextColor(Color.parseColor("#000000"));
//                break;
//            case "El dia que Nietsche lloró":
//                binding.tvEtiqueta.setBackgroundColor(Color.parseColor("#312112"));
//                binding.imgPortada.setImageResource(R.drawable.nietsche);
//                break;
//            case "Despierta":
//                binding.imgPortada.setImageResource(R.drawable.despierta);
//                binding.tvEtiqueta.setBackgroundColor(Color.parseColor("#EAE4C0"));
//                binding.tvEtiqueta.setTextColor(Color.parseColor("#000000"));
//
//                break;
//            case "Un Mundo Feliz":
//                binding.imgPortada.setImageResource(R.drawable.un_mundo_feliz);
//                binding.tvEtiqueta.setBackgroundColor(Color.parseColor("#315B62"));
//                binding.tvEtiqueta.setTextColor(Color.parseColor("#FFFFFF"));
//                break;
//        }