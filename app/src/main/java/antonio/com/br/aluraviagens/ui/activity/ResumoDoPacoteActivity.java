package antonio.com.br.aluraviagens.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import antonio.com.br.aluraviagens.R;
import antonio.com.br.aluraviagens.ui.helper.DataUtil;
import antonio.com.br.aluraviagens.ui.helper.FormataDiasUtil;
import antonio.com.br.aluraviagens.ui.helper.MoedaUtil;
import antonio.com.br.aluraviagens.ui.helper.ResourcesUtil;
import antonio.com.br.aluraviagens.ui.model.Pacote;

import static antonio.com.br.aluraviagens.ui.activity.constantes.CHAVE_PACOTE;

public class ResumoDoPacoteActivity extends AppCompatActivity {
    public static final String TITULO_APPBAR = "Resumo do Pacote";
    private TextView cidade,dias,preco,data;
    private ImageView cidadeImagem;
    private Button pagamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_do_pacote);
        setTitle(TITULO_APPBAR);
        inicializacomponentes();
        carregaPacoteRecebido();

    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if(intent.hasExtra(CHAVE_PACOTE)){
            final Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);
            inicializaCampos(pacote);

            configuraBotao(pacote);
        }
    }

    private void configuraBotao(Pacote pacote) {
        pagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vaiParaPagamentoActivity(pacote);
            }
        });
    }

    private void inicializaCampos(Pacote pacote) {
        mostraLocal(pacote);
        mostraDias(pacote);
        mostraPreco(MoedaUtil.FormataMoeda(pacote.getPreco()), preco);
        mostraImagem(pacote);
        mostraData(pacote);
    }

    private void vaiParaPagamentoActivity(Pacote pacote) {
        Intent intent = new Intent(ResumoDoPacoteActivity.this, PagamentoActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }

    private void mostraDias(Pacote pacote) {
        String diasEmtexto = FormataDiasUtil.formataEmtexto(pacote.getDias());
        dias.setText(diasEmtexto);
    }

    private void mostraLocal(Pacote pacote) {
        cidade.setText(pacote.getLocal());
    }

    private void mostraPreco(String s, TextView preco) {
        String moeda = s;
        preco.setText(moeda);
    }

    private void mostraImagem(Pacote pacote) {
        Drawable drawableDoPacote = ResourcesUtil.devolveDrawable(this, pacote.getImagem());
        cidadeImagem.setImageDrawable(drawableDoPacote);
    }

    private void mostraData(Pacote pacote) {
        String dataFormatadaViagem = DataUtil.periodoEmTexto(pacote.getDias());
        data.setText(dataFormatadaViagem);
    }

    private void inicializacomponentes() {
        cidade= findViewById(R.id.textCidade);
        dias= findViewById(R.id.textDias);
        preco= findViewById(R.id.textPreco);
        data= findViewById(R.id.textTempoViagem);
        cidadeImagem = findViewById(R.id.imagePacote);
        pagamento = findViewById(R.id.resumo_pcote_botao_pagamento);
    }


}