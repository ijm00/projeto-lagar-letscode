package regex;

import java.util.regex.Pattern;
import leitura.VariaveisEntrada;

import java.util.regex.Matcher;

public class ProjetoLagarPatterns {

    public static void extrairVariaveisEntrada(String texto, VariaveisEntrada entrada) {
        extractDataEntrada(texto, entrada);
        extractVariedadesAzeitonas(texto, entrada);
        extractPlantacoesAzeitonas(texto, entrada);
        extractGalega(texto, entrada);
        extractCordovil(texto, entrada);
        extractPicual(texto, entrada);
        extractCapacidadeRecepcao(texto, entrada);
        extractCapacidadeCaminhoes(texto, entrada);
        extractTempoCarregamentoCaminhoes(texto, entrada);
        extractTempoProcessamentoCaminhoes(texto, entrada);
        extractTempoPorTonelada(texto, entrada);
        extractTamanhoMaximoFila(texto, entrada);
        extractTamanhoFilaReprocessamento(texto, entrada);
        extractTempoMaximoExecucao(texto, entrada);

    }

    private static void extractVariedadesAzeitonas(String texto, VariaveisEntrada entrada) {
        Pattern variedadesPattern = Pattern.compile("(\\d+)( Variedades de Azeitonas)");
        Matcher matcher = variedadesPattern.matcher(texto);
        while (matcher.find()) {
            entrada.setVariedadesAzeitonas(Integer.parseInt(matcher.group(1)));
        }
    }

    private static void extractPlantacoesAzeitonas(String texto, VariaveisEntrada entrada) {
        Pattern plantacoesPattern = Pattern.compile("(\\d+)( Plantações de Azeitonas)");
        Matcher matcher = plantacoesPattern.matcher(texto);
        while (matcher.find()) {
            entrada.setPlantacoesAzeitonas(Integer.parseInt(matcher.group(1)));
        }
    }

    private static void extractGalega(String texto, VariaveisEntrada entrada) {
        Pattern galegaPattern = Pattern
                .compile("(\\d+)( plantações de Galega com a distância de )(\\d+)( segundos para o lagar.)");
        Matcher matcher = galegaPattern.matcher(texto);
        while (matcher.find()) {
            entrada.setPlantacoesGalega(Integer.parseInt(matcher.group(1)));
            entrada.setDistanciaGalegaLagar(Integer.parseInt(matcher.group(3)));
        }
    }

    private static void extractCordovil(String texto, VariaveisEntrada entrada) {
        Pattern cordovilPattern = Pattern
                .compile("(\\d+)( plantações de Cordovil com a distância de )(\\d+)( segundos para o lagar.)");
        Matcher matcher = cordovilPattern.matcher(texto);
        while (matcher.find()) {
            entrada.setPlantacoesCordovil(Integer.parseInt(matcher.group(1)));
            entrada.setDistanciaCordovilLagar(Integer.parseInt(matcher.group(3)));
        }
    }

    private static void extractPicual(String texto, VariaveisEntrada entrada) {
        Pattern picualPattern = Pattern
                .compile("(\\d+)( plantação de Picual com a distância de )(\\d+)( segundos para o lagar.)");
        Matcher matcher = picualPattern.matcher(texto);
        while (matcher.find()) {
            entrada.setPlantacoesPicual(Integer.parseInt(matcher.group(1)));
            entrada.setDistanciaPicualLagar(Integer.parseInt(matcher.group(3)));
        }
    }

    private static void extractCapacidadeRecepcao(String texto, VariaveisEntrada entrada) {
        Pattern capacidadeRecepcaoLagarPattern = Pattern.compile("(\\d+)( Capacidades de Recepção)");
        Matcher matcher = capacidadeRecepcaoLagarPattern.matcher(texto);
        while (matcher.find()) {
            entrada.setCapacidadeRecepcaoLagarPattern((Integer.parseInt(matcher.group(1))));
        }
    }

