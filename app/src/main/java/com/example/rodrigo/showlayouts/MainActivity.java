package com.example.rodrigo.showlayouts;

import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        //Obtenemos la referencia al xml
        RelativeLayout defaultLayout;
        LinearLayout errorLayout;
        Button btnDefault,btnErrorLayout;

        //Constructor
        public PlaceholderFragment() {
        }

        /**
         * Inflamos la vista
         * @param inflater
         * @param container
         * @param savedInstanceState
         * @return
         */
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            return rootView;
        }

        /**
         * Una vez creada la activity
         * @param savedInstanceState
         */
        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);

            //Error layout
            btnErrorLayout = (Button)getActivity().findViewById(R.id.btnErrorLayout);
            errorLayout = (LinearLayout)getActivity().findViewById(R.id.errorLayout);
            //Escondemos el error layout
            errorLayout.setVisibility(LinearLayout.GONE);

            //Habilitamos el evento del boton del error layout
            btnErrorLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Escondemos el layout de error mostramos el layout por defecto
                    errorLayout.setVisibility(View.GONE);
                    defaultLayout.setVisibility(View.VISIBLE);
                }
            });


            //Default layout
            defaultLayout = (RelativeLayout)getActivity().findViewById(R.id.defaultLayout);
            btnDefault = (Button) getActivity().findViewById(R.id.btnDefault);
            //Habilitamos el evento en el boton del layout por defecto
            btnDefault.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //mostramos el layout de error y escondemos el layout por defecto
                    errorLayout.setVisibility(View.VISIBLE);
                    defaultLayout.setVisibility(View.GONE);

                }
            });

        }

    }
}
