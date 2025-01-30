class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // StringBuilder to construct the result
        StringBuilder result = new StringBuilder();

        // Append characters from order based on their frequency
        for (char c : order.toCharArray()) {
            if (frequencyMap.containsKey(c)) {
                int count = frequencyMap.get(c);
                for (int i = 0; i < count; i++) {
                    result.append(c);
                }
                frequencyMap.remove(c); // Remove the character after processing
            }
        }

        // Append remaining characters that were not in order
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                result.append(c);
            }
        }

        return result.toString();
    }
}