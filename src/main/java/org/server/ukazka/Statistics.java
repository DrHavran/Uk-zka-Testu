package org.server.ukazka;

public class Statistics {

    //{
    //  "continent": "Europe",
    //  "year": 2007,
    //  "countryCount": 30,
    //  "totalPopulation": 586098529,
    //  "averageLifeExp": 77.6486,
    //  "averageGdpPercap": 25054.4816,
    //  "highestLifeExpCountry": "Iceland",
    //  "lowestLifeExpCountry": "Turkey"
    //}
    private final String continent;
    private final int year;
    private final int countryCount;
    private final double totalPopulation;
    private final double averageLifeExp;
    private final double averageGdpPerCap;
    private final String highestLifeExpCountry;
    private final String lowestLifeExpCountry;

    public Statistics(String continent, int year, int countryCount, double totalPopulation, double averageLifeExp, double averageGdpPerCap, String highestLifeExpCountry, String lowestLifeExpCountry) {
        this.continent = continent;
        this.year = year;
        this.countryCount = countryCount;
        this.totalPopulation = totalPopulation;
        this.averageLifeExp = averageLifeExp;
        this.averageGdpPerCap = averageGdpPerCap;
        this.highestLifeExpCountry = highestLifeExpCountry;
        this.lowestLifeExpCountry = lowestLifeExpCountry;
    }

    public String getContinent() {
        return continent;
    }

    public int getYear() {
        return year;
    }

    public int getCountryCount() {
        return countryCount;
    }

    public double getTotalPopulation() {
        return totalPopulation;
    }

    public double getAverageLifeExp() {
        return averageLifeExp;
    }

    public double getAverageGdpPerCap() {
        return averageGdpPerCap;
    }

    public String getHighestLifeExpCountry() {
        return highestLifeExpCountry;
    }

    public String getLowestLifeExpCountry() {
        return lowestLifeExpCountry;
    }
}
