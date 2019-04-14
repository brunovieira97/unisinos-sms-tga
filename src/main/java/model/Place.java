package model;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Place implements NetworkNode {
	private int tokenCount;
	private String name;
	private List<Arc> outputArcs;
	private Arc destination;

	public Place() {

	}

	public Place(int tokenCount, String name) {
		this.tokenCount = tokenCount;
		this.name = name;
	}

	public Place(int tokenCount, String name, List<Arc> outputArcs) {
		this(tokenCount, name);

		this.outputArcs = outputArcs;
	}

	/**
	 * ! CAUTION: I was probably creating circular references between Arcs and Places around here
	 */
	public boolean canFire() {
		return true;
	}

	/**
	 * * This is the random sorting requested by the Professor
	 * TODO: Find where to call this thing
	 */
	private Arc defineRandomDestination() {
		int randomIndex = 0;

		randomIndex = ThreadLocalRandom.current().nextInt(0, this.getoutputArcs().size() + 1);

		return this.getoutputArcs().get(randomIndex);
	}

	public void addTokens(int tokenCount) {
		this.tokenCount += tokenCount;
	}

	public void removeTokens(int tokenCount) {
		this.tokenCount -= tokenCount;
	}

	public void setTokenCount(int tokenCount) {
		this.tokenCount = tokenCount;
	}

	public int getTokenCount() {
		return this.tokenCount;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setoutputArcs(List<Arc> outputArcs) {
		this.outputArcs = outputArcs;
	}

	public List<Arc> getoutputArcs() {
		return this.outputArcs;
	}
}