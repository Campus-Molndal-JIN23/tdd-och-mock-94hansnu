package org.campusmolndal.weatherService;

/**
 * Klassen har en konstruktor som tar emot en instans av WeatherAPI som parameter
 * Klassen har olika metoder för att hämta vädervärden baserat på en given plats genom
 * att använda WeatherAPI.
 * Varje metod anropar motsvarande metod i weatherAPI för att hämta det specifika vädervärdet (som är på låtsas)
 */
public class WeatherService {
    final private WeatherAPI weatherAPI;

    public WeatherService(WeatherAPI weatherAPI){
        this.weatherAPI= weatherAPI;
    }
    public double getTemperature(String location){
        return weatherAPI.getTemperatur(location);
    }
    public double getWindSpeed(String location){
        return weatherAPI.getWindSpeed(location);
    }
    public double getCloud(String location){
        return weatherAPI.getCloud(location);
    }
    public String getCity(String location) {
        return weatherAPI.getCity(location);
    }
    public String getCountry(String location){
        return weatherAPI.getCountry(location);
    }
}
