package model;

import java.util.ArrayList;

public class PetriNetwork {
	private ArrayList<Place> places;
	private ArrayList<Transition> transitions;
	private ArrayList<Arc> arcs;

	public PetriNetwork() {

	}

	public boolean EOF() {
		return false;
	}

	public void printCurrentCycle(int cycleNumber) {

	}

	public ArrayList<Place> getPlaces() {
		return places;
	}

	public void setPlaces(ArrayList<Place> places) {
		this.places = places;
	}

	public ArrayList<Transition> getTransitions() {
		return transitions;
	}

	public void setTransitions(ArrayList<Transition> transitions) {
		this.transitions = transitions;
	}

	public ArrayList<Arc> getArcs() {
		return arcs;
	}

	public void setArcs(ArrayList<Arc> arcs) {
		this.arcs = arcs;
	}

}