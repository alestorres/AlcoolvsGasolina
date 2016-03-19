package com.torres.alexandre.alcoolvsgasolina;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String combustivelIdeal = " ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculaPreco(View view) {

        EditText valEtanol = (EditText) findViewById(R.id.valor_alcool);
        float valoretanol = Float.parseFloat(String.valueOf(valEtanol.getText()));

        EditText valGasolina = (EditText) findViewById(R.id.valor_gasolina);
        float valorGasolina = Float.parseFloat(String.valueOf(valGasolina.getText()));

        float proporcaoPreco = calculaProporcao(valoretanol, valorGasolina);

        if (proporcaoPreco > 0.7){
            combustivelIdeal = "GASOLINA";
        }else{
            combustivelIdeal = "ETANOL";
        }

        String resultMessage = createMessage(proporcaoPreco, combustivelIdeal);

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("mensagem",resultMessage);
        startActivity(intent);

       // ((EditText) findViewById(R.id.valor_alcool)).setText("");

    }

    private String createMessage(float valProporcao, String combustivel) {
        String resultMessage = "De acordo com os valores informados";
        resultMessage += "\n" + "o resultado da proporção foi de " + valProporcao + ", ";
        resultMessage += "\n" + "portanto voce deve abastecer com " + combustivel;
        resultMessage += "\n\n" + "Obrigado e boa sorte";
        return resultMessage;
    }
    private float calculaProporcao(float valorAlcool, float valorGasolina) {
        return (valorAlcool / valorGasolina);
    }
}
