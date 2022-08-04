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
                for (int i = 0; i < VariaveisEntrada.plantacoesGalega; i++){
                    add(new Plantacao(azeitonaGalega, VariaveisEntrada.distanciaGalegaLagar));
                }
                for (int i = 0; i < VariaveisEntrada.plantacoesCordovil; i++){
                    add(new Plantacao(azeitonaCordovil, VariaveisEntrada.distanciaCordovilLagar));
                }
                for (int i = 0; i < VariaveisEntrada.plantacoesPicual; i++){
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
