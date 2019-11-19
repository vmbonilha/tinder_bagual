package com.bonilha.tinder_bagual;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout tela ;
    private TextView tvSwipe;
    private int contador;
    private int pontos;
    private String[] perguntas = {"O céu é azul?","Laranja é uma fruta\n cítrica?","Mickey é um cachorro?","O planeta tem dois continentes?","Abacaxi é um legume?"};
    private String[] respostas = {"s","s","n","n","n"};
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