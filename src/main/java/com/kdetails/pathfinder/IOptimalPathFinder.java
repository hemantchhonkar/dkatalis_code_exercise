package com.kdetails.pathfinder;

import com.kdetails.pathfinder.model.Edge;
import com.kdetails.pathfinder.model.Vertex;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public interface IOptimalPathFinder {

    Map<Vertex, Integer> getDistance();
    LinkedList<Vertex> getPath(Vertex target);
    void execute(Vertex sourceVertex);
    List<Edge> getEdges();
}
