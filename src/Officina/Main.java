package Officina;

public class Main {
    public static void main(String[] args) {
        Officina officina = new Officina();

        //officina.listVehicles();

        //officina.addJobInteractive();
        //officina.listVehicles();

        // officina.addJob( new Auto("FF157FR", State.CONSEGNATO, "2021-10-01"));
        // officina.addJob( new Auto("DG667HG", State.RIPARATO, "2021-10-04"));
        officina.listVehicles();

        //officina.saveVehicles();
        officina.loadVehicles("tutte.txt");

        officina.listVehicles();
    }
}
