package com.dkatalis.pathfinder;

import com.dkatalis.pathfinder.model.Edge;
import com.dkatalis.pathfinder.model.Vertex;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public interface IOptimalPathFinder {

    Map<Vertex, Integer> getDistance();
    LinkedList<Vertex> getPath(Vertex target);
    void execute(Vertex sourceVertex);
    List<Edge> getEdges();
}
