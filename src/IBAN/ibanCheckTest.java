package IBAN;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ibanCheckTest {
@Test

    void IbanChecktest(){

    try{
        ibanCheck ibanChecktest = new ibanCheck();
        assertTrue(ibanChecktest.ibanCheck ("DE1234564327849058372154326"));
        fail("FalscheIbanExeption Erwartet");
    }catch (FalscheIBANExeption e){
        e.printStackTrace();
    }
}
}