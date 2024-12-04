package Officina;

import java.util.Date;

public class Auto {
    private String targa;
    private State state;
    private String data_arrivo;

    Auto (String targa, State state, String data_arrivo) {
        this.targa = targa;
        this.state = state;
        this.data_arrivo = data_arrivo;
    }
    Auto () {}

    public String getTarga() {
        return targa;
    }
    public void setTarga(String targa) {
        this.targa = targa;
    }
    public State getState() {
        return state;
    }
    public void setState(State state) {
        this.state = state;
    }
    public String getData_arrivo() {
        return data_arrivo;
    }
    public void setData_arrivo(String data_arrivo) {
        this.data_arrivo = data_arrivo;
    }

    @Override
    public String toString() {
        return "targa: " + targa + ", stato: " + state + ", data_arrivo: " + data_arrivo;
    }
}

