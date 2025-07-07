package pekan9;

import java.util.*;

public class TugasSearchingGraf {
    // Adjacency list untuk merepresentasikan graf
    private Map<String, List<String>> graph = new HashMap<>();

    // Konstruktor untuk membuat graf
    public TugasSearchingGraf() {
        graph.put("A", Arrays.asList("B", "C"));
        graph.put("B", Arrays.asList("A", "D", "E"));
        graph.put("C", Arrays.asList("A", "F"));
        graph.put("D", Arrays.asList("B"));
        graph.put("E", Arrays.asList("B", "F"));
        graph.put("F", Arrays.asList("C", "E", "G"));
        graph.put("G", Arrays.asList("F", "H"));
        graph.put("H", Arrays.asList("G"));
    }

    public void search(String startNode, String goalNode) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Map<String, String> parent = new HashMap<>();
        int langkah = 1;

        queue.add(startNode);
        visited.add(startNode);

        System.out.println("Nama: Ahmad Zahran");
        System.out.println("NIM: 2411532004");
        System.out.println("Node awal: " + startNode);
        System.out.println("Node tujuan: " + goalNode);
        System.out.println("Algoritma: BFS");

        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.println("Langkah " + langkah++ + ": Kunjungi " + current);

            if (current.equals(goalNode)) {
                System.out.println("\nTujuan " + goalNode + " ditemukan\n");
                printRoute(parent, startNode, goalNode);
                return;
            }

            for (String neighbor : graph.getOrDefault(current, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                    parent.put(neighbor, current);
                }
            }
        }

        System.out.println("Node tujuan tidak ditemukan.");
    }

    private void printRoute(Map<String, String> parent, String start, String goal) {
        List<String> path = new ArrayList<>();
        String current = goal;

        while (current != null) {
            path.add(current);
            current = parent.get(current);
        }

        Collections.reverse(path);
        System.out.print("Rute: ");
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i != path.size() - 1) {
                System.out.print(" → ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TugasSearchingGraf graf = new TugasSearchingGraf();
        graf.search("A", "G");
    }
}
