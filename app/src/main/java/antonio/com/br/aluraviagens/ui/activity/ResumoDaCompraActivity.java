package antonio.com.br.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.math.BigDecimal;

import antonio.com.br.aluraviagens.R;
import antonio.com.br.aluraviagens.ui.helper.DataUtil;
import antonio.com.br.aluraviagens.ui.helper.MoedaUtil;
import antonio.com.br.aluraviagens.ui.helper.ResourcesUtil;
import antonio.com.br.aluraviagens.ui.model.Pacote;

import static antonio.com.br.aluraviagens.ui.activity.constantes.CHAVE_PACOTE;

public class ResumoDaCompraActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo da compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_da_compra);
        setTitle(TITULO_APPBAR);
        carregaPacoteRecebido();

    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if(intent.hasExtra(CHAVE_PACOTE)){
            Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);
            inicializaCampos(pacote);
        }
    }

    private void inicializaCampos(Pacote pacote) {
        insereLocalDoPacote(pacote);
        mostraPreco(pacote);
        InsereDataIdaDataVoltaPacote(pacote);
        insereImagemDoPacote(pacote);
    }

    private void insereLocalDoPacote(Pacote pacote) {
        TextView cidade = findViewById(R.id.resumo_da_compra_cidade);
        cidade.setText(pacote.getLocal());
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_compra_preco);
        String moeda = MoedaUtil.FormataMoeda(pacote.getPreco());
        preco.setText(moeda);
    }

    private void InsereDataIdaDataVoltaPacote(Pacote pacote) {
        TextView data = findViewById(R.id.resumo_compra_data);
        String dataFormatadaViagem = DataUtil.periodoEmTexto(pacote.getDias());
        data.setText(dataFormatadaViagem);
    }

    private void insereImagemDoPacote(Pacote pacote) {
        ImageView cidadeImagem = findViewById(R.id.resumo_da_compra_imagem);
        Drawable drawableDoPacote = ResourcesUtil.devolveDrawable(this, pacote.getImagem());
        cidadeImagem.setImageDrawable(drawableDoPacote);
    }
}