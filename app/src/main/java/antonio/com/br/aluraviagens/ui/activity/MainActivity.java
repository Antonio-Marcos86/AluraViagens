package antonio.com.br.aluraviagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;
import antonio.com.br.aluraviagens.R;
import antonio.com.br.aluraviagens.ui.adapter.ListaPacoteAdapter;
import antonio.com.br.aluraviagens.ui.dao.PacoteDAO;
import antonio.com.br.aluraviagens.ui.model.Pacote;

import static antonio.com.br.aluraviagens.ui.activity.constantes.CHAVE_PACOTE;

public class MainActivity extends AppCompatActivity {

    private ListView listaDePacotes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //titulo na appBar
        setTitle(getString(R.string.pacotes));
        listaDePacotes= findViewById(R.id.activity_main_listView);
        configuraLista();

    }

    private void configuraLista() {
        List<Pacote> pacotes = new PacoteDAO().lista();
        listaDePacotes.setAdapter(new ListaPacoteAdapter(pacotes,this));
        listaDePacotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pacote pacoteClicado = pacotes.get(position);
                vaiParaResumoPacote(pacoteClicado);
            }
        });
    }

    private void vaiParaResumoPacote(Pacote pacoteClicado) {
        Intent intent = new Intent(MainActivity.this,ResumoDoPacoteActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacoteClicado);
        startActivity(intent);
    }
}