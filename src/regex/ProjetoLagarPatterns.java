package regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ProjetoLagarPatterns {

    private static List<Integer> variaveisExtraidas;
    
    private static List<Pattern> variaveisPatterns = new ArrayList<>() {{
        add(Pattern.compile("(\\d+)( Variedades de Azeitonas)"));
        add(Pattern.compile("(\\d+)( Plantações de Azeitonas)"));
        add(Pattern.compile("(\\d+)( Capacidades de Recepção)"));
        add(Pattern.compile("(\\d+)( até )(\\d+)( toneladas de azeitonas)"));
        add(Pattern.compile("(Cada plantação enche um caminhão entre )(2 a 8 segundos.)"));
        add(Pattern.compile("(Cada recepção demora entre )(\\d+)( a )(\\d+)( segundos)"));
        add(Pattern.compile("(\\d+)( segundos corresponde a )(\\d+)( toneladas)"));
        add(Pattern.compile("(Quando atingir )(\\d+)( caminhões na filaregex)"));
        add(Pattern.compile("(Quando o lagar voltar a atingir )(\\d+)( caminhões em espera)"));
        add(Pattern.compile("(Com )(\\d+)( minutos de execução geral)"));
    }}
    ;

    //TODO data
    Pattern variedadesPattern = Pattern.compile("(\\d+)( Variedades de Azeitonas)");
    Pattern plantacoesPattern = Pattern.compile("(\\d+)( Plantações de Azeitonas)");
    Pattern capacidadeRecepcaoLagarPattern = Pattern.compile("(\\d+)( Capacidades de Recepção)");
    Pattern capacidadeCaminhoesPattern = Pattern.compile("(\\d+)( até )(\\d+)( toneladas de azeitonas)");
    Pattern tempoCarregamentoCaminhaoPattern = Pattern.compile("(Cada plantação enche um caminhão entre )(2 a 8 segundos.)");
    Pattern tempoProcessamentoCaminhaoPattern = Pattern.compile("(Cada recepção demora entre )(\\d+)( a )(\\d+)( segundos)");
    Pattern tempoPorToneladaPattern = Pattern.compile("(\\d+)( segundos corresponde a )(\\d+)( toneladas)");
    Pattern tamanhoMaximoFilaLagarPattern = Pattern.compile("(Quando atingir )(\\d+)( caminhões na filaregex)");
    Pattern tamanhoFilaRecomecoProcessamentoPattern = Pattern.compile("(Quando o lagar voltar a atingir )(\\d+)( caminhões em espera)");
    Pattern tempoMaximoExecucaoPattern = Pattern.compile("(Com )(\\d+)( minutos de execução geral)");

    public static List<Integer> extrairVariaveisLagar (String texto) {
        for (Pattern pattern : variaveisPatterns) {
            Matcher m = pattern.matcher(texto);
            while(m.find()) {
                variaveisExtraidas.add(Integer.parseInt(m.group()));
            }
        }
        return variaveisExtraidas;        
    }
}

