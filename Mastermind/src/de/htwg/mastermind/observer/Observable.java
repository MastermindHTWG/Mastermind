package de.htwg.mastermind.observer;


import java.util.Iterator;
import java.util.Vector;

public class Observable  {

	protected Vector<Observer> subscribers = new Vector<Observer>(2);

	public void addObserver(Observer s) {
		subscribers.addElement(s);
	}

	public void removeObserver(Observer s) {
		subscribers.removeElement(s);
	}

	public void removeAllObservers() {
		subscribers.removeAllElements();
	}

	public void notifyObservers() {
		for ( Iterator<Observer> iter = subscribers.iterator(); iter.hasNext();) {
			Observer observer = iter.next();
			observer.update();
		}
	}
}
