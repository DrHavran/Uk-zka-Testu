package org.server.ukazka;

public class CountryImprovement {
    //{
    //    "country": "Oman",
    //    "continent": "Asia",
    //    "fromYear": 1952,
    //    "toYear": 2007,
    //    "lifeExpFrom": 37.578,
    //    "lifeExpTo": 75.64,
    //    "improvement": 38.062
    //  },

    private final String country;
    private final String continent;
    private final int fromYear;
    private final int toYear;
    private final double lifeExpFrom;
    private final double lifeExpTo;
    private final double improvement;

    public CountryImprovement(String country, String continent, int fromYear, int toYear, double lifeExpFrom, double lifeExpTo, double improvement) {
        this.country = country;
        this.continent = continent;
        this.fromYear = fromYear;
        this.toYear = toYear;
        this.lifeExpFrom = lifeExpFrom;
        this.lifeExpTo = lifeExpTo;
        this.improvement = improvement;
    }

    public String getCountry() {
        return country;
    }

    public String getContinent() {
        return continent;
    }

    public int getFromYear() {
        return fromYear;
    }

    public int getToYear() {
        return toYear;
    }

    public double getLifeExpFrom() {
        return lifeExpFrom;
    }

    public double getLifeExpTo() {
        return lifeExpTo;
    }

    public double getImprovement() {
        return improvement;
    }
}
