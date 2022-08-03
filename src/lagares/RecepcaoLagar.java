package lagares;

import java.time.LocalDateTime;

import caminhoes.Caminhao;
import caminhoes.FilaDeCaminhoes;
import caminhoes.relatorio.Relatorio;

public class RecepcaoLagar {
   public Runnable descarregarCaminhoesTask() {
        return () -> {
            this.descarregarCaminhoes();
        };
    }

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
                    System.out.println(caminhao.getRelatorio().toString());
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}
