package regex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ProjetoLagarPatterns {

    private static List<Integer> variaveisExtraidas;
    
    private static Map<String, Pattern> variaveisPatterns = new HashMap<>() {{
        //TODO data
        put("variedadesPattern", Pattern.compile("^(\\d+)( Variedades de Azeitonas)$"));
        put("plantacoesPattern", Pattern.compile("(\\d+)( Plantações de Azeitonas)"));
        put("capacidadeRecepcaoLagarPattern", Pattern.compile("(\\d+)( Capacidades de Recepção)"));
        put("capacidadeCaminhoesPattern", Pattern.compile("(\\d+)( até )(\\d+)( toneladas de azeitonas)"));
        put("tempoCarregamentoCaminhaoPattern", Pattern.compile("(Cada plantação enche um caminhão entre )(2 a 8 segundos.)"));
        put("tempoProcessamentoCaminhaoPattern", Pattern.compile("(Cada recepção demora entre )(\\d+)( a )(\\d+)( segundos)"));
        put("tempoPorToneladaPattern", Pattern.compile("(\\d+)( segundos corresponde a )(\\d+)( toneladas)"));
        put("tamanhoMaximoFilaLagarPattern", Pattern.compile("(Quando atingir )(\\d+)( caminhões na filaregex)"));
        put("tamanhoFilaRecomecoProcessamentoPattern", Pattern.compile("(Quando o lagar voltar a atingir )(\\d+)( caminhões em espera)"));
        put("tempoMaximoExecucaoPattern", Pattern.compile("(Com )(\\d+)( minutos de execução geral)"));
    }}
    ;

    
    public static List<Integer> extrairVariaveisLagar (String texto) {
        variaveisPatterns.keySet().forEach(key -> {
            Matcher matcher = variaveisPatterns.get(key).matcher(texto);
            while(matcher.find()) {
                variaveisExtraidas.add(Integer.parseInt(matcher.group()));
            }
        });
        return variaveisExtraidas;
    }
                
}


   


