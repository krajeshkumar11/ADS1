import java.util.*;
public class Solution<Key> {
    private Key[] pq;                    // store items at indices 1 to n
    private int n;                       // number of items on priority queue
    private Comparator<Key> comparator;  // optional comparator

    /**
     * Initializes a priority queue from the array of keys.
     * <p>
     * Takes time proportional to the number of keys, using sink-based heap construction.
     *
     * @param  keys the array of keys
     */
    public Solution(Key[] keys) {
        n = keys.length;
        pq = (Key[]) new Object[keys.length + 1];
        for (int i = 0; i < n; i++)
            pq[i+1] = keys[i];
        // for (int k = n/2; k >= 1; k--)
        //     sink(k);
        // assert isMinHeap();
    }

    /**
     * Returns true if this priority queue is empty.
     *
     * @return {@code true} if this priority queue is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Returns the number of keys on this priority queue.
     *
     * @return the number of keys on this priority queue
     */
    public int size() {
        return n;
    }

    /**
     * Returns a smallest key on this priority queue.
     *
     * @return a smallest key on this priority queue
     * @throws NoSuchElementException if this priority queue is empty
     */
    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        return pq[1];
    }

    // helper function to double the size of the heap array
    private void resize(int capacity) {
        assert capacity > n;
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    /**
     * Adds a new key to this priority queue.
     *
     * @param  x the key to add to this priority queue
     */
    public void insert(Key x) {
        // double size of array if necessary
        if (n == pq.length - 1) resize(2 * pq.length);

        // add x, and percolate it up to maintain heap invariant
        pq[++n] = x;
        swim(n);
        // assert isMinHeap();
    }

    /**
     * Removes and returns a smallest key on this priority queue.
     *
     * @return a smallest key on this priority queue
     * @throws NoSuchElementException if this priority queue is empty
     */
    public Key delMin() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        Key min = pq[1];
        exch(1, n--);
        sink(1);
        pq[n+1] = null;     // to avoid loiterig and help with garbage collection
        if ((n > 0) && (n == (pq.length - 1) / 4)) resize(pq.length / 2);
        // assert isMinHeap();
        return min;
    }


   /***************************************************************************
    * Helper functions to restore the heap invariant.
    ***************************************************************************/

    private void swim(int k) {
        while (k > 1 && greater(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

   /***************************************************************************
    * Helper functions for compares and swaps.
    ***************************************************************************/
    private boolean greater(int i, int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
        }
        else {
            return comparator.compare(pq[i], pq[j]) > 0;
        }
    }

    private void exch(int i, int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    // is pq[1..N] a min heap?
    public boolean isMinHeap() {
        return isMinHeap(1);
    }

    // is subtree of pq[1..n] rooted at k a min heap?
    private boolean isMinHeap(int k) {
        if (k > n) return true;
        int left = 2*k;
        int right = 2*k + 1;
        if (left  <= n && greater(k, left))  return false;
        if (right <= n && greater(k, right)) return false;
        return isMinHeap(left) && isMinHeap(right);
    }

    /**
     * Unit tests the {@code Solution} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        // String[] data = {"S", "O", "R", "T", "I", "N", "G", "E", "X", "A", "M", "P", "L", "E"};
        Scanner sc = new Scanner(System.in);
        String type = sc.nextLine();
        int n = sc.nextInt();
        sc.nextLine();
        while(n > 0) {
            String data = sc.nextLine();
            if(data.equals("")) {
                System.out.println(false);
            } else {
                String[] input = data.split(",");
                if(type.equals("String")) {
                    Solution<String> pq = new Solution<String>(input);
                    System.out.println(pq.isMinHeap());
                } else if(type.equals("Integer")) {
                    Integer[] newinput = new Integer[input.length];
                    for (int i = 0; i < newinput.length; i++) {
                        newinput[i] = Integer.parseInt(input[i]);
                    }
                    Solution<Integer> pq = new Solution<Integer>(newinput);
                    System.out.println(pq.isMinHeap());
                } else if(type.equals("Double")) {
                    Double[] newinput = new Double[input.length];
                    for (int i = 0; i < newinput.length; i++) {
                        newinput[i] = Double.parseDouble(input[i]);
                    }
                    Solution<Double> pq = new Solution<Double>(newinput);
                    System.out.println(pq.isMinHeap());
                } else if(type.equals("Float")) {
                    Float[] newinput = new Float[input.length];
                    for (int i = 0; i < newinput.length; i++) {
                        newinput[i] = Float.parseFloat(input[i]);
                    }
                    Solution<Float> pq = new Solution<Float>(newinput);
                    System.out.println(pq.isMinHeap());
                }
            }
            n--;
        }
    }
}
