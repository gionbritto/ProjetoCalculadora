package br.com.novo.prpjetocalculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextClock;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txt_screen)
    TextView display;
    CalcController calcController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        calcController = new CalcController(this);
        init();

    }

    private void init(){
        calcController.getDisplay(display);
    }
    @OnClick({
            R.id.btn_soma, R.id.btn_div, R.id.btn_mult, R.id.btn_subt,
            R.id.btn_ce, R.id.btn_equal, R.id.btn_dot, R.id.btn_n0,
            R.id.btn_n1, R.id.btn_n2, R.id.btn_n3, R.id.btn_n4,
            R.id.btn_n5, R.id.btn_n6, R.id.btn_n7, R.id.btn_n8,
            R.id.btn_n9
    })
    public void onButtonClicked(View view) {
        Log.d("CALC", view.getTag().toString());
        calcController.getInputValue(view.getTag().toString());
    }
}
