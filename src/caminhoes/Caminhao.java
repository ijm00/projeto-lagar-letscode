package caminhoes;

import java.time.LocalDateTime;
import java.util.Random;

import caminhoes.EstadosCaminhao.StatusCaminhao;
import caminhoes.relatorio.Relatorio;

public class Caminhao {
    private Integer capacidadeToneladas;
    private EstadosCaminhao estado;
    private Runnable descarregou;
    private long tempoProcessamentoMillis;
    private Relatorio relatorio;

    public Caminhao(int capacidadeMinima, int capacidadeMaxima, double fluxoCargaDescargaTonsPorSegundo) {
        this.capacidadeToneladas = new Random()
                .nextInt(capacidadeMaxima + 1 - capacidadeMinima) + capacidadeMinima;
        this.tempoProcessamentoMillis = Math
                .round(1000 * (this.capacidadeToneladas / fluxoCargaDescargaTonsPorSegundo));
        this.estado = new VazioEstado();
        this.relatorio = new Relatorio();
        this.relatorio.setCapacidadeCaminhao(this.capacidadeToneladas);
        this.relatorio.setInicioViagemCaminhao(LocalDateTime.now());
    }

    public Relatorio getRelatorio() {
        return relatorio;
    }

    public Integer getCapacidadeToneladas() {
        return capacidadeToneladas;
    }

    public long getTempoProcessamentoMillis() {
        return tempoProcessamentoMillis;
    }

    @Override
    public String toString() {
        return String.format("[Caminhao >> %d toneladas]", this.capacidadeToneladas);
    }

    public void transportarAzeitonas(int distanciaAteLagar) {
        if (this.getEstado() == StatusCaminhao.CARREGADO) {
            try {
                Thread.sleep(distanciaAteLagar * 1_000);
                this.avancaEstado();
                this.entrarNaFilaRecepcao();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

    private void entrarNaFilaRecepcao() {
        if (this.getEstado() == StatusCaminhao.TRANSPORTADO) {
            this.avancaEstado();

            FilaDeCaminhoes.getInstance().adicionar(this);
        }
    }

    public void descarrega() {
        avancaEstado();
        descarregou.run();
    }

    public void quandoDescarregou(Runnable descarregou) {
        this.descarregou = descarregou;
    }

    public void avancaEstado() {
        estado.proximo(this);
    }

    protected void setEstado(EstadosCaminhao estado) {
        this.estado = estado;
    }

    public StatusCaminhao getEstado() {
        return estado.getStatus();
    }
}
