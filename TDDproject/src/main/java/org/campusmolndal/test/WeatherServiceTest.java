package org.campusmolndal.test;

import org.campusmolndal.weatherService.WeatherAPI;
import org.campusmolndal.weatherService.WeatherService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class WeatherServiceTest {

    /**
     * @Mock används för att skapa en mock av weatherService-klassen.
     */
    @Mock
    private WeatherService weatherService;
    private WeatherAPI weatherAPI;


    /**
     * Metoder setup körs innan varje test och skapar en mock av weatherAPI och en instans av weatherService med den
     * mockade weatherAPI
     */
    @Before
    public void setup(){
        weatherAPI= mock(WeatherAPI.class);
        weatherService = new WeatherService(weatherAPI);
    }

    /**
     * GetWeather_Temperatur test metoden,
     * Ställer in returvärdet 25 när GetWeather_Temperatur anropas med platsen Stockholm
     * Anropar GetWeather_Temperatur med platsen Stockholm via mockade weatherAPI
     * Kontrollerar att temperaturen är 25.0
     */
    @Test
    public void testGetWeather_Temperatur() {
        when(weatherAPI.getTemperatur("Stockholm")).thenReturn(25.0);

        double temperature= weatherAPI.getTemperatur("Stockholm");

        assertEquals(25.0, temperature, 0.01);
    }

    /**
     * GetWeather_WindSpeed test metoden,
     * Ställer in returvärdet 10.5 när GetWeather_WindSpeed anropas med platsen Stockholm
     * Anropar GetWeather_WindSpeed med platsen Stockholm via WeatherService
     * Kontrollerar att vindhastigheten är 10.5
     * Kontrollerar att vindhastigheten är större än 0
     * Kontrollerar att vindhastigheten inte är null
     */

    @Test
    public void testGetWeather_WindSpeed(){
        when(weatherAPI.getWindSpeed("Stockholm")).thenReturn(10.5);

        double windSpeed= weatherService.getWindSpeed("Stockholm");

        assertEquals(10.5, windSpeed, 0.01);
        assertTrue(windSpeed > 0);
        assertNotNull(windSpeed);
    }

    /**
     * GetWeather_City_Exists test metoder,
     * Ställer in returvärdet Stockholm när getCity anropas med platsen Stockholm
     * Anropar getCity med platsen Stockholm via WeatherService
     * Kontrollerar att det returnerade staden är Stockholm
     */

    @Test
    public void testGetWeather_City_Exists(){
        when(weatherAPI.getCity("Stockholm")).thenReturn("Stockholm");

        String city= weatherService.getCity("Stockholm");

        assertEquals("Stockholm", city);
    }

    /**
     * GetWeather_City_NotExists test metoden,
     * ställer in returvärdet null när getCity anropas med en plats som inte finns
     * Anropar getCity med en plats som inte finns via weatherService
     * Kontrollerar att det returnerade staden är null
     */
    @Test
    public void testGetWeather_City_NotExists(){
        when(weatherAPI.getCity("Stad finns inte")).thenReturn(null);

        String city= weatherService.getCity("Stad finns inte");

        assertNull(city);

    }

    /**
     * GetWeather_Country_Exists test metoden,
     * ställer in returvärdet Sweden när getCounty anropas med platsen Stockholm
     * Anropar getCountry med platsen Stockholm via weatherService
     * Kontrollerar att det returnerade landet är Sweden
     */
    @Test
    public void testGetWeather_Country_Exists(){
        when(weatherAPI.getCountry("Stockholm")).thenReturn("Sweden");

        String country= weatherService.getCountry("Stockholm");

        assertEquals("Sweden", country);
    }

    /**
     * GetWeather_Country_NotExists test metoden,
     * ställer in returvärdet null när getCountry anropas med ett land som inte finns
     * Anropar getCountry med ett land som inte finns via weatherService
     * Kontrollerar att det returnerade landet är null
     */
    @Test
    public void testGetWeather_Country_NotExists(){
        when(weatherAPI.getCountry("Land finns inte")).thenReturn(null);

        String country= weatherService.getCountry("Land finns inte");

        assertNull(country);
    }

    /**
     * GetWeather_Cloud test metoden,
     * Ställer in returvärdet 60 när getCloud anropas med platsen Stockholm
     * Anropar getCloud med platsen Stockholm via weatherService
     * Kontrollerar att den returnerade molntäckningen är 60
     * Kontrollerar att molntäckningen är inom intervallet 0-100
     */
    @Test
    public void testGetWeather_Cloud(){
        when(weatherAPI.getCloud("Stockholm")).thenReturn(60.0);

        double cloud= weatherService.getCloud("Stockholm");

        assertEquals(60.0, cloud, 0.01);
        assertTrue(cloud>=0 && cloud <=100);
    }
}


