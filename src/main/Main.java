package main;

import converter.ConverterEstadoType;
import converter.ConverterTeste;
import model.EstadoType;

public class Main {
    public static void main(String[] args) {
        EstadoType e = EstadoType.APROVADO;
        System.out.println(e.getEstado());
        System.out.println("*****");
        System.out.println(ConverterEstadoType.converter(1));
        System.out.println(ConverterEstadoType.converter(EstadoType.ORCAMENTO));
    }
}
