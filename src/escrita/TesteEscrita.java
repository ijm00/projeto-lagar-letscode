package escrita;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public class TesteEscrita {
    public static void main(String[] args) throws IOException {

        File arquivoDeSaida = new File("arquivos-entrada/resultado.txt");

        OutputStream fos = new FileOutputStream(arquivoDeSaida);
        
        Writer osw = new OutputStreamWriter(fos);

        BufferedWriter bw = new BufferedWriter(osw);

        bw.write("teste");
        bw.newLine();
        bw.write("teste 2");
        

        bw.close();

        var path = Path.of("arquivos-entrada", "nio-Teste.txt");

        String texto = "bla bla bla";
        Files.write(path, texto.getBytes());



    
    }

   
}
