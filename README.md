# Spring Boot — Poznámky

Je důležité, když máte ty funkce **VRACET SPRÁVNÝ TYP** — prý na tom pohořela 80% třídy.

```java
public <NÁZEV FUNKCE>
```

Když do něj vložíte Objekt (jako třeba tady jak používáme `Country`), nebo dokonce celý `ArrayList` (`ArrayList<Country>`), Spring Boot si ho **SÁM převede na JSON**!!!

---

# INPUTY

## `@PathVariable`

Používá se pro input v URL adrese — musí být v `{}` závorkách.

### Syntax

```java
/{year}
```

### Ukázka

```java
/api/gapminder/year/{year}
```

---

## `@RequestParam`

Používá se pro input za otazníkem (`?`).

Může jich být více, když je oddělíte `&`.

### Syntax

```java
?year=2007
```

### Ukázka

```java
/api/gapminder/life-expectancy/improvement?from={fromYear}&to={toYear}&limit={limit}
```

➡️ Tady jsou `3x @RequestParam`

---

## `@RequestParam(required = false)`

Znamená, že ten parameter **není povinný**.

Pokud ho user nevyplní, bude:

```java
null
```

## NÁZVY MUSÍ BÝT STEJNÝ!!!
