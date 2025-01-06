package esami.Officina.interfaces;

public interface OfficinaImpl {

    void saveVehicles();

    //    void printAllVehicles();

    //    void printReparedVehicles();

    //    void printDeliveredVehicles();

    void loadVehicles();

    void loadVehicles(String filename);

    void deleteDeliveredVehicles();
}
