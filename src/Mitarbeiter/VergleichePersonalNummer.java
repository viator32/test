package Mitarbeiter;

import java.util.Comparator;

public class VergleichePersonalNummer implements Comparator<Mitarbeiter> {
    @Override
    public int compare(Mitarbeiter o1, Mitarbeiter o2) {
       return o1.getNummer()-o2.getNummer();
    }
}
