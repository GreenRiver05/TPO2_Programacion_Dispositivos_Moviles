package com.aprendiendo.practico2;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.aprendiendo.practico2.databinding.ActivityLibroBinding;
import com.aprendiendo.practico2.modelo.Libro;

public class LibroActivity extends AppCompatActivity {

    private ActivityLibroBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLibroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Libro libroRecibido = (Libro) getIntent().getSerializableExtra("libro");
        binding.tvTitulo.setText(libroRecibido.getTitulo());
        binding.tvEtiqueta.setText(libroRecibido.getEtiqueta());
        binding.tvAutor.setText(libroRecibido.getAutor());
        binding.tvAnio.setText(String.valueOf(libroRecibido.getAnio()));
        binding.tvPaginas.setText(String.valueOf(libroRecibido.getPaginas()));
        binding.tvDescripcion.setText(libroRecibido.getDescripcion());
        binding.tvEditorialISBN.setText("Editorial: " + libroRecibido.getEditorial() + "   -   ISBN: " + libroRecibido.getISNB() + ".");
        binding.imgPortada.setImageResource(libroRecibido.getImagen());
        binding.tvEtiqueta.setBackgroundColor(Color.parseColor(libroRecibido.getColorFondo()));
        binding.tvEtiqueta.setTextColor(Color.parseColor(libroRecibido.getColorTexto()));
    }
}
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