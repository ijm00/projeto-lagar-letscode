package plantacoes;

import java.util.HashSet;
import java.util.Set;

public class Azeitonas {
    private Set<String> variedadesDeAzeitonas = new HashSet<>();
    
    public Set<String> getVariedadesDeAzeitonas() {
        return variedadesDeAzeitonas;
    }

    public void adicionarVariedadeDeAzeitona(String azeitona) {
        this.variedadesDeAzeitonas.add(azeitona);
    }
}
