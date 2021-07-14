package antonio.com.br.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.math.BigDecimal;

import antonio.com.br.aluraviagens.R;
import antonio.com.br.aluraviagens.ui.helper.MoedaUtil;
import antonio.com.br.aluraviagens.ui.model.Pacote;

import static antonio.com.br.aluraviagens.ui.activity.constantes.CHAVE_PACOTE;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pagamento";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        setTitle(TITULO_APPBAR);

        carregaPacoteRecebido();


    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if(intent.hasExtra(CHAVE_PACOTE)){
            final Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);
            mostraPreco(pacote);

            configuraBotao(pacote);
        }
    }

    private void configuraBotao(Pacote pacote) {
        Button pagamento = findViewById(R.id.pagamento_botao_pagamento);
        pagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vaiParaResumoCompraActivity(pacote);
            }
        });
    }

    private void vaiParaResumoCompraActivity(Pacote pacote) {
        Intent intent = new Intent(PagamentoActivity.this, ResumoDaCompraActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.pagamento_activity_preco);
        String moeda = MoedaUtil.FormataMoeda(pacote.getPreco());
        preco.setText(moeda);
    }

}