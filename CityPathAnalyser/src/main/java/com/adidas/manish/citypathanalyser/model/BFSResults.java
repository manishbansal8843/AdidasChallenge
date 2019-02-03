package com.adidas.manish.citypathanalyser.model;

import java.util.Arrays;

public class BFSResults {
	int[] parents;
	long[] distances;
	public int[] getParents() {
		return parents;
	}
	public void setParents(int[] parents) {
		this.parents = parents;
	}
	public long[] getDistances() {
		return distances;
	}
	public void setDistances(long[] distances) {
		this.distances = distances;
	}
	@Override
	public String toString() {
		return "BFSResults [parents=" + Arrays.toString(parents) + ", distances=" + Arrays.toString(distances) + "]";
	}
	public BFSResults(int[] parents, long[] distances) {
		super();
		this.parents = parents;
		this.distances = distances;
	}
	public BFSResults() {
		
	}
}
