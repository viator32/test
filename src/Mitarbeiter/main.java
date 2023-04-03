package Mitarbeiter;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class main {
    public static void main(String[] args) {
        Mitarbeiter m1 = new Mitarbeiter("Sosi", "Bibu", 1, 650);
        Mitarbeiter m2 = new Mitarbeiter("Serhii", "Rad", 2, 1000);
        Mitarbeiter m3 = new Mitarbeiter("Nico", "Boi", 3, 444);
        try (ObjectOutputStream outs = new ObjectOutputStream(new FileOutputStream("mitarbeiter.dat"))) {
            outs.writeObject(m1);
            outs.writeObject(m2);
            outs.writeObject(m3);
            System.out.println("Mitarbeiter erfolgreich geschpeichert!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Set<Mitarbeiter> set = new HashSet<>();

        try (ObjectInputStream ins = new ObjectInputStream(new FileInputStream("/Users/serhiiradkovskyi/IdeaProjects/Klausur/mitarbeiter.dat"))) {
            {
                try{
                while (true){
                    Mitarbeiter m = (Mitarbeiter) ins.readObject();
                    set.add(m);}

                }catch (EOFException e){
                   System.out.println("Datei im set hinzugefugt");
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Ausgabe aller Mitrabeiter");
        for (Mitarbeiter m : set) {
            System.out.println(m.toString());
        }

    }


    public Mitarbeiter[] sortiere(Collection<Mitarbeiter> team) {
        Mitarbeiter[] teamArray = team.toArray(team.toArray(new Mitarbeiter[team.size()]));
        Arrays.sort(teamArray, new VergleichePersonalNummer());
        return teamArray;
    }

}
