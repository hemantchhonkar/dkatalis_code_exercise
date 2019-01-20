package com.dkatalis.pathfinder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.dkatalis.pathfinder.model.Edge;
import com.dkatalis.pathfinder.model.Vertex;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TestOptimalPathFinder {

    private List<Vertex> vertices;
    private List<Edge> edges;
    private final int NUMBER_OF_VERTICES = 6;
    private IOptimalPathFinder pathFinder;


    @Before
    public void setUp() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_VERTICES; i++) {
            Vertex location = new Vertex("Vertex_" + i, "Vertex_" + i);
            vertices.add(location);
        }

        addLane("Edge_0", 0, 1, 2);
        addLane("Edge_1", 0, 2, 2);
        addLane("Edge_2", 1, 3, 3);
        addLane("Edge_3", 1, 5, 5);
        addLane("Edge_4", 2, 5, 3);
        addLane("Edge_5", 3, 5, 7);
        addLane("Edge_6", 3, 4, 3);
        addLane("Edge_7", 4, 5, 5);

        this.pathFinder = new DijkstraAlgorithm(edges);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_dijkstra_algorithm_with_empty_or_null_edge_list(){
        new DijkstraAlgorithm(null);
    }

    @Test
    public void test_dijkstra_algorithm() {

        this.pathFinder.execute(vertices.get(0));
        LinkedList<Vertex> path = this.pathFinder.getPath(vertices.get(5));
        Map<Vertex, Integer> distanceMap = this.pathFinder.getDistance();

        assertNotNull(path);
        assertTrue(path.size() == 3);

        for (Vertex vertex : path) {
            System.out.println(vertex + " distance : " + distanceMap.get(vertex));
        }
    }

    private void addLane(String laneId, int sourceLocNo, int destLocNo,
                         int duration) {
        Edge lane = new Edge(laneId, vertices.get(sourceLocNo), vertices.get(destLocNo), duration);
        edges.add(lane);
    }
}