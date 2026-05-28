package org.server.ukazka;

public class Country {
    //country,year,pop,continent,lifeExp,gdpPercap
    private final String country;
    private final int year;
    private final double population;
    private final String continent;
    private final double lifeExp;
    private final double gpdPerCap;

    public Country(String country, int year, double population, String continent, double lifeExp, double gpdPerCap) {
        this.country = country;
        this.year = year;
        this.population = population;
        this.continent = continent;
        this.lifeExp = lifeExp;
        this.gpdPerCap = gpdPerCap;
    }

    public String getCountry() {
        return country;
    }
    public int getYear() {
        return year;
    }
    public double getPopulation() {
        return population;
    }
    public String getContinent() {
        return continent;
    }
    public double getLifeExp() {
        return lifeExp;
    }
    public double getGpdPerCap() {
        return gpdPerCap;
    }
}
