package esami.homeAutomation;

import java.util.Random;

public class Tester {

    public static void main(String[] args) {

        HomeAutomation homeAutomation = new HomeAutomation();
        Random random = new Random();

        // Create 10 washing machines
        for (int i = 1; i <= 10; i++) {
            WashingMachine washingMachine = new WashingMachine("Washing Machine " + i, "Brand" + random.nextInt(5));
            homeAutomation.addAppliance(washingMachine);
        }
    /*
        // Create 10 MP3 players and load them with songs
        for (int i = 1; i <= 10; i++) {
            esami.homeAutomation.MP3Player mp3Player = new esami.homeAutomation.MP3Player("MP3 Player " + i, "Brand" + random.nextInt(5));
            List<String> songs = new ArrayList<>();
            for (int j = 1; j <= 5; j++) { // Load 5 songs
                songs.add("Song " + j);
            }
            mp3Player.load(songs);
            esami.homeAutomation.addAppliance(mp3Player);
        }
    */
        // Execute 100 random programs/songs
        for (int k = 0; k < 100; k++) {
            int i = random.nextInt(homeAutomation.appliances.size());
            int j = random.nextInt(8);

            homeAutomation.executeProgram(i, j);
        }

        // Stop all appliances
        homeAutomation.stopAll();

        // Display information about all appliances
        System.out.println("Appliance Information:");
        System.out.println(homeAutomation.toString());
    }
}
