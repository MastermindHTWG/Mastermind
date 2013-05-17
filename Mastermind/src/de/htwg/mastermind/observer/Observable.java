package de.htwg.mastermind.observer;


import java.util.Iterator;
import java.util.*;

public class Observable  {

	private List<Observer> subscribers = new Vector<Observer>(2);

	public void addObserver(Observer s) {
		subscribers.add(s);
	}

	public void removeObserver(Observer s) {
		subscribers.remove(s);
	}
	public void notifyObservers() {
		for ( Iterator<Observer> iter = subscribers.iterator(); iter.hasNext();) {
			Observer observer = iter.next();
			observer.update();
		}
	}
}
