package leituraEscrita;

import java.io.File;
import java.util.Scanner;

public class TesteLeitura2 {

    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(new File("arquivos-entrada/regras.txt"));

        while (scanner.hasNextLine()){
            String linha = scanner.nextLine();
            System.out.println(linha);

            Scanner linhaScanner = new Scanner(linha);
            linhaScanner.useDelimiter(" ");
        
        
        }
        
        

        scanner.close();
    }
    
}
