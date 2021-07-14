package antonio.com.br.aluraviagens.ui.activity;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;
import antonio.com.br.aluraviagens.R;
import antonio.com.br.aluraviagens.ui.adapter.ListaPacoteAdapter;
import antonio.com.br.aluraviagens.ui.dao.PacoteDAO;
import antonio.com.br.aluraviagens.ui.model.Pacote;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //titulo na appBar
        setTitle(getString(R.string.pacotes));

        configuraLista();
    }

    private void configuraLista() {
        ListView listaDePacotes = findViewById(R.id.activity_main_listView);
        List<Pacote> pacotes = new PacoteDAO().lista();
        listaDePacotes.setAdapter(new ListaPacoteAdapter(pacotes,this));
    }
}