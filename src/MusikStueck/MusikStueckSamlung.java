package MusikStueck;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MusikStueckSamlung {
    private HashMap<String,MusikStueck> sammlung;

    public MusikStueckSamlung() {
        this.sammlung = new HashMap<>();
    }
 void musikStueckEinfügen(MusikStueck neu) throws IllegalArgumentException{
        if(sammlung.containsKey(neu.getTitel())){
            System.out.println(neu.getTitel()+" gibst schon im Playlist.");
        }else sammlung.put(neu.getTitel(),neu);
 }

    public MusikStueck[] getAlleMusikStueckeNachTitel(){
        MusikStueck[] musikarray = sammlung.values().toArray(new MusikStueck[sammlung.size()]);
        Arrays.sort(musikarray, new VergleicheMusikTitel());
        return musikarray;
    }
}
