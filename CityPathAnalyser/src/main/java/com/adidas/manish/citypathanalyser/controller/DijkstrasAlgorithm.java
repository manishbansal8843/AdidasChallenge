package com.adidas.manish.citypathanalyser.controller;

import com.adidas.manish.citypathanalyser.model.DijkstraPathAndDistances;

public class DijkstrasAlgorithm {

	private static final int NO_PARENT = -1;

	public static DijkstraPathAndDistances dijkstra(long[][] adjacencyMatrix, int startVertex, int endVertex) {
		int nVertices = adjacencyMatrix[0].length;

		long[] shortestDistances = new long[nVertices];

		boolean[] added = new boolean[nVertices];

		for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
			shortestDistances[vertexIndex] = Long.MAX_VALUE;
			added[vertexIndex] = false;
		}

		shortestDistances[startVertex] = 0;

		int[] parents = new int[nVertices];

		parents[startVertex] = NO_PARENT;

		for (int i = 1; i < nVertices; i++) {

			int nearestVertex = -1;
			long shortestDistance = Long.MAX_VALUE;
			for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
				if (!added[vertexIndex] && shortestDistances[vertexIndex] < shortestDistance) {
					nearestVertex = vertexIndex;
					shortestDistance = shortestDistances[vertexIndex];
				}
			}

			added[nearestVertex] = true;
			if (nearestVertex == endVertex) {
				return new DijkstraPathAndDistances(shortestDistances, parents);
			}

			for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
				long edgeDistance = adjacencyMatrix[nearestVertex][vertexIndex];

				if (edgeDistance > 0 && ((shortestDistance + edgeDistance) < shortestDistances[vertexIndex])) {
					parents[vertexIndex] = nearestVertex;
					shortestDistances[vertexIndex] = shortestDistance + edgeDistance;
				}
			}
		}

		return new DijkstraPathAndDistances(shortestDistances, parents);
	}

}
