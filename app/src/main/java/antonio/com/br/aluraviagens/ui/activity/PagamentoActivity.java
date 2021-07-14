package antonio.com.br.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.math.BigDecimal;

import antonio.com.br.aluraviagens.R;
import antonio.com.br.aluraviagens.ui.helper.MoedaUtil;
import antonio.com.br.aluraviagens.ui.model.Pacote;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        setTitle(TITULO_APPBAR);

        Pacote pacoteFoz = new Pacote("Foz do Iguaçu", "foz_do_iguacu_pr", 1, new BigDecimal(243.99));

        mostraPreco(pacoteFoz);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.pagamento_activity_preco);
        String moeda = MoedaUtil.FormataMoeda(pacote.getPreco());
        preco.setText(moeda);
    }
    public void abreResumoDaCompra(View v){
        startActivity(new Intent(this,ResumoDaCompraActivity.class));
    }
}