package br.edu.ifpb.dac.anderson.projetojpa.presentation.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class InputUtil {

    @Autowired
    private Scanner scanner;
    @Autowired
    private PrinterUtil printer;

    public int getInteger(String message) {
        printer.printLine(message);
        return Integer.parseInt(scanner.nextLine());
    }


    public String getString(String message){
        printer.printLine(message);
        return scanner.nextLine();

    }
}
