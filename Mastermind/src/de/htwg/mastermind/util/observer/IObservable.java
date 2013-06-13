package de.htwg.mastermind.util.observer;

import java.util.ArrayList;
import java.util.List;

public interface IObservable {
	List<Observer> subscribers = new ArrayList<Observer>(2);

	public void addObserver(Observer s);

	public void removeObserver(Observer s);
	
	public void removeAllObservers();
	
	public void notifyObservers();
}
