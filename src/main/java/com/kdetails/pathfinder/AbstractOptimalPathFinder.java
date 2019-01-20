package com.kdetails.pathfinder;

import com.kdetails.pathfinder.model.Edge;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractOptimalPathFinder implements IOptimalPathFinder {

    private final List<Edge> edges;

    public List<Edge> getEdges() {
        return edges;
    }

    protected AbstractOptimalPathFinder(List<Edge> edges) throws IllegalArgumentException{
        if(edges == null || edges.isEmpty())
            throw new IllegalArgumentException("Empty edges list.");
        // create copy of edges list
        this.edges =  new ArrayList<>(edges);
    }

}
