package IBAN;

public class ibanCheck {

    public boolean ibanCheck(String iban) throws FalscheIBANExeption {
        iban.toUpperCase();
        if (iban.length() != 22 || !iban.startsWith("DE")) {
            throw new FalscheIBANExeption("FEHLER: Ungültige Länge oder Ländercode in IBAN: " + iban);
        }
        return true;
    }
}
