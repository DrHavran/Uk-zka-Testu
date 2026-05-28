package org.server.ukazka;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Data {
    private final ArrayList<Country> countries;

    // Základní loading dat
    public Data() {
        this.countries = new ArrayList<>();
        try{
            Scanner sc = new Scanner(new File("gapminderDataFiveYear.csv"));
            sc.nextLine();
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                String[] parts = line.split(",");

                countries.add(
                        new Country(
                                parts[0],
                                Integer.parseInt(parts[1]),
                                Double.parseDouble(parts[2]),
                                parts[3],
                                Double.parseDouble(parts[4]),
                                Double.parseDouble(parts[5])
                        )
                );
            }
        }
        catch (Exception e ){
            e.printStackTrace();
        }
    }

    public ArrayList<Country> getCountries() {
        return countries;
    }
}