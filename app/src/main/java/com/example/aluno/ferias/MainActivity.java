package com.example.aluno.ferias;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private Spinner spnspinner;
    private RadioButton radioSim;
    private RadioButton radioNão;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitacao);
        this.radioSim = findViewById(R.id.radioSim);
        this.radioNão = findViewById(R.id.radioNão);
        spnspinner = findViewById(R.id.spnspinner);



        spnspinner = (Spinner) findViewById(R.id.spnspinner);
        spnspinner.setAdapter(radioSim());

    }
    private ArrayAdapter radioSim() {
        return new ArrayAdapter<Integer>(this,
                R.layout.support_simple_spinner_dropdown_item, Arrays.asList(20, 30));
    }

        private ArrayAdapter radioNão() {
            return new ArrayAdapter<Integer>(this,
                    R.layout.support_simple_spinner_dropdown_item, Arrays.asList(10,15,20,30));

        }
        public void  OnRadioClick (View view) {
            if (view.getId() == R.id.radioSim)
            {
                spnspinner.setAdapter(radioSim());
            }
            else {
                spnspinner.setAdapter(radioNão());
            }
        }
}



