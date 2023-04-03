package MusikStueck;



    public class MusikStueck
    {
        protected String titel;
        protected String interpret;
        protected int laenge;

        public MusikStueck(String titel, String interpret, int laenge)
        {
            this.titel = titel;
            this.interpret = interpret;
            this.laenge = laenge;
        }

        public void setTitel(String titel) {
            this.titel = titel;
        }

        public void setInterpret(String interpret) {
            this.interpret = interpret;
        }

        public void setLaenge(int laenge) {
            this.laenge = laenge;
        }

        public String getTitel() {
            return titel;
        }

        public String getInterpret() {
            return interpret;
        }

        public int getLaenge() {
            return laenge;
        }

        @Override
        public String toString() {
            return "MusikStueck{" +
                    "titel='" + titel + '\'' +
                    ", interpret='" + interpret + '\'' +
                    ", laenge=" + laenge +
                    '}';
        }
    }

