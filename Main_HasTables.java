public class Main_HasTables {
    public static void main(String[] args) {
        Quadratic<String, Integer> quadraticProbingHashTable = new Quadratic<>();
        quadraticProbingHashTable.put("A", 4);
        quadraticProbingHashTable.put("B", 5);
        quadraticProbingHashTable.put("C", 6);

        System.out.println(quadraticProbingHashTable.get("A"));
        System.out.println(quadraticProbingHashTable.get("B"));
        System.out.println(quadraticProbingHashTable.get("C"));
        System.out.println(quadraticProbingHashTable.get("D"));

        quadraticProbingHashTable.remove("B");

        System.out.println(quadraticProbingHashTable.get("B"));

        System.out.println(quadraticProbingHashTable.size());
    }
}
