package esami.homeAutomation;

import java.util.ArrayList;
import java.util.List;

class HomeAutomation {
    public List<Object> appliances;

    public HomeAutomation() {
        appliances = new ArrayList<>();
    }

    public void addAppliance(Object appliance) {
        appliances.add(appliance);
    }

    public void executeProgram(int i, int j) {
        if (i < appliances.size()) {
            Object appliance = appliances.get(i);

            if (appliance instanceof WashingMachine && j < ((WashingMachine) appliance).programs.size()) {
                if (!((WashingMachine) appliance).isOn) {
                    ((WashingMachine) appliance).start();
                }
                ((WashingMachine) appliance).next();
                ((WashingMachine) appliance).play();
            } else if (appliance instanceof MP3Player && j < ((MP3Player) appliance).songs.size()) {
                if (!((MP3Player) appliance).isOn) {
                    ((MP3Player) appliance).start();
                }
                ((MP3Player) appliance).next();
                ((MP3Player) appliance).play();
            }
        }
    }

    public void stopAll() {
        for (Object appliance : appliances) {
            if (appliance instanceof WashingMachine) {
                ((WashingMachine) appliance).stop();
            } else if (appliance instanceof MP3Player) {
                ((MP3Player) appliance).stop();
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Object appliance : appliances) {
            sb.append(appliance.toString()).append("\n");
        }
        return sb.toString();
    }
}
