package de.htwg.mastermind.util.observer;


public interface IObservable {

	void addObserver(Observer s);

	void removeObserver(Observer s);
	
	void removeAllObservers();
	
	void notifyObservers();
}
