# Heap problem identification

## Identification
- Two words together: **k** + **smallest / largest / closest / frequent / top**
- The naive solution is "sort, then take k" → O(n log n). We only need k of them → heap of size k → O(n log k)

## The one idea — the bouncer
- The heap is a **VIP room that holds exactly k people**
- The element on top is NOT the best. It is the **worst person currently inside** = the bouncer
- A newcomer walks in (`add`). If the room now has k+1, the bouncer kicks out the worst (`poll`). That might be the newcomer.
- So: *who should be kicked out?* → that is who sits on top → that decides the heap type

```
want k SMALLEST  → worst insider is the LARGEST  → MAX heap
want k LARGEST   → worst insider is the SMALLEST → MIN heap
```
**Opposite heap of what you want.**

- Kth smallest = max heap of size k, answer is `peek()`. The bouncer IS the kth smallest, because k-1 people inside are smaller than him.

## General format
```java
PriorityQueue<T> heap = new PriorityQueue<>(comparator);   // (1) opposite of what you want

for (each element e) {
    heap.add(e);                                            // (2) walk in
    if (heap.size() > k) heap.poll();                       // (3) bouncer evicts the worst
}
// heap now holds exactly the k you want. heap.peek() is the kth
```

### Holes to fill per problem
| Hole | What varies | Example |
|---|---|---|
| (1) comparator | what "worst" means | KClosestNumbers compares by `diff`, not by value |
| what is stored | plain int, or a `Pair` = sort key + payload | `Point(dist, x, y)`, `Map.Entry<num, count>` |
| pre-step | sometimes build a frequency map first | TopKFrequent, FrequencySort |
| post-step | `peek()` for kth, drain for all k, or keep polling (greedy) | ConnectRopes drains and re-adds |

### Two shapes that are NOT the k-sized bouncer
- **ConnectRopes** → greedy. Heap holds *everything*. Repeatedly take two smallest, put the sum back.
  Heap is used because "give me the current min, repeatedly, while the set keeps changing" is what a heap is for.
  Same shape: Huffman coding, merge k sorted lists.
- **KSortedArray** → bouncer, but each eviction is *placed* into the output instead of thrown away.
  Why it works: the true smallest is guaranteed within the next k elements, so once k+1 are in the room the smallest inside is final.

## Java notes
- `PriorityQueue` is a **min heap by default**
- Max heap: `new PriorityQueue<>(Comparator.reverseOrder())` or `(a, b) -> Integer.compare(b, a)`
- Never `a - b` in a comparator → overflow. Use `Integer.compare(a, b)`
- Iterating a PriorityQueue does NOT give sorted order. Only `poll()` does
- `poll()` returns null when empty, `remove()` throws

## Revision order (easiest → hardest)
1. KthSmallest — pure template
2. KSortedArray — bouncer that places evictions
3. KClosestNumbers — comparator on a derived key (Pair)
4. TopKFrequentNumbers — map pre-step
5. FrequencySort — TODO redo with heap (old code uses Collections.sort). k = map size, bouncer never fires
6. KClosestPointsToOrigin — same as 3 with a 2D key
7. ConnectRopeToMinimiseCost — greedy shape
8. SumBetweenK1K2Smallest — TODO from 2020 still open