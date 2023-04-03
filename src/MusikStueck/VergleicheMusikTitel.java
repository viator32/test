package MusikStueck;

import java.util.Comparator;

public class VergleicheMusikTitel implements Comparator<MusikStueck> {

    @Override
    public int compare(MusikStueck o1,MusikStueck o2) {
        return o1.getTitel().compareTo(o2.getTitel());
    }
}
