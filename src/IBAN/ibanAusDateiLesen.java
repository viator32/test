package IBAN;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;

public class ibanAusDateiLesen {
    public void ibanAusDateiLesen(String dateiname) throws IOException, FalscheIBANExeption {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(dateiname))) {
            String line;
            ibanCheck ic = new ibanCheck();
            while (bufferedReader.readLine() != null) {
                try {
                    line = bufferedReader.readLine();
                    if (!ic.ibanCheck(line)) {
                        throw new FalscheIBANExeption("FEHLER: Die IBAN ist ungültig: " + line);
                    }
                } catch (FalscheIBANExeption e) {
                    System.out.println(e.getMessage());
                    throw e;
                }
            }
            System.out.println("Erfolg: Alle IBANs sing gultig");
        } catch (FileNotFoundException e) {
            System.out.println("Datei nicht gefunden: " + dateiname);
            throw e;
        } catch (IOException e) {
            System.out.println("Fehler beim Lesevorgang von datei " + dateiname);
            throw e;
        } catch (NullPointerException e) {
            System.out.println("Datie " + dateiname + "exestiert nicht");
            throw e;


        }
    }

    public void dataeinTest(String[] dateinamen) {
        for (String dateiname : dateinamen) {

            try {
                ibanAusDateiLesen(dateiname);
                System.out.println("Die Datei "+ dateiname +" enthalt nur gultige IBANs");
            } catch (NullPointerException | IOException | FalscheIBANExeption e) {
                System.out.println("Fehler in der Datei " + dateiname);
            }
        }
    }
}

