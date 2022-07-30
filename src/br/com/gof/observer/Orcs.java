package br.com.gof.observer;

public class Orcs implements WeatherObserver {

    @Override
    public void update(WeatherType currentWeather) {
        System.out.println("The orcs are facing " + currentWeather.getDescription() + " weather now");
    }
}
