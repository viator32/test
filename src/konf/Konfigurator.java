package konf;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Konfigurator {

    public Konfigurator() throws IOException {
    }

    public static List<String> listKongurationsdatei() throws IOException{
        List<String> listKonfig = new ArrayList<>();
        try(BufferedReader input = new BufferedReader(new FileReader("/Users/serhiiradkovskyi/IdeaProjects/Klausur/src/konf/datei.txt"));){
            String line;
            while((line=input.readLine())!=null){
                listKonfig.add(line);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return listKonfig;
    }


    List<String> list = new ArrayList<>(Konfigurator.listKongurationsdatei());

    public static Map<String, String> domap(List<String> list){

        Map<String, String> map = new HashMap<>();
        String temp;

    for (int i = 0; i < list.size(); i++) {
        temp = list.get(i);

        int Geichheitszeichen = temp.indexOf('=');
        int Stringlang = temp.length();

        String key = temp.substring(0,Geichheitszeichen);
        String value = temp.substring(Geichheitszeichen+1,Stringlang);

        map.put(key,value);

    }
        return map;
    }


    public static void main(String[] args) throws IOException {
System.out.println(domap(Konfigurator.listKongurationsdatei()));
    }
}

