package com.adidas.manish.citypathanalyser.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.adidas.manish.citypathanalyser.exception.DestinationNotReachableException;
import com.adidas.manish.citypathanalyser.model.BFSResults;
import com.adidas.manish.citypathanalyser.model.CityAPIModel;
import com.adidas.manish.citypathanalyser.model.DestinationCities;
import com.adidas.manish.citypathanalyser.model.DijkstraPathAndDistances;
import com.adidas.manish.citypathanalyser.model.Routes;
import com.adidas.manish.citypathanalyser.model.ShortestRoute;

@RestController
@EnableAutoConfiguration
public class FetchShortestRouteController {
	
	@Autowired
	RestTemplate template;
	
	@Autowired
	DiscoveryClient client;
	/*
	HashMap<String,Integer> map=new HashMap<>();
	HashMap<String,List<DestinationCities>> tempMap=new HashMap<>();
	
	long[][] graph;*/
	@GetMapping(value="/getRoutes/{source}/{destination}")
	public ResponseEntity<List<Routes>> getRoutes(@PathVariable String source,@PathVariable String destination) throws DestinationNotReachableException{
		
		HashMap<String,Integer> map=new HashMap<>();
		HashMap<String,List<DestinationCities>> tempMap=new HashMap<>();
		
		long[][] graph;
		int key=0;
		map.put(source, key++);
		//map.put(destination, key++);
		Queue<String> q=new LinkedList<>();
		q.add(source);
		
		while(!q.isEmpty()) {
			source=q.poll();			
			CityAPIModel model=getCityAPIModel(source);		
			List<DestinationCities> list=model.getCities();
			if(list==null || list.isEmpty()) {
				System.out.println("No routes defined for source="+source);
				continue;
			}
			tempMap.put(source, list);
			Iterator<DestinationCities> itr=list.iterator();
			while(itr.hasNext()) {
				String dest=itr.next().getDestinationCity();
				if(!map.containsKey(dest)){
					q.add(dest);
					map.put(dest, key++);
				}
			}						
		}
		System.out.println("Map for cities:"+map);
		System.out.println("tempmap:"+tempMap);
		if(!map.containsKey(destination)) {
			//return new ResponseEntity<>("Destination is not reachable from source.",HttpStatus.BAD_REQUEST);
			throw new DestinationNotReachableException("Destination '"+destination+"' is not reachable from source '"+source+"'");
		}
		graph=new long[key][key];
		buildGraph(graph,map,tempMap);
		//System.out.println("graph built:"+graph);
		DijkstraPathAndDistances pathAndDist= DijkstrasAlgorithm.dijkstra(graph, 0,map.get(destination));
		BFSResults res=BFSAlgorithm.minEdgeBFS(graph, 0,map.get(destination), key);
		Routes shortRoute=new Routes("SHORTEST", ShortestRoute.valueOf(pathAndDist, map, destination));
		Routes minConnRoute=new Routes("MINIMUM_CONNECTIONS", ShortestRoute.valueOf(res, map, destination));
		List<Routes> obj= new ArrayList<>();
		obj.add(minConnRoute);
		obj.add(shortRoute);
		//System.out.println("model:"+model);
		ResponseEntity<List<Routes>> entity=new ResponseEntity<>(obj,HttpStatus.OK);
		return entity;
	}
	
	private void buildGraph(long[][] graph, HashMap<String, Integer> map, HashMap<String, List<DestinationCities>> tempMap) {
		//System.out.println("building graph with length:"+graph.length);
		try {
			
		Set<Map.Entry<String, List<DestinationCities>>> entries=tempMap.entrySet();
		for(Map.Entry<String, List<DestinationCities>> entry:entries) {
			String key=entry.getKey();
			List<DestinationCities> vals=entry.getValue();
			//System.out.println("iterating key:"+key+"\nval:"+vals);

			for(DestinationCities city:vals) {
				//System.out.println("iterating city:"+city+"\n-- "+map.get(key)+"\n-- "+map.get(city.getDestinationCity()));
				graph[map.get(key)][map.get(city.getDestinationCity())]=city.getTimeDurationMinutes();
				//System.out.println("graph:"+graph);
			}
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	private CityAPIModel getCityAPIModel(String source) {
		//ServiceInstance ins=this.client.getInstances("CITYAPI").get(0);
		//System.out.println("uri:"+ins.getUri());
		System.out.println("====Sending request for source="+source+"======");
		HttpEntity<String> request = new HttpEntity<String>(getHeaders());
		//return new RestTemplate().getForObject(ins.getUri()+"/cityAPI/getDetinationCities/"+source,CityAPIModel.class);
		//return template.getForObject("http://CITYAPI"+"/CityAPI/api/getDetinationCities/"+source,CityAPIModel.class);
		return template.exchange("http://CITYAPI"+"/CityAPI/api/getDetinationCities/"+source,HttpMethod.GET,request,CityAPIModel.class).getBody();

	}
	 private static HttpHeaders getHeaders(){
	        String plainCredentials="adidas:adidas";
	        String base64Credentials = new String(Base64.encodeBase64(plainCredentials.getBytes()));
	         
	        HttpHeaders headers = new HttpHeaders();
	        headers.add("Authorization", "Basic " + base64Credentials);
	        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	        return headers;
	    }
}
