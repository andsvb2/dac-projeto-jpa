package br.edu.ifpb.dac.anderson.projetojpa.presentation.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Year;
import java.util.Scanner;

@Component
public class InputUtil {

    private Scanner scanner = new Scanner(System.in);
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

    public Year getYear(String message){
        printer.printLine(message);
        return Year.parse(scanner.nextLine());
    }

    public LocalDate getBirthDate(String message){
        printer.printLine(message);
        return LocalDate.parse(scanner.nextLine());
    }
}
