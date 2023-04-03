package IBAN;

public class FalscheIBANExeption extends Exception {
    public FalscheIBANExeption() {
        super("FEHLER:Datei entha ̈lt ungu ̈ltige IBAN ");
    }

    public FalscheIBANExeption(String message) {
        super(message);
    }
}
