import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

/*
Crie uma aplicação que faça a gestão de transporte das plantações de azeitona até o lagar.
A configuração da aplicação é com base na leitura e interpretação do arquivo de regras.txt.

Durante o processo deve ir registrando no arquivo de relatório relatorio-1991.txt a seguinte informação:

24/02

09:24:56 - 0004 >> 4 toneladas de Galega na recepção 1 de origem da plantação 2 com tempo total de 8 segundos.
09:24:57 - 0012 >> 8 toneladas de Picual na recepção 2 de origem da plantação 5 com o tempo total de 6 segundos.
09:24:58 - 0018 >> 6 toneladas de Cordovil na recepção 1 de origem da plantação 3 com o tempo total de 6 segundos.

A sequência de números 0000 são a quantidade de toneladas acumuladas.
O tempo total de X segundos é o tempo des que o caminhão começa a ser carregado, incluíndo o tempo do percurso e o tempo de entrega.

A data a considerar não será a de 24/02/1991, mas sim a data de 28/04/2022.

Deve então considerar data correta de 28/04/2022 tanto no arquivo de regras como no arquivo de relatório. 

*/


public class App {
    public static void main(String[] args) throws Exception {

        List<String> numeros = new ArrayList<>();
        
        Pattern p = Pattern.compile("(\\d+).(\\d+)");
        Matcher m = p.matcher("string 123.489 more567string890");
        while(m.find()) {
            numeros.add(m.group());
        }

        for (String numero : numeros){
            System.out.println(numero);
        }


        

    }

    //(\\w*)\\d+(\\w*)
    // \t - tab
}
