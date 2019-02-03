package com.adidas.manish.citypathanalyser.controller;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;
import com.adidas.manish.citypathanalyser.model.BFSResults;

public class BFSAlgorithm {

	static BFSResults minEdgeBFS(long edges[][], int u,

			int v, int n)

	{
		Vector<Boolean> visited = new Vector<Boolean>(n);
		int[] parents = new int[n];
		parents[u] = -1;

		for (int i = 0; i < n; i++) {
			visited.addElement(false);
		}

		long[] distances = new long[n];
		Queue<Integer> Q = new LinkedList<>();
		distances[u] = 0L;
		Q.add(u);
		visited.setElementAt(true, u);
		while (!Q.isEmpty())
		{
			int x = Q.peek();
			Q.poll();
			for (int i = 0; i < edges[x].length; i++)
			{
				if (edges[x][i] == 0)
					continue;
				if (visited.elementAt(i))
					continue;
				distances[i] = distances[x] + edges[x][i];
				parents[i] = x;
				Q.add(i);
				visited.setElementAt(true, i);
			}
		}
		BFSResults results = new BFSResults(parents, distances);
		return results;
	}

}
