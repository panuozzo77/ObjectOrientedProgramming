package esami.prof_Ficco.C.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListaPacchiNatale extends ListaPacchi {
    private static int numPacchi = 0;
    private List<Pacco> lista;

    public ListaPacchiNatale(Date data, Date consegna) {
        super(data, consegna);
        lista = new ArrayList<>();
    }

    public List<Pacco> getLista(){
        return this.lista;
    }

    @Override
    public void Aggiungi(Pacco d) {
        lista.add(d);
        System.out.println("aggiunto " + d);
        numPacchi++;
    }

    @Override
    public void Rimuovi(Pacco d) {
        lista.remove(d);
        numPacchi--;
    }

    @Override
    public void Modifica(){
        System.out.println("La data di consegna attuale è: "+ super.getConsegna());
        try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in))){
            Date d = DateFormat.getDateInstance().parse(in.readLine());
            super.setData(d);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}
