package com.bonilha.tinder_bagual;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout tela;
    private TextView tvSwipe;
    private int contador;
    private int pontos;
    private String[] perguntas = {"Prenda que dança chula, é Bagual?","Prenda faz carreiteiro de charque, é Bagual?","Prenda dançante, é Bagual?","Prenda de barba, é Bagual?","Prenda com bafo, é Bagual?"};
    private String[] respostas = {"s","s","s","n","n"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSwipe = findViewById(R.id.tvSwipe);
        tela = findViewById(R.id.tela);
        contador = -1;
        pontos = 0;

        tela.setOnTouchListener(new OnSwipeTouchListener(this){

            @Override
            public void onSwipeBottom() {
                super.onSwipeBottom();
                if(respostas[contador] == "n"){
                    pontos++;
                }
                onSwipeLeft();
            }

            @Override
            public void onSwipeTop() {
                super.onSwipeTop();
                if(respostas[contador] == "s"){
                    pontos++;
                }
                onSwipeLeft();
            }

            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                if(contador == 4){
                    String msg = "Você acertou\n" + pontos + " perguntas!";
                    tvSwipe.setText(msg);
//                    AlertDialog.Builder alerta = new AlertDialog.Builder(getBaseContext());
//                    alerta.setIcon(android.R.drawable.ic_dialog_alert);
//                    alerta.setTitle("Atenção!");
//                    alerta.setMessage("Você acertou " + pontos + " perguntas!");
//                    alerta.setPositiveButton("OK", null);
//                    alerta.show();
                }else {
                    contador++;
                    tvSwipe.setText(perguntas[contador]);
                }
            }

            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                contador--;
                tvSwipe.setText(perguntas[contador]);
            }
        });

    }


}