package antonio.com.br.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import antonio.com.br.aluraviagens.R;
import antonio.com.br.aluraviagens.ui.helper.DataUtil;
import antonio.com.br.aluraviagens.ui.helper.FormataDiasUtil;
import antonio.com.br.aluraviagens.ui.helper.MoedaUtil;
import antonio.com.br.aluraviagens.ui.helper.ResourcesUtil;
import antonio.com.br.aluraviagens.ui.model.Pacote;

public class ResumoDoPacoteActivity extends AppCompatActivity {
    public static final String TITULO_APPBAR = "Resumo do Pacote";
    private TextView cidade,dias,preco,data;
    private ImageView cidadeImagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_do_pacote);
        setTitle(TITULO_APPBAR);
        inicializacomponentes();
        Pacote pacoteFoz = new Pacote("Foz do Iguaçu", "foz_do_iguacu_pr", 1, new BigDecimal(243.99));

        insereLocalDoPacote(pacoteFoz);
        insereDiasPacote(pacoteFoz);
        insereValorDoPacote(MoedaUtil.FormataMoeda(pacoteFoz.getPreco()), preco);
        insereImagemDoPacote(pacoteFoz);
        InsereDataIdaDataVoltaPacote(pacoteFoz);


    }

    private void insereDiasPacote(Pacote pacote) {
        String diasEmtexto = FormataDiasUtil.formataEmtexto(pacote.getDias());
        dias.setText(diasEmtexto);
    }

    private void insereLocalDoPacote(Pacote pacote) {
        cidade.setText(pacote.getLocal());
    }

    private void insereValorDoPacote(String s, TextView preco) {
        String moeda = s;
        preco.setText(moeda);
    }

    private void insereImagemDoPacote(Pacote pacote) {
        Drawable drawableDoPacote = ResourcesUtil.devolveDrawable(this, pacote.getImagem());
        cidadeImagem.setImageDrawable(drawableDoPacote);
    }

    private void InsereDataIdaDataVoltaPacote(Pacote pacote) {
        String dataFormatadaViagem = DataUtil.periodoEmTexto(pacote.getDias());
        data.setText(dataFormatadaViagem);
    }

    private void inicializacomponentes() {
        cidade= findViewById(R.id.textCidade);
        dias= findViewById(R.id.textDias);
        preco= findViewById(R.id.textPreco);
        data= findViewById(R.id.textTempoViagem);
        cidadeImagem = findViewById(R.id.imagePacote);
    }

    public void vaiParaPagamento(View view){
        startActivity(new Intent(ResumoDoPacoteActivity.this, PagamentoActivity.class));
    }
}