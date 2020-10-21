package com.example.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {
    EditText num1;
    EditText num2;
    RadioButton RB_suma;
    RadioButton RB_resta;
    RadioButton RB_multi;
    RadioButton RB_divi;
    TextView tx_resul;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Aqui hacemos la llamada por id de los elementos graficos al codigo
        num1 = (EditText) findViewById(R.id.tx_num1); //R es la clase padre desde la que buscaremos por ID.
        num2 = (EditText) findViewById(R.id.tx_num2);
        RB_suma = (RadioButton) findViewById(R.id.radioButton_suma);
        RB_resta = (RadioButton) findViewById(R.id.radioButton_resta);
        RB_multi = (RadioButton) findViewById(R.id.radioButton_multi);
        RB_divi = (RadioButton) findViewById(R.id.radioButton_divi);
        tx_resul = (TextView) findViewById(R.id.txt_resul);
    }
    public void Calcula(View view){
        //Recojo los valores del EditText
        String n1 = num1.getText().toString();
        String n2 = num2.getText().toString();

        //Compruebo si la cadena esta vacia o no para que muestre un aviso
        if((n1.isEmpty() && n2.isEmpty()) || n1.isEmpty() || n2.isEmpty()){
            Toast.makeText(this, "Rellena ambos numeros",Toast.LENGTH_SHORT).show();
        } else {
            //Convierto los valores de string a entero
            int n1_conv = Integer.parseInt(n1);
            int n2_conv = Integer.parseInt(n2);

            if(RB_suma.isChecked()){
                tx_resul.setText(suma(n1_conv,n2_conv));
            } else if(RB_resta.isChecked()){
                tx_resul.setText(restar(n1_conv,n2_conv));
                } else if(RB_multi.isChecked()){
                   tx_resul.setText(multiplica(n1_conv,n2_conv));
                 } else if(RB_divi.isChecked()){
                         tx_resul.setText(dividir(n1_conv,n2_conv));
                    } else {
                        Toast.makeText(this,"Tienes que seleccionar una de las opciones",Toast.LENGTH_SHORT).show();
                    }
            }

        }

    public int suma(int a, int b){
        return a+b;
    }
    public int restar(int a,int b){
        return a-b;
    }
    public int multiplica(int a,int b){
        return a*b;
    }
    public int dividir(int a,int b){
        return a/b;
    }
}