    private static void extractCapacidadeCaminhoes(String texto, VariaveisEntrada entrada) {
        Pattern capacidadeCaminhoesPattern = Pattern.compile("(\\d+)( até )(\\d+)( toneladas de azeitonas)");
        Matcher matcher = capacidadeCaminhoesPattern.matcher(texto);
        while (matcher.find()) {
            entrada.setCapacidadeMinimaCaminhao(Integer.parseInt(matcher.group(1)));
            entrada.setCapacidadeMaximaCaminhao(Integer.parseInt(matcher.group(3)));
        }
    }

    private static void extractTempoCarregamentoCaminhoes(String texto, VariaveisEntrada entrada) {
        Pattern tempoCarregamentoCaminhaoPattern = Pattern
                .compile("(Cada plantação enche um caminhão entre )(\\d+)( a )(\\d+)( segundos.)");
        Matcher matcher = tempoCarregamentoCaminhaoPattern.matcher(texto);
        while (matcher.find()) {
            entrada.setTempoMinimoCarregamentoCaminhao(Integer.parseInt(matcher.group(2)));
            entrada.setTempoMaximoCarregamentoCaminhao(Integer.parseInt(matcher.group(4)));
        }
    }

    private static void extractTempoProcessamentoCaminhoes(String texto,
            VariaveisEntrada entrada) {
        Pattern tempoProcessamentoCaminhaoPattern = Pattern
                .compile("(Cada recepção demora entre )(\\d+)( a )(\\d+)( segundos)");
        Matcher matcher = tempoProcessamentoCaminhaoPattern.matcher(texto);
        while (matcher.find()) {
            entrada.setTempoMinimoProcessamentoCaminhao(Integer.parseInt(matcher.group(2)));
            entrada.setTempoMaximoProcessamentoCaminhao(Integer.parseInt(matcher.group(4)));
        }
    }

    private static void extractTempoPorTonelada(String texto,
            VariaveisEntrada entrada) {

        Pattern tempoPorToneladaPattern = Pattern.compile("(\\d+)( segundos corresponde a )(\\d+)( toneladas)");
        Matcher matcher = tempoPorToneladaPattern.matcher(texto);
        while (matcher.find()) {
            entrada.setTempoCorrespondenciaToneladas(Integer.parseInt(matcher.group(1)));
            entrada.setPesoCorrespondenciaSegundos(Integer.parseInt(matcher.group(3)));
        }
    }

    private static void extractTamanhoMaximoFila(String texto, VariaveisEntrada entrada) {
        Pattern tamanhoMaximoFilaLagarPattern = Pattern.compile("(Quando atingir )(\\d+)( caminhões na fila)");
        Matcher matcher = tamanhoMaximoFilaLagarPattern.matcher(texto);
        while (matcher.find()) {
            entrada.setTamanhoMaximoFilaLagar(Integer.parseInt(matcher.group(2)));
        }
    }

    private static void extractTamanhoFilaReprocessamento(String texto, VariaveisEntrada entrada) {
        Pattern tamanhoFilaRecomecoProcessamentoPattern = Pattern
                .compile("(Quando o lagar voltar a atingir )(\\d+)( caminhões em espera)");
        Matcher matcher = tamanhoFilaRecomecoProcessamentoPattern.matcher(texto);
        while (matcher.find()) {
            entrada.setTamanhoFilaRecomecoProcessamento(Integer.parseInt(matcher.group(2)));
        }
    }

    private static void extractTempoMaximoExecucao(String texto, VariaveisEntrada entrada) {
        Pattern tempoMaximoExecucaoPattern = Pattern.compile("(Com )(\\d+)( minutos de execução geral)");
        Matcher matcher = tempoMaximoExecucaoPattern.matcher(texto);
        while (matcher.find()) {
            entrada.setTempoMaximoExecucao(Integer.parseInt(matcher.group(2)));
        }
    }

    private static void extractDataEntrada(String texto, VariaveisEntrada entrada) {
        Pattern dataEntradaPattern = Pattern.compile("(\\d+/\\d+)/(\\d+)");
        Matcher matcher = dataEntradaPattern.matcher(texto);
        while (matcher.find()) {
            VariaveisEntrada.setDataEntrada(matcher.group(1));
        }

    }

}
