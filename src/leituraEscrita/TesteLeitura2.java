package leituraEscrita;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class TesteLeitura2 {

    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(new File("C:/Users/F8934921/OneDrive - Banco do Brasil S.A/Documentos/LetsCode/ProgWeb/projeto-lagar-letscode/arquivos-entrada/regras.txt"));

        while (scanner.hasNextLine()){
            String linha = scanner.nextLine();
            System.out.println(linha);

            Scanner linhaScanner = new Scanner(linha);
            linhaScanner.useDelimiter(" ");
        
        
        }
        
        

        scanner.close();
    }
    
}
