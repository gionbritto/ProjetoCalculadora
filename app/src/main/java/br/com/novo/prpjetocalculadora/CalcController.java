package br.com.novo.prpjetocalculadora;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Paulo on 18/01/2017.
 */

public class CalcController {
    private Context context;
    private TextView display;
    private String viewer;
    private float n1, n2;
    private String op;
    private boolean valid;
    private String aux;


    public CalcController(Context context) {
        this.context = context;
        viewer = "";
        clearValues();
    }

    public void getDisplay(TextView display) {
        this.display = display;
    }

    public void getInputValue(String value) {
        viewer +=  value;
        visualizar(viewer);
        checkInputValue(value);
    }

    public void visualizar(String value) {


        clearDisplay(value);
        display.setText(viewer);

    }

    public void clearValues() {
        op = "";
        n1 = -1;
        n2 = -1;
        aux = "";
    }

    public void clearDisplay(String clear) {
        if (clear.equals("ce")) {
            viewer = "";
            clearValues();
        }

    }

    public void checkInputValue(String value){
        if (value.equals("+") || value.equals("-") || value.equals("x") || value.equals("/")){
            op = value;
             n1 = Float.parseFloat(aux);
            aux = "";
        }else if(value.equals("=")) {
            n2 = Float.parseFloat(aux);
            aux = "";
            calculate();
        } else
            aux += value;
    }

    private void calculate() {
        switch (op) {
            case "+": soma();
                break;
            case "-": sub();
                break;
            case "x": mult();
                break;
            case "/": div();
                break;
        }
        clearValues();
    }

    private void soma() {
        float res = n1 + n2;
        visualizar(Float.toString(res));

    }
    private void sub() {
        float res = n1 - n2;
        visualizar(Float.toString(res));
    }
    private void mult() {
        float res = n1 * n2;
        visualizar(Float.toString(res));
    }
    private void div() {
        float res = n1 / n2;
        visualizar(Float.toString(res));
    }
}
