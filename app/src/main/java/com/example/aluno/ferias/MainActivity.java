package com.example.aluno.ferias;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.aluno.ferias.Utils.DataTimeUtils;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private Spinner spnspinner;
    private Button btnDataFim;
    private Button btnSelecione;
    private RadioGroup groupOpcao;
    private RadioButton radioSim;
    private RadioButton radioNão;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitacao);

        spnspinner = findViewById(R.id.spnComboBox);
        spnspinner.setAdapter(getAbonoSim());
        btnSelecione = findViewById(R.id.btnSelecione);
        btnDataFim = findViewById(R.id.btnDataFim);
        groupOpcao = findViewById(R.id.groupOpcao);
        radioSim = findViewById(R.id.radiosim);
        radioNão = findViewById(R.id.radionao);

    }

    private ArrayAdapter getAbonoSim(){

        return new ArrayAdapter<Integer>(this,
                R.layout.support_simple_spinner_dropdown_item,
                Arrays.asList(20,30));
    }

    private ArrayAdapter getAbonoNao(){

        return new ArrayAdapter<Integer>(this,
                R.layout.support_simple_spinner_dropdown_item,
                Arrays.asList(10,15,20,30));
    }

    private DatePickerDialog.OnDateSetListener dataListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int ano, int mes, int dia) {
            String data;
            String.valueOf(dia);
            String.valueOf(mes + 1);
            String.valueOf(ano);
        }
    };


    /*public void OnSelecioneAbono(View view){
       if (view.getId() == R.id.radiosim){

       }


    }*/

    public void OnRadioClick(View view){
        if (view.getId() == R.id.radiosim ){
            spnspinner.setAdapter(getAbonoSim());
        }
        else {
            spnspinner.setAdapter(getAbonoNao());
        }
    }

    private DatePickerDialog.OnDateSetListener dataselecione = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int ano, int mes, int dia) {

            btnSelecione.setText(DataTimeUtils.formatDate(dia, mes, ano));
        }
    };


    protected Dialog onCreateDialog(int id) {
        Calendar cal = Calendar.getInstance();
        int ano = cal.get(Calendar.YEAR);
        int mes = cal.get(Calendar.MONTH);
        int dia = cal.get(Calendar.DAY_OF_MONTH);

        switch (id) {
            case R.id.btnSelecione:
                return new DatePickerDialog(this, dataselecione, ano, mes, dia);
        }
        return null;
    }

    public void onSelecionarData (View view){

        showDialog(view.getId());

    }

    public void calcularDataFinal(View view) {

        Date dataInicio = DataTimeUtils.toDate(btnSelecione.getText().toString());
        DataTimeUtils.isMonday(dataInicio);

        if (!DataTimeUtils.isMonday(dataInicio)) {
            Toast toast = Toast.makeText(this, "É necessário selecionar uma Segunda - Feira", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            int dias = Integer.parseInt(spnspinner.getSelectedItem().toString());
            Date dataFim = DataTimeUtils.addDias(dataInicio, dias);
            btnDataFim.setText(DataTimeUtils.formatDate(dataFim));
        }


    }
}
