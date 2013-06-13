package de.htwg.mastermind.util.observer;


import java.util.*;

public class Observable  implements IObservable{

	private List<Observer> subscribers = new ArrayList<Observer>(2);

	public void addObserver(Observer s) {
		subscribers.add(s);
	}

	public void removeObserver(Observer s) {
		subscribers.remove(s);
	}
	
	public void removeAllObservers() {
		subscribers.clear();
	}
	
	public void notifyObservers() {
		for ( Iterator<Observer> iter = subscribers.iterator(); iter.hasNext();) {
			Observer observer = iter.next();
			observer.update();
		}
	}
}
