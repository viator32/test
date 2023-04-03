import java.io.*;

public class Finder {
    public BufferedReader getSystemInAsBufferedReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }
    public void findStringInFiles(String searchString, String[] filenames)   {
        for(String filename:filenames) {

            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
                int linenumber = 1;
                String line;
                while((line=bufferedReader.readLine())!=null){

                    if(line.contains(searchString)){
                        System.out.println(filename+" line: "+linenumber+" : "+line);
                    }
                    linenumber++;
                }
            }catch(IOException e){
                System.out.println("Fehler beim Lesen datei: "+filename);
            }
        }

        // Teilaufgabe b
    }
    public static void main(String[] args)
    {
        Finder finder = new Finder();
        BufferedReader br = finder.getSystemInAsBufferedReader();
        String searchString = null;
        try {
            searchString = br.readLine();
            finder.findStringInFiles(searchString, args);
            br.close();
        } catch (IOException ex) {
            System.out.println("Einlesen fehlgeschlagen.");
        }; }
}

