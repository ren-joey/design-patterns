package topic2_observer.interfaces;

public interface Observer {
    // When the Subject calls notifyObservers(), it will pass the updated data
    public void update(float temp, float humidity, float pressure);
}
