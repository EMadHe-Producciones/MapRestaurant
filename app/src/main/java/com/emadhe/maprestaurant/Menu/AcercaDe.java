package com.emadhe.maprestaurant.Menu;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.emadhe.maprestaurant.R;


public class AcercaDe extends DialogFragment {


    public ImageButton butonclose;


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // Como no sabe el layout padre, tendrá el de la aplicación
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Obtener una vista, para manipular los componentes del layout
        View view = inflater.inflate(R.layout.about_dialog, null);

        // Obtener la referencia del boton
        butonclose = view.findViewById(R.id.buttonclose);

        builder.setView(view);

        butonclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AcercaDe.super.dismiss();
            }
        });

        return builder.create();
    }


}
