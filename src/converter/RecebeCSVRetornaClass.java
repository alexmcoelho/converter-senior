package converter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class RecebeCSVRetornaClass {

    private List<String> g7 = new ArrayList<>();
    private List<String> g5 = new ArrayList<>();

    public RecebeCSVRetornaClass(String nameList) {

        // abre um arquivo e cria um file
        File arquivoCSV = new File("integra.csv");

        String[] valoresEntreVirgulas = null;

        // cria um scanner para ler o arquivo
        Scanner leitor = null;

        //String que será salvo no converter.txt
        StringBuilder builder = new StringBuilder();

        // variável que armazenará as linhas do arquivo
        String linhasDoArquivo = new String();

        //escreve no arquivo
        FileWriter arquivo;

        try {
            leitor = new Scanner(arquivoCSV);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // ignora a primeira linha do arquivo
        leitor.nextLine();

        // percorre todo o arquivo
        while (leitor.hasNext()) {

            // recebe cada linha do arquivo
            linhasDoArquivo = leitor.nextLine();

            // separa os campos entre as virgulas de cada linha
            valoresEntreVirgulas = linhasDoArquivo.split(";");

            g7.add(valoresEntreVirgulas[0]);
            g5.add(valoresEntreVirgulas[1]);
        }

        //criando class
        builder.append("import java.util.ArrayList;\r\n")
                .append("import java.util.List; \r\n\r\n")
                .append("public class " + nameList + "{ \r\n\r\n")
                .append("    private List<String> g7 = new ArrayList<>();\r\n")
                .append("    private List<String> g5 = new ArrayList<>();\r\n\r\n")
                .append("    public " + nameList + "(){ \r\n");

        for (String string : g7) {
            builder.append("        g7.add(" + "\"" + string + "\");\r\n");
        }
        for (String string : g5) {
            builder.append("        g5.add(" + "\"" + string + "\");\r\n");
        }

        builder.append("    } \r\n\r\n")
                .append("    public String integrates(String text, Boolean g5Forg7) { \r\n")
                .append("        if(!g5Forg7 && g7.contains(text)){ \r\n")
                .append("            return g5.get(g7.indexOf(text)); \r\n")
                .append("        } else if(g5Forg7 && g5.contains(text)){ \r\n")
                .append("            return g7.get(g5.indexOf(text)); \r\n")
                .append("        } \r\n")
                .append("        return null; \r\n")
                .append("    } \r\n")
                .append("}");

        try {
            arquivo = new FileWriter(new File("src/" + nameList + ".java"));
            arquivo.write(builder.toString());
            arquivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        RecebeCSVRetornaClass r = new RecebeCSVRetornaClass("Teste");

    }

}


