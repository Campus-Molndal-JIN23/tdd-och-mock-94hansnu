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
     * getTemperature test metoden,
     * Ställer in returvärdet 25 när getTemperature anropas med platsen Stockholm
     * Anropar getTemperatur med platsen Stockholm via mockade weatherAPI
     * Kontrollerar att temperaturen är 25.0
     */
    @Test
    public void testGetTemperature() {
        when(weatherAPI.getTemperatur("Stockholm")).thenReturn(25.0);

        double temperature= weatherAPI.getTemperatur("Stockholm");

        assertEquals(25.0, temperature, 0.01);
    }

    /**
     * getWindSpeed test metoden,
     * Ställer in returvärdet 10.5 när getWindSpeed anropas med platsen Stockholm
     * Anropar getWindSpeed med platsen Stockholm via WeatherService
     * Kontrollerar att vindhastigheten är 10.5
     * Kontrollerar att vindhastigheten är större än 0
     * Kontrollerar att vindhastigheten inte är null
     */

    @Test
    public void testGetWindSpeed(){
        when(weatherAPI.getWindSpeed("Stockholm")).thenReturn(10.5);

        double windSpeed= weatherService.getWindSpeed("Stockholm");

        assertEquals(10.5, windSpeed, 0.01);
        assertTrue(windSpeed > 0);
        assertNotNull(windSpeed);
    }

    /**
     * getCity test metoden,
     * Ställer in returvärdet Stockholm när getCity anropas med platsen Stockholm
     * Anropar getCity med platsen Stockholm via WeatherService
     * Kontrollerar att staden är Stockholm
     */

    @Test
    public void testGetCity(){
        when(weatherAPI.getCity("Stockholm")).thenReturn("Stockholm");

        String city= weatherService.getCity("Stockholm");

        assertEquals("Stockholm", city);
    }

    /**
     * getCountry test metoden,
     * Ställer in returvärdet Sweden när getCountry anropas med platsen Stockholm
     * Anropar getCountry med platsen Stockholm via WeatherService
     * Kontrollerar att landet är Sweden
     */
    @Test
    public void testGetCountry(){
        when(weatherAPI.getCountry("Stockholm")).thenReturn("Sweden");

        String country= weatherService.getCountry("Stockholm");

        assertEquals("Sweden", country);
    }
}
