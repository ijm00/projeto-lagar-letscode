package caminhoes;

import java.util.function.Supplier;

public class FornecedorCaminhoes {
    private static Supplier <Caminhao> fornecerCaminhao = () -> 
        new Caminhao(4, 16, 2); 

    public static Caminhao enviarCaminhao() {
        return fornecerCaminhao.get();
    }
    
}
