package leitura;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import regex.ProjetoLagarPatterns;

public class Leitura {

    public static void lerEExtrairVariaveis(VariaveisEntrada entrada) throws IOException {

        Path path = Paths.get("arquivos-entrada/regras.txt");
        Files.readAllLines(path).forEach(
                line -> ProjetoLagarPatterns.extrairVariaveisEntrada(line, entrada));

    }

}
