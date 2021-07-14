package antonio.com.br.aluraviagens.ui.helper;

public class FormataDiasUtil {

    public static String formataEmtexto(int quantidadesDeDias) {

        if(quantidadesDeDias >1){
            return quantidadesDeDias + " dias";
        }
            return  quantidadesDeDias + " dia";

    }
}
