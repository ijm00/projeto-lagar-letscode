import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ExtrairNumeros {
    
    private List<Integer> numerosInt;
    private List<Double> numerosDouble;

    public List<Integer> ExtrairNumerosInt (String texto) {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(texto);
        while(m.find()) {
            numerosInt.add(Integer.parseInt(m.group()));
        }
        return numerosInt;
    }

    public List<Double> ExtrairNumerosDouble (String texto) {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(texto);
        while(m.find()) {
            numerosDouble.add(Double.parseDouble(m.group()));
        }
        return numerosDouble;
    }
}
