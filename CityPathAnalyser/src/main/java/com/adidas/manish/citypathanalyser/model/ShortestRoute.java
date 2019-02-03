package com.adidas.manish.citypathanalyser.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


public class ShortestRoute {
	private List<String> route;
	private long duration;;
	private int connections;
	
	public List<String> getRoute() {
		return route;
	}
	public void setRoute(List<String> route) {
		this.route = route;
	}
	
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}
	public int getConnections() {
		return connections;
	}
	public void setConnections(int connections) {
		this.connections = connections;
	}
	@Override
	public String toString() {
		return "ShortestRoute [route=" + route + ", duration=" + duration
				+ ", connections=" + connections + "]";
	}
	public ShortestRoute(List<String> route, long duration, int connections) {
		super();		
		this.route = route;
		this.duration = duration;
		this.connections = connections;
	}
	
	public static ShortestRoute valueOf(DijkstraPathAndDistances dpd,HashMap<String,Integer> map,String destination) {
		long[] distances=dpd.getDistances();
		int[] parents=dpd.getParents();
		ShortestRoute route=new ShortestRoute();
		route.generateRoute(parents, map.get(destination), map);
		route.setDuration(distances[map.get(destination)]);
		route.setConnections(route.getRoute().size()-2);
		return route;
	}
	public ShortestRoute() {
		
	}
	
	public void generateRoute(int[] parents,int dest,HashMap<String,Integer> map) {
		route=new ArrayList<String>();
		int tempDest=dest;
		route.add(getKeysByValue(map,dest).get(0));
		while(parents[tempDest]!=-1) {
			route.add(getKeysByValue(map,parents[tempDest]).get(0));
			tempDest=parents[tempDest];
		}
		//route.add(getKeysByValue(map,0).get(0));
		Collections.reverse(route);
	}
	
	public static <T, E> List<T> getKeysByValue(Map<T, E> map, E value) {
	    return map.entrySet()
	              .stream()
	              .filter(entry -> Objects.equals(entry.getValue(), value))
	              .map(Map.Entry::getKey)
	              .collect(Collectors.toList());
	    

	    
	}
	public static ShortestRoute valueOf(BFSResults res, HashMap<String, Integer> map, String destination) {
		long[] distances=res.getDistances();
		int[] parents=res.getParents();
		ShortestRoute route=new ShortestRoute();
		route.generateRoute(parents, map.get(destination), map);
		route.setDuration(distances[map.get(destination)]);
		route.setConnections(route.getRoute().size()-2);
		return route;
	}
	
}
