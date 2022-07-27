package regex;

import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ProjetoLagarPatterns {
    
    private List<Integer> numerosInt;
    private List<Double> numerosDouble;

    //TODO data
    Pattern variedadesPattner = Pattern.compile("(\\d+).( Variedades de Azeitonas)");
    Pattern plantacoesPattern = Pattern.compile("(\\d+).( Plantações de Azeitonas)");
    Pattern capacidadeRecepcaoLagarPattern = Pattern.compile("(\\d+).( Capacidades de Recepção)");
    Pattern capacidadeCaminhoesPattern = Pattern.compile("(\\d+).( até ).(\\d+).( toneladas de azeitonas)");
    Pattern tempoCarregamentoCaminhaoPattern = Pattern.compile("(Cada plantação enche um caminhão entre )2 a 8 segundos.");
    Pattern tempoProcessamentoCaminhaoPattern = Pattern.compile("(\\d+).( até ).(\\d+).( toneladas de azeitonas)");
   

    public List<Integer> ExtrairNumerosInt (String texto) {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(texto);
        while(m.find()) {
            numerosInt.add(Integer.parseInt(m.group()));
        }
        return numerosInt;
    }

    public List<Double> ExtrairNumerosDouble (String texto) {
        Pattern p = Pattern.compile("(\\d+).(\\d+)");
        Matcher m = p.matcher(texto);
        while(m.find()) {
            numerosDouble.add(Double.parseDouble(m.group()));
        }
        return numerosDouble;
    }
}
