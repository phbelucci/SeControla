package com.example.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.BulletSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class novoLancamento_vw extends AppCompatActivity {


    private String botaoclicado = null;
    private int contQtdCliquesTeclado = 0;
    private TextView mostraValorFinal;
    private String valorFinalVw;
    private String categoriaFinalVw;
    private String formaPagtoFinalVw;
    private int formaPagtoEscolhida=0;
    private int formaPagtoSelecionada;
    String digito1 = null;
    String digito2 = null;
    String digito3 = null;
    String digito4 = null;
    String digito5 = null;
    String digito6 = null;
    String digito7 = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_lancamento_vw);

        Bundle pegaCategoria = getIntent().getExtras();
        categoriaFinalVw = pegaCategoria.getString("categoriaEscolhida");
        System.out.println(categoriaFinalVw);

    }

    public void chamarTelaInicio(View view){
        startActivity(new Intent(this, inicio_vw.class));

    }

    public void chamarTelaManterLancamentos(View view){

        //envia os dados para popular a lista dinamicamente
        System.out.println(valorFinalVw);
        Bundle novoLancamento = new Bundle();
        novoLancamento.putString("valorfinal",valorFinalVw);
        novoLancamento.putString("categoria",categoriaFinalVw);
        novoLancamento.putString("formapagto",formaPagtoFinalVw);

        Intent intent = new Intent(this, manter_lancamentos_vw.class);
        intent.putExtras(novoLancamento);
        startActivity(intent);
    }

    public void mostrarNumTela(String n){
        TextView campoEscolhido = findViewById(R.id.mostraValorFinalVwNovoLancamento);
        botaoclicado = n;
        if (contQtdCliquesTeclado > 7){
            contQtdCliquesTeclado--;
        };

        switch (contQtdCliquesTeclado){

            case 1:
                digito1 = botaoclicado;
                if(botaoclicado.equals("A")){
                    campoEscolhido.setText(",00");
                    contQtdCliquesTeclado--;
                    break;
                }
                else if(botaoclicado.equals("0")){
                    campoEscolhido.setText(",00");
                    break;
                } else if(botaoclicado.equals("C")){
                    campoEscolhido.setText(",00");
                    contQtdCliquesTeclado = 0;
                    break;
                }
                campoEscolhido.setText("0,0"+digito1);
                valorFinalVw = "R$ "+"0,0"+digito1;
                break;

            case 2:
                digito2 = botaoclicado;
                if(botaoclicado.equals("A")){
                    campoEscolhido.setText("0,0"+digito1);
                    contQtdCliquesTeclado--;
                    break;
                }else if(botaoclicado.equals("C")){
                    campoEscolhido.setText(",00");
                    contQtdCliquesTeclado = 0;
                    break;
                }
                campoEscolhido.setText("0,"+digito1+digito2);
                valorFinalVw = "R$ "+"0,"+digito1+digito2;
                break;

            case 3:
                digito3 = botaoclicado;
                if(botaoclicado.equals("A")){
                    campoEscolhido.setText("0,"+digito1+digito2);
                    contQtdCliquesTeclado--;
                    break;
                } else if(botaoclicado.equals("C")){
                    campoEscolhido.setText(",00");
                    contQtdCliquesTeclado = 0;
                    break;
                }
                campoEscolhido.setText(digito1+","+digito2+digito3);
                valorFinalVw = "R$ "+digito1+","+digito2+digito3;
                break;

            case 4:
                digito4 = botaoclicado;
                if(botaoclicado.equals("A")){
                    campoEscolhido.setText(digito1+","+digito2+digito3);
                    contQtdCliquesTeclado--;
                    break;
                } else if(botaoclicado.equals("C")){
                    campoEscolhido.setText(",00");
                    contQtdCliquesTeclado = 0;
                    break;
                }
                campoEscolhido.setText(digito1+digito2+","+digito3+digito4);
                valorFinalVw = "R$ "+digito1+digito2+","+digito3+digito4;
                break;

            case 5:
                digito5 = botaoclicado;
                if(botaoclicado.equals("A")){
                    campoEscolhido.setText(digito1+digito2+","+digito3+digito4);
                    contQtdCliquesTeclado--;
                    break;
                } else if(botaoclicado.equals("C")){
                    campoEscolhido.setText(",00");
                    contQtdCliquesTeclado = 0;
                    break;
                }
                campoEscolhido.setText(digito1+digito2+digito3+","+digito4+digito5);
                valorFinalVw = "R$ "+digito1+digito2+digito3+","+digito4+digito5;
                break;

            case 6:
                digito6 = botaoclicado;
                if(botaoclicado.equals("A")){
                    campoEscolhido.setText(digito1+digito2+digito3+","+digito4+digito5);
                    contQtdCliquesTeclado--;
                    break;
                } else if(botaoclicado.equals("C")){
                    campoEscolhido.setText(",00");
                    contQtdCliquesTeclado = 0;
                    break;
                }
                campoEscolhido.setText(digito1+"."+digito2+digito3+digito4+","+digito5+digito6);
                valorFinalVw = "R$ "+digito1+"."+digito2+digito3+digito4+","+digito5+digito6;
                break;

            case 7:
                digito7 = botaoclicado;
                if(botaoclicado.equals("A")){
                    campoEscolhido.setText(digito1+"."+digito2+digito3+digito4+","+digito5+digito6);
                    contQtdCliquesTeclado--;
                    break;
                } else if(botaoclicado.equals("C")){
                    campoEscolhido.setText(",00");
                    contQtdCliquesTeclado = 0;
                    break;
                }
                campoEscolhido.setText(digito1+digito2+"."+digito3+digito4+digito5+","+digito6+digito7);
                valorFinalVw = "R$ "+digito1+digito2+"."+digito3+digito4+digito5+","+digito6+digito7;
                break;

        }
    }

    public void tratarTeclado0(View v){
        botaoclicado = "0";
        contQtdCliquesTeclado++;
        mostrarNumTela(botaoclicado);

    }
    public void tratarTeclado1(View v){
        contQtdCliquesTeclado++;
        botaoclicado = "1";
        mostrarNumTela(botaoclicado);

    }

    public void tratarTeclado2(View v){
        contQtdCliquesTeclado++;
        botaoclicado = "2";
        mostrarNumTela(botaoclicado);

    }
    public void tratarTeclado3(View v){
        contQtdCliquesTeclado++;
        botaoclicado = "3";
        mostrarNumTela(botaoclicado);

    }
    public void tratarTeclado4(View v){
        contQtdCliquesTeclado++;
        botaoclicado = "4";
        mostrarNumTela(botaoclicado);


    }
    public void tratarTeclado5(View v){
        contQtdCliquesTeclado++;
        botaoclicado = "5";
        mostrarNumTela(botaoclicado);
    }
    public void tratarTeclado6(View v){
        contQtdCliquesTeclado++;
        botaoclicado = "6";
        mostrarNumTela(botaoclicado);
    }
    public void tratarTeclado7(View v){
        contQtdCliquesTeclado++;
        botaoclicado = "7";
        mostrarNumTela(botaoclicado);

    }
    public void tratarTeclado8(View v){
        contQtdCliquesTeclado++;
        botaoclicado = "8";
        mostrarNumTela(botaoclicado);

    }
    public void tratarTeclado9(View v){
        contQtdCliquesTeclado++;
        botaoclicado = "9";
        mostrarNumTela(botaoclicado);
    }
    public void tratarTecladoC(View v){
        botaoclicado = "C";
        mostrarNumTela(botaoclicado);
    }
    public void tratarTecladoApagar(View v){
        botaoclicado = "A";
        mostrarNumTela(botaoclicado);
    }

    public void armazenarFormaPagto(String s){
        Button i;
        formaPagtoSelecionada = Integer.parseInt(s);

        Button cartao = findViewById(R.id.btnCartaoVwLancamento);
        Button dinheiro = findViewById(R.id.btnDinheiroVwLancamento);
        Button transf = findViewById(R.id.btnTransVwLancamento);
        cartao.setBackgroundResource(R.drawable.cartao);
        dinheiro.setBackgroundResource(R.drawable.dinheiro);
        transf.setBackgroundResource(R.drawable.transfer);

        switch (formaPagtoSelecionada){
            case 1:
                i = findViewById(R.id.btnCartaoVwLancamento);
                i.setBackgroundResource(R.drawable.cartardestaque);
                formaPagtoEscolhida = formaPagtoSelecionada;

                break;
            case 2:
                i = findViewById(R.id.btnDinheiroVwLancamento);
                i.setBackgroundResource(R.drawable.dinheirodestaque);
                formaPagtoEscolhida = formaPagtoSelecionada;

                break;
            case 3:
                i = findViewById(R.id.btnTransVwLancamento);
                i.setBackgroundResource(R.drawable.transfdestaque);
                formaPagtoEscolhida = formaPagtoSelecionada;

                break;
        }
        formaPagtoSelecionada= 0;
    }

    public void setFormaPagtoCartao(View v){
        Button b = findViewById(R.id.btnCartaoVwLancamento);
        String s = b.getContentDescription().toString();
        formaPagtoFinalVw = "Cartão";
        System.out.println(formaPagtoFinalVw);
        armazenarFormaPagto(s);


    }
    public void setFormaPagtoDinheiro(View v){
        Button b = findViewById(R.id.btnDinheiroVwLancamento);
        String s = b.getContentDescription().toString();

        formaPagtoFinalVw = "Dinheiro";
        System.out.println(formaPagtoFinalVw);
        armazenarFormaPagto(s);

    }
    public void setFormaPagtoTransf(View v){
        Button b = findViewById(R.id.btnTransVwLancamento);
        String s = b.getContentDescription().toString();
        formaPagtoFinalVw = "Transferência";
        System.out.println(formaPagtoFinalVw);
        armazenarFormaPagto(s);

    }




}
