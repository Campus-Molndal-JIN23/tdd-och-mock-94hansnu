package org.campusmolndal.test;

import org.campusmolndal.weatherService.WeatherAPI;
import org.campusmolndal.weatherService.WeatherService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class WeatherServiceTest {

    @Mock
    private WeatherService weatherService;
    private WeatherAPI weatherAPI;

    @Before
    public void setup(){
        weatherAPI= mock(WeatherAPI.class);
        weatherService = new WeatherService(weatherAPI);
    }

    @Test
    public void testGetTemperature() {
        when(weatherAPI.getTemperatur("Stockholm")).thenReturn(20.0);

        double temperature= weatherAPI.getTemperatur("Stockholm");

        assertEquals(20.0, temperature, 0.01);
    }
}
