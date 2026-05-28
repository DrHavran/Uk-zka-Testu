package org.server.ukazka;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

// Controller - konekce mezi frontendem a backendem
@RestController
@RequestMapping("/")
public class Controller {
    // Odděleně jenom, aby to bylo hezčí
    Data data = new Data();

    ///api/gapminder/year/2007?continent=Europe
    @GetMapping("/api/gapminder/year/{year}")
    public ArrayList<Country> getCountriesByYear(@PathVariable int year, @RequestParam(required = false) String continent ){
        ArrayList<Country> countries = data.getCountries();

        // Jenom země s zadaným rokem
        ArrayList<Country> result = countries.stream()
                .filter(country -> country.getYear() == year)
                .collect(Collectors.toCollection(ArrayList::new));

        // Pokud je zadaný kontinent, vyfiltruj ještě continent (continent je optional)
        if(continent != null){
            result = countries.stream()
                    .filter(country -> country.getContinent().equalsIgnoreCase(continent))
                    .collect(Collectors.toCollection(ArrayList::new));
        }

        return result;
    }

    ///api/gapminder/continents/{continent}/stats?year={year}
    @GetMapping("/api/gapminder/continents/{continent}/stats")
    public Statistics getStatistics(@PathVariable String continent, @RequestParam int year){
        ArrayList<Country> countries = data.getCountries();

        //  Vyfiltruje země s zadaným rokem a kontinentem
        ArrayList<Country> result =
                countries.stream()
                        .filter(country -> country.getContinent().equalsIgnoreCase(continent))
                        .filter(country -> country.getYear() == year)
                        .collect(Collectors.toCollection(ArrayList::new));

        // Vypočátání potřebných údajů
        double totalPopulation = result.stream()
                .mapToDouble(Country::getPopulation)   // Country -> double
                .sum();

        double averageLifeExp = result.stream()
                .mapToDouble(Country::getLifeExp)   // Country -> double
                .sum() / result.size();

        double averageGpdPerCap = result.stream()
                .mapToDouble(Country::getGpdPerCap)   // Country -> double
                .sum() / result.size();

        // For loop na vypočítaní nejhorší a nejlepší země
        String highestLifeExpCount = "";
        String lowestLifeExpCount = "";
        double highest = 0.0;
        double lowest = Double.MAX_VALUE;
        for(Country country : result){
            if(country.getLifeExp() > highest){
                highestLifeExpCount = country.getCountry();
                highest = country.getLifeExp();
            }

            if(country.getLifeExp() < lowest){
                lowestLifeExpCount = country.getCountry();
                lowest = country.getLifeExp();
            }
        }

        return new Statistics(
                continent,
                year,
                result.size(),
                totalPopulation,
                averageLifeExp,
                averageGpdPerCap,
                highestLifeExpCount,
                lowestLifeExpCount
        );
    }

    ///api/gapminder/life-expectancy/improvement?from={fromYear}&to={toYear}&limit={limit}
    @GetMapping("/api/gapminder/life-expectancy/improvement")
    public ArrayList<CountryImprovement> getBestImprovement(@RequestParam int fromYear, @RequestParam int toYear, @RequestParam int limit){
        ArrayList<Country> countries = data.getCountries();

        // Vyfiltruji si odděleně země s začínajícím rokem a konečným rokem
        ArrayList<Country> start =
                countries.stream()
                        .filter( country -> country.getYear() == fromYear)
                        .collect(Collectors.toCollection(ArrayList::new));

        ArrayList<Country> end =
                countries.stream()
                        .filter( country -> country.getYear() == toYear)
                        .collect(Collectors.toCollection(ArrayList::new));

        // Projedu je (Assumuju, že jsou vždy na stejných pozicích stejné země) a vypočítám improvemet
        ArrayList<CountryImprovement> improvements = new ArrayList<>();
        for(int i = 0; i < start.size(); i++){
            Country startCountry = start.get(i);
            Country endCountry = end.get(i);

            double improvement = endCountry.getLifeExp() - startCountry.getLifeExp();

            improvements.add(
                    new CountryImprovement(
                            startCountry.getCountry(),
                            startCountry.getContinent(),
                            fromYear,
                            toYear,
                            startCountry.getLifeExp(),
                            endCountry.getLifeExp(),
                            improvement
                    )
            );
        }

        // Sortu to podle improvementu - reversnu, aby to bylo od největší po nejmenší a pak limitu na počet, který byl zadán
        return improvements.stream()
                .sorted(
                        Comparator.comparingDouble(CountryImprovement::getImprovement).reversed()
                )
                .limit(limit)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}