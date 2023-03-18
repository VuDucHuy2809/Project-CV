package com.example.country;

import java.io.Serializable;

public class Country implements Serializable {
    public String Continent;
    public String Capital;
    public String Population;
    public String CountryCode;
    public String CountryName;
    public String ContinentName;
    public String CurrencyCode;
    public String Area;
    public String urlImage;

    public Country ()
    {

    }

    public Country(String continent, String capital, String population, String countryCode,String Area,String countryName, String continentName, String currencyCode) {
        Continent = continent;
        Capital = capital;
        Population = population;
        CountryCode = countryCode;
        CountryName = countryName;
        ContinentName = continentName;
        CurrencyCode = currencyCode;
        this.Area = Area;
        urlImage = String.format("https://img.geonames.org/img/country/250/%s.png",CountryCode);
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }

    public String getContinent() {
        return Continent;
    }

    public void setContinent(String continent) {
        Continent = continent;
    }

    public String getCapital() {
        return Capital;
    }

    public void setCapital(String capital) {
        Capital = capital;
    }

    public String getPopulation() {
        return Population;
    }

    public void setPopulation(String population) {
        Population = population;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public String getCountryName() {
        return CountryName;
    }

    public void setCountryName(String countryName) {
        CountryName = countryName;
    }

    public String getContinentName() {
        return ContinentName;
    }

    public void setContinentName(String continentName) {
        ContinentName = continentName;
    }

    public String getCurrencyCode() {
        return CurrencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        CurrencyCode = currencyCode;
    }
}

