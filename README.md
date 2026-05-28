Je důležité, když máte ty funkce VRACET SPRÁVNÝ TYP - prý na tom pohořela 80% třídy

"public <RETURN TYP> <NÁZEV FUNKCE>"

Když do něj vložíte Objekt (jako třeba tady jak používáme Country), nebo dokonce celý ArrayList (ArrayList<Country>)
Spring boot si ho SÁM převede na JSON!!!


INPUTY
@PathVariable -> /{year} (Input v url adrese, musí být v {} závorkách)
Ukázka: /api/gapminder/year/{year}

@RequestParam -> ?year=2007 (Input za otazníkem, může jich být více když je oddělíte &)
Ukázka: /api/gapminder/life-expectancy/improvement?from={fromYear}&to={toYear}&limit={limit}
(3 x @RequestParam)

@RequestParam(required = false) je, že ten parameter není povinný, a v tomhle případě pokud ho user nevyplní tak bude null

NÁZVY MUSÍ BÝT STEJNÝ!!!
