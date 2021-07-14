package antonio.com.br.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import antonio.com.br.aluraviagens.R;

public class ResumoDoPacoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_do_pacote);
        setTitle("Resumo do Pacote");
    }
}