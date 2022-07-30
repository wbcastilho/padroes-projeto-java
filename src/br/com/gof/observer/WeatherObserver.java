package br.com.gof.observer;

public interface WeatherObserver {

    void update(WeatherType currentWeather);
}
