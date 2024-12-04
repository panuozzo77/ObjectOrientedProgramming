package Officina;

import Officina.interfaces.OfficinaImpl;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Officina implements OfficinaImpl {
    private static ArrayList<Auto> jobs = new ArrayList<Auto>();


    public void listVehicles(){
        for (Auto auto : jobs){
            System.out.println(auto.toString());
        }
        if(jobs.isEmpty()){
            System.out.println("Lista auto vuota!");
        }
    }

    @Override
    public void saveVehicles() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while(true) {
                System.out.println("Inserire un'opzione:\n" +
                        "\t1. Stampa tutti i veicoli.\n" +
                        "\t2. Stampa i veicoli riparati.\n" +
                        "\t3. Stampa i veicoli consegnati.\n" +
                        "\t0. Esci");
                choice = scanner.nextInt();

                if (choice == 0) {
                    System.out.println("Uscita dal programma in corso...");
                    break;
                }
                if (choice > 3 || choice < 0) {
                    System.out.println("Inserire un'opzione valida!");

                }
                else {
                    System.out.println("Salvataggio in corso!");
                    save(choice);
                }

        }
    }

    @Override
    public void loadVehicles(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Supponiamo che la riga sia nel formato: "targa: <targa>, stato: <stato>, data_arrivo: <data_arrivo>"
                String[] parts = line.split(", ");

                if (parts.length == 3) {
                    String targa = parts[0].split(": ")[1];  // Estrae la targa
                    String statoStr = parts[1].split(": ")[1];  // Estrae lo stato
                    String dataArrivoStr = parts[2].split(": ")[1];  // Estrae la data di arrivo

                    // Crea un'auto solo se lo stato è valido
                    State stato = State.fromString(statoStr);
                    if (stato != null) {
                        // Parsing della data
                        LocalDate dataArrivo = LocalDate.parse(dataArrivoStr);

                        // Crea un'auto e aggiungila alla lista
                        Auto auto = new Auto();
                        auto.setTarga(targa);
                        auto.setState(stato);
                        auto.setData_arrivo(dataArrivo.toString());
                        jobs.add(auto);
                    }
                }
            }
            System.out.println("Le auto sono state caricate correttamente dal file: " + filename);
        } catch (IOException e) {
            System.out.println("Errore durante la lettura del file: " + e.getMessage());
        } catch (DateTimeParseException e) {
            System.out.println("Errore nel parsing della data: " + e.getMessage());
        }
    }

    @Override
    public void loadVehicles() {
        loadVehicles("tutte.txt");

    }

    @Override
    public void deleteDeliveredVehicles() {
        jobs.removeIf(job -> job.getState().equals(State.CONSEGNATO));
    }


    public void addJob(Auto auto) {
        jobs.add(auto);
    }

    public void removeJob(Auto auto) {
        jobs.remove(auto);
    }

    public void addJobInteractive() {
        Scanner scanner = new Scanner(System.in);

        Auto car = new Auto();
        car.setTarga(scanner.nextLine());
        car.setState(selectState());
        car.setData_arrivo(selectDate());

        jobs.add(car);
    }

    private void save(int choice) {
        State state = null;
        String filename = "tutte";


        if (choice == 2) {
            state = State.RIPARAZIONE;
            filename += "_riparate";
        } else if (choice == 3) {
            state = State.CONSEGNATO;
            filename += "_consegnate";
        }

        // Aggiungi l'estensione del file
        filename += ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // Scrittura delle auto nel file
            for (Auto auto : jobs) {
                // Se è stato selezionato uno stato, filtra le auto in base a quello
                if (state == null || auto.getState() == state) {
                    writer.write(auto.toString());
                    writer.newLine();
                }
            }
            System.out.println("Le auto sono state salvate correttamente nel file: " + filename);
        } catch (IOException e) {
            System.out.println("Errore durante la scrittura del file: " + e.getMessage());
        }
    }

    public State selectState() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (true) {
            System.out.println("Inserire un'opzione:\n" +
                    "\t1. In Riparazione.\n" +
                    "\t2. Riparato.\n" +
                    "\t3. Consegnato.\n");

            choice = scanner.nextInt();

            if (choice == 1) {
                return State.RIPARAZIONE;
            }
            if (choice == 2) {
                return State.RIPARATO;
            }
            if (choice == 3) {
                return State.CONSEGNATO;
            }
            else {
                System.out.println("Inserire un'opzione valida!");
            }
        }
    }

    public static String selectDate() {
        Scanner scanner = new Scanner(System.in);
        String inputDate;
        LocalDate date = null;

        while (true) {
            System.out.print("Perfavore inserire una data nel formato YYYY-MM-DD: ");
            inputDate = scanner.nextLine();

            if (!inputDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
                System.out.println("Formato non valido. Perfavore usa il formato corretto: YYYY-MM-DD.");
                continue;
            }

            try {
                date = LocalDate.parse(inputDate, DateTimeFormatter.ISO_LOCAL_DATE);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date. Please enter a valid date.");
            }
        }

        return date.toString();
    }
}
