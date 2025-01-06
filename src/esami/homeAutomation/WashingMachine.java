package esami.homeAutomation;

import java.util.ArrayList;
import java.util.List;

class WashingMachine {
    private String name;
    private String brand;
    public List<String> programs;
    private String selectedProgram;
    public boolean isOn;
    private int executedPrograms;
    private boolean goingRight;
    public String history = "";

    public WashingMachine(String name, String brand) {
        this.name = name;
        this.brand = brand;
        this.programs = new ArrayList<>();
        this.programs.add("Wool");
        this.programs.add("Normal");
        this.programs.add("Silk");
        this.programs.add("Quick");
        this.selectedProgram = null;
        this.isOn = false;
        this.executedPrograms = 0;
        this.goingRight = true;
        this.history += "created: " + this.name +" "+this.brand + "\n";
    }

    public void start() {
        isOn = true;
        selectedProgram = programs.get(0);
        System.out.println("Washing machine '" + name + "' is on. Selected program: " + selectedProgram);
        this.history += "turned on\n";
    }

    public String next() {
        if (!isOn) {
            return null;
        }

        if (selectedProgram == null) {
            selectedProgram = programs.get(0);
            this.history += "selected default program\n";
            return selectedProgram;
        }

        int index = programs.indexOf(selectedProgram);

        if (index == programs.size() - 1) {
            goingRight = false; //non posso andare avanti
        }

        if (index == 0 && !goingRight) {
            goingRight = true;
        }

        if (goingRight) {
            selectedProgram = programs.get(index + 1);
            this.history += "selected next program\n";
        }
        else {
            selectedProgram = programs.get(index - 1);
            this.history += "selected previous program\n";
        }

        return selectedProgram;
    }

    public String play() {
        if (!isOn || selectedProgram == null) {
            return null;
        }

        System.out.println("Executing program: " + selectedProgram);
        executedPrograms++;
        this.history += "executed programs: " + executedPrograms + "\n";
        return selectedProgram;
    }

    public void stop() {
        isOn = false;
        System.out.println("Washing machine " + name + " is off.");
    }

    @Override
    public String toString() {
        return name + " (" + brand + ") - Programs executed: " + executedPrograms + " - History: " + history;
    }
}