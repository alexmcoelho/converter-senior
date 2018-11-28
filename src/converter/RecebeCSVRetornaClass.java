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

    public RecebeCSVRetornaClass() {

        // abre um arquivo e cria um file
        File arquivoCSV = new File("converter.csv");

        String[] valoresEntreVirgulas = null;

        // cria um scanner para ler o arquivo
        Scanner leitor = null;

        //String que será salvo no converter.txt
        StringBuilder builder = new StringBuilder();

        // variável que armazenará as linhas do arquivo
        String linhasDoArquivo = new String();

        //nome classe
        String nomeClasse = "";

        //tipo variável
        String tipoVariavel = "";

        //escreve no arquivo
        FileWriter arquivo;

        try {
            leitor = new Scanner(arquivoCSV);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        linhasDoArquivo = leitor.nextLine();

        // separa os campos entre as virgulas de cada linha
        valoresEntreVirgulas = linhasDoArquivo.split(";");

        nomeClasse = valoresEntreVirgulas[0];
        tipoVariavel = valoresEntreVirgulas[1];

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
        builder.append("package converter;\r\n")
                .append("import model.EstadoType;\r\n\r\n")
                .append("public class " + "Converter" + nomeClasse + "{ \r\n\r\n")
                .append("public static " + tipoVariavel + " converter(EstadoType type) { \r\n")
                .append("    if (type == null) return null; \r\n")
                .append("    switch (type) { \r\n");

        for (int i = 0; i < g7.size(); i++) {
            builder.append("        case " + g7.get(i) + ":\r\n");
            String retorno = tipoVariavel.equals("Integer") ? g5.get(i) : "\"" + g5.get(i) + "\"";
                    builder.append("            return " + retorno + "; \r\n");
        }

        builder.append("        default: \r\n")
                .append("            return null; \r\n")
                .append("} \r\n")
                .append("} \r\n");

        builder.append("public static " + nomeClasse + " converter(" + tipoVariavel + " type) {")
                .append("if (type == null) return null;")
                .append("switch (type) {");
        for (int i = 0; i < g7.size(); i++) {
            String retorno = tipoVariavel.equals("Integer") ? g5.get(i) : "\"" + g5.get(i) + "\"";
            builder.append("        case " + retorno + ":\r\n");
            builder.append("return " + nomeClasse + "." + g7.get(i) + "; \r\n");
        }

        builder.append("default: \r\n")
                .append("return null; \r\n")
                .append("} \r\n")
                .append("} \r\n")
                .append("} \r\n");

        try {
            arquivo = new FileWriter(new File("src/converter/" + "Converter" + nomeClasse + ".java"));
            arquivo.write(builder.toString());
            arquivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        RecebeCSVRetornaClass r = new RecebeCSVRetornaClass();

    }

}


