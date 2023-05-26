public class Linear {
    private static final int DEFAULT_CAPACITY = 10;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;
    private final double loadFactor;

    private Entry[] table;
    private int size;
    private int capacity;

    public Linear() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public Linear(int capacity, double loadFactor) {
        this.table = new Entry[capacity];
        this.size = 0;
        this.capacity = capacity;
        this.loadFactor = loadFactor;
    }

    public void put(String key, int value) {
        if (size >= capacity * loadFactor) {
            resize();
        }

        int index = hash(key);

        while (table[index] != null && !table[index].key.equals(key)) {
            index = (index + 1) % capacity;
        }

        if (table[index] == null) {
            table[index] = new Entry(key, value);
            size++;
        } else {
            table[index].value = value;
        }
    }

    public int get(String key) {
        int index = hash(key);

        while (table[index] != null && !table[index].key.equals(key)) {
            index = (index + 1) % capacity;
        }

        if (table[index] != null) {
            return table[index].value;
        }

        return -1;
    }

    public void remove(String key) {
        int index = hash(key);

        while (table[index] != null && !table[index].key.equals(key)) {
            index = (index + 1) % capacity;
        }

        if (table[index] != null) {
            table[index] = null;
            size--;
        }
    }

    public int size() {
        return size;
    }

    private int hash(String key) {
        char firstChar = key.charAt(0);
        return (11 * firstChar) % capacity;
    }

    private void resize() {
        int newCapacity = capacity * 2;
        Entry[] newTable = new Entry[newCapacity];

        for (Entry entry : table) {
            if (entry != null) {
                int index = hash(entry.key);

                while (newTable[index] != null) {
                    index = (index + 1) % newCapacity;
                }

                newTable[index] = entry;
            }
        }

        table = newTable;
        capacity = newCapacity;
    }

    private static class Entry {
        private final String key;
        private int value;

        public Entry(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Linear hashTable = new Linear();
        hashTable.put("E", 5);
        hashTable.put("A", 1);
        hashTable.put("S", 19);
        hashTable.put("Y", 25);
        hashTable.put("Q", 17);
        hashTable.put("U", 21);
        hashTable.put("T", 20);
        hashTable.put("I", 9);
        hashTable.put("O", 15);
        hashTable.put("N", 14);

        System.out.println("Value of the password 'S': " + hashTable.get("S"));
        System.out.println("Value of the password 'O': " + hashTable.get("O"));
        System.out.println("Value of the password 'E': " + hashTable.get("E"));
        System.out.println("Value of the password 'X': " + hashTable.get("X"));

        hashTable.remove("T");

        System.out.println("Size of the hash table: " + hashTable.size());
    }
}
