package com.example.aluno.ferias;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    private RadioButton radioSim;
    private RadioButton radioNão;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitacao);
        this.radioSim = findViewById(R.id.radioSim);
        this.radioNão = findViewById(R.id.radioNão);
    }
}
