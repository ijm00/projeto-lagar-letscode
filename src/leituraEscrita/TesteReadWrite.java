package leituraEscrita;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;


public class TesteReadWrite {

    public static void main(String[] args) throws IOException {

        File arquivoDeEntrada = new File("C:/Users/F8934921/OneDrive - Banco do Brasil S.A/Documentos/LetsCode/ProgWeb/projeto-lagar-letscode/arquivos-entrada/regras.txt");
        FileInputStream fis = new FileInputStream(arquivoDeEntrada);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        File arquivoDeSaida = new File("C:/Users/F8934921/OneDrive - Banco do Brasil S.A/Documentos/LetsCode/ProgWeb/projeto-lagar-letscode/arquivos-entrada/resultado.txt");
        OutputStream fos = new FileOutputStream(arquivoDeSaida);
        Writer osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);

        String linha = br.readLine();


        bw.write("Esse é o arquivo de saída.");
        bw.newLine();
        while (linha != null) {
            
            bw.write(linha);
            bw.newLine();
            bw.flush();
            linha = br.readLine();
        }
        

        br.close();
        bw.close();
        
    
    }

   
    
}
