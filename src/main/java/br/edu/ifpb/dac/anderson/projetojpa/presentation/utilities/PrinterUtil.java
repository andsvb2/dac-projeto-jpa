package br.edu.ifpb.dac.anderson.projetojpa.presentation.utilities;

import org.springframework.stereotype.Component;

@Component
public class PrinterUtil {

    public void print(String message) {
        System.out.print(message);
    }

    public void printLine(String message) {
        System.out.println(message);
    }
}
