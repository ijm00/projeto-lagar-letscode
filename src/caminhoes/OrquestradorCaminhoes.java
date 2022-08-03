package caminhoes;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import plantacoes.Plantacao;

public class OrquestradorCaminhoes {
    
    public static void encaminharParaLagar(Plantacao origem, Caminhao caminhao) {
        ExecutorService taskTransportar = Executors.newFixedThreadPool(1);
        taskTransportar.submit(() -> caminhao.transportarAzeitonas(origem.getDistanciaAteLagar()));
        taskTransportar.shutdown();
    }
    
}
