package escrita;
import java.io.FileWriter;
import java.io.IOException;

public class Testecopy {
    public static void main(String[] args) throws IOException {

        // File arquivoDeSaida = new File("arquivos-entrada/resultado.txt");
        // OutputStream fos = new FileOutputStream(arquivoDeSaida);
        // Writer osw = new OutputStreamWriter(fos);
        // BufferedWriter bw = new BufferedWriter(osw);
        
        FileWriter fw = new FileWriter("arquivos-entrada/resultado2.txt");
        fw.write("primeiro texte");
        fw.write(System.lineSeparator());
        fw.write("segundo teste");

       
        
        

        fw.close();


    
    }

   
}
