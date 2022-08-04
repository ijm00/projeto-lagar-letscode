package caminhoes;

import java.util.function.Supplier;

import leitura.VariaveisEntrada;

public class FornecedorCaminhoes {
    private static Supplier <Caminhao> fornecerCaminhao = () -> 
        new Caminhao(VariaveisEntrada.capacidadeMinimaCaminhao, VariaveisEntrada.capacidadeMaximaCaminhao, 
            (double) (VariaveisEntrada.pesoCorrespondenciaSegundos/VariaveisEntrada.tempoCorrespondenciaToneladas)); 

    public static Caminhao enviarCaminhao() {
        return fornecerCaminhao.get();
    }
    
}
