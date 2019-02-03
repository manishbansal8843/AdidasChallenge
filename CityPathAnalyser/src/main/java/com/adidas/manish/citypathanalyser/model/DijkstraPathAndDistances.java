package com.adidas.manish.citypathanalyser.model;

public class DijkstraPathAndDistances{
	private long[] distances;
	private int[] parents;
	public DijkstraPathAndDistances(long[] distances,int[] parents){
		this.distances=distances;
		this.parents=parents;
	}
	public long[] getDistances() {
		return distances;
	}
	public void setDistances(long[] distances) {
		this.distances = distances;
	}
	public int[] getParents() {
		return parents;
	}
	public void setParents(int[] parents) {
		this.parents = parents;
	}
	
	
}
