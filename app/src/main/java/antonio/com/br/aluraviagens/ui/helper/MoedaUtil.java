package antonio.com.br.aluraviagens.ui.helper;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MoedaUtil {

    public static String FormataMoeda(BigDecimal valor) {
        NumberFormat formatoReal = DecimalFormat.getCurrencyInstance(new Locale("pt", "br"));
        String moedaBrasileira = formatoReal.format(valor).replace("R$","R$ ");
        return moedaBrasileira;
    }
}
