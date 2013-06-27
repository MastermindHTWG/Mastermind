package de.htwg.mastermind.util.observer;


public interface IObservable {
	
	/*
	 * @param s: s add to observ 
	 */
	void addObserver(Observer s);

	void removeObserver(Observer s);
	
	void removeAllObservers();
	
	void notifyObservers();
}
