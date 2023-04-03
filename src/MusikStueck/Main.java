package MusikStueck;

import javax.sound.midi.Soundbank;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MusikStueck m1 = new MusikStueck("pora","luv66",245);
        MusikStueck m2 = new MusikStueck("Avrora","ASAPROSKCU",367);
        MusikStueck m3 = new MusikStueck("qwerty","orbita",123);
        MusikStueck m4 = new MusikStueck("sex","luv66",666);
        MusikStueckSamlung musikStueckSamlung = new MusikStueckSamlung();
        musikStueckSamlung.musikStueckEinfügen(m1);
        musikStueckSamlung.musikStueckEinfügen(m2);
        musikStueckSamlung.musikStueckEinfügen(m3);
        musikStueckSamlung.musikStueckEinfügen(m4);
        musikStueckSamlung.musikStueckEinfügen(m4);
        MusikStueck[] msarray = musikStueckSamlung.getAlleMusikStueckeNachTitel();
        for(MusikStueck m:msarray){
            System.out.println(m);
        }

    }
}
