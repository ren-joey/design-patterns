package topic2_observer.implementations;

import topic2_observer.interfaces.Observer;
import topic2_observer.interfaces.Subject;

import java.util.ArrayList;

public class WeatherData implements Subject {
    private final ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList<Observer>();
    }

    // When an observer registers, it will be added to the list of observers
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    // When an observer removes itself, it will be removed from the list of observers
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    // When the Subject calls notifyObservers(), it will pass the updated data
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }

    // When the data is updated, the Subject will call notifyObservers()
    public void measurementsChanged() {
        notifyObservers();
    }

    // This method is called to update the data
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
