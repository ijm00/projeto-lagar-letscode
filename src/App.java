import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import caminhoes.Caminhao;
import caminhoes.FilaDeCaminhoes;
import lagares.Lagar;
import lagares.RecepcaoLagar;
import leitura.Leitura;
import leitura.VariaveisEntrada;
import plantacoes.Azeitona;
import plantacoes.Plantacao;

public class App {

    public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
        VariaveisEntrada entrada = new VariaveisEntrada();
        try {
            Leitura.lerEExtrairVariaveis(entrada);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        ConcurrentLinkedQueue<Caminhao> fila = FilaDeCaminhoes.getInstance().getFila();

        Azeitona azeitonaGalega = new Azeitona("Galega");
        Azeitona azeitonaCordovil = new Azeitona("Cordovil");
        Azeitona azeitonaPicual = new Azeitona("Picual");

        Lagar lagar = new Lagar(VariaveisEntrada.capacidadeRecepcaoLagarPattern);
        RecepcaoLagar recepcao = new RecepcaoLagar();

        List<Plantacao> plantacoes = new ArrayList<>() {
            {
                for (int i = 0; i < VariaveisEntrada.plantacoesGalega; i++) {
                    add(new Plantacao(azeitonaGalega, VariaveisEntrada.distanciaGalegaLagar));
                }
                for (int i = 0; i < VariaveisEntrada.plantacoesCordovil; i++) {
                    add(new Plantacao(azeitonaCordovil, VariaveisEntrada.distanciaCordovilLagar));
                }
                for (int i = 0; i < VariaveisEntrada.plantacoesPicual; i++) {
                    add(new Plantacao(azeitonaPicual, VariaveisEntrada.distanciaPicualLagar));
                }
            }
        };

        final var inicioOperacao = LocalDateTime.now();

        System.out.println("Iniciando execução...");

        ExecutorService descarregarCaminhoes = Executors.newFixedThreadPool(lagar.getNumeroPortasRecepcao());
        while (LocalDateTime.now().isBefore(inicioOperacao.plusMinutes(VariaveisEntrada.tempoMaximoExecucao))) {
            for (Plantacao plantacao : plantacoes) {
                plantacao.produzir();
            }
            descarregarCaminhoes.execute(recepcao.descarregarCaminhoesTask());
        }
        descarregarCaminhoes.shutdown();

        ExecutorService descarregarRestantes = Executors.newFixedThreadPool(lagar.getNumeroPortasRecepcao());
        try {
            while (true) {
                if (descarregarCaminhoes.awaitTermination(15, TimeUnit.SECONDS)) {
                    while (!fila.isEmpty()) {
                        descarregarRestantes.execute(recepcao.descarregarCaminhoesTask());
                    }
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            descarregarRestantes.shutdown();
        }

        RecepcaoLagar.escreveRelatorio();
    }

}
