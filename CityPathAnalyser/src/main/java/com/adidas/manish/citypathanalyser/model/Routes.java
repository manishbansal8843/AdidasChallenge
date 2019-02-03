package com.adidas.manish.citypathanalyser.model;

public class Routes {
	private String routeType;
	private ShortestRoute route;
	public Routes() {
		
	}
	public Routes(String routeType, ShortestRoute route) {
		super();
		this.routeType = routeType;
		this.route = route;
	}
	public String getRouteType() {
		return routeType;
	}
	public void setRouteType(String routeType) {
		this.routeType = routeType;
	}
	public ShortestRoute getRoute() {
		return route;
	}
	public void setRoute(ShortestRoute route) {
		this.route = route;
	}
	@Override
	public String toString() {
		return "Routes [routeType=" + routeType + ", route=" + route + "]";
	}
	
}
