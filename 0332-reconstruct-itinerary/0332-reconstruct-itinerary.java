class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            graph.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            graph.get(ticket.get(0)).add(ticket.get(1));
        }
        ArrayList<String> itinerary =new ArrayList<>();
        dfs("JFK", graph, itinerary);
        Collections.reverse(itinerary);
        return itinerary;
    }
    public void dfs(String airport, HashMap<String, PriorityQueue<String>> graph, List<String> itinerary){
        PriorityQueue<String> destinations = graph.get(airport);
        while (destinations != null && !destinations.isEmpty()) {
            // Get the next destination in lexicographical order
            String nextDestination = destinations.poll();
            dfs(nextDestination, graph, itinerary);
        }
        itinerary.add(airport);
    }
}