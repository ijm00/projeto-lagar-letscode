package leituraEscrita;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStreamReader;


public class TesteLeitura {

    public static void main(String[] args) throws IOException {

        File arquivoDeEntrada = new File("arquivos-entrada\regras.txt");

        FileInputStream fis = new FileInputStream(arquivoDeEntrada);
        
        InputStreamReader isr = new InputStreamReader(fis);

        BufferedReader br = new BufferedReader(isr);

        String linha = br.readLine();
        
        while (linha != null) {
            System.out.println(linha);
            linha = br.readLine();
        }
        

        br.close();


    
    }

   
    
}
