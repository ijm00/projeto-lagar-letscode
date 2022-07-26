package lagares;

import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicReference;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import caminhoes.Caminhao;
import caminhoes.FilaDeCaminhoes;
import caminhoes.relatorio.Relatorio;
import leitura.VariaveisEntrada;

public class RecepcaoLagar {
    public Runnable descarregarCaminhoesTask() {
        return () -> {
            this.descarregarCaminhoes();
        };
    }

    private static AtomicReference<String> relatorioLog = new AtomicReference<>(
            VariaveisEntrada.dataEntrada + "\n\n");

    public void descarregarCaminhoes() {
        Caminhao caminhao = FilaDeCaminhoes.getInstance().getFila().poll();
        if (caminhao != null) {
            try {
                Thread.sleep(caminhao.getTempoProcessamentoMillis());
                caminhao.avancaEstado();
                caminhao.getRelatorio().setCodigoRecepcao(
                        Thread.currentThread().getName().substring(Thread.currentThread().getName().length() - 1));
                caminhao.getRelatorio().setFimViagemCaminhao(LocalDateTime.now());

                synchronized (this) {
                    Relatorio.incrementarToneladasProcessadas(caminhao.getCapacidadeToneladas());
                    relatorioLog.set(relatorioLog.get() + caminhao.getRelatorio().toString() + "\n");
                    System.out.println(caminhao.getRelatorio().toString());
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void escreveRelatorio() throws IOException {

        BufferedWriter writer = Files.newBufferedWriter(Path.of("src\\relatorioFinal.txt"));
        writer.write("");
        writer.flush();
        Files.writeString(Path.of("src\\relatorioFinal.txt"), relatorioLog.get(), StandardOpenOption.CREATE);
    }

}
