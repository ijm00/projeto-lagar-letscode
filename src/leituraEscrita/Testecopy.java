package leituraEscrita;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class Testecopy {
    public static void main(String[] args) throws IOException {

        // File arquivoDeSaida = new File("C:/Users/F8934921/OneDrive - Banco do Brasil S.A/Documentos/LetsCode/ProgWeb/projeto-lagar-letscode/arquivos-entrada/resultado.txt");
        // OutputStream fos = new FileOutputStream(arquivoDeSaida);
        // Writer osw = new OutputStreamWriter(fos);
        // BufferedWriter bw = new BufferedWriter(osw);
        
        FileWriter fw = new FileWriter("C:/Users/F8934921/OneDrive - Banco do Brasil S.A/Documentos/LetsCode/ProgWeb/projeto-lagar-letscode/arquivos-entrada/resultado2.txt");
        fw.write("primeiro texte");
        fw.write(System.lineSeparator());
        fw.write("segundo teste");

       
        
        

        fw.close();


    
    }

   
}
