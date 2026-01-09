# Subtree with All Deepest Nodes 

## Problem Statement
Given the `root` of a binary tree, return **the smallest subtree that contains all the deepest nodes**.

A **deepest node** is a node that is at the maximum depth from the root.  
The returned subtree must include **all** such deepest nodes.

---

## Approach (DFS + Height Tracking)

We use **Depth-First Search (DFS)** and return two values from each subtree:

- **Depth** of the deepest node in that subtree
- **Node** that represents the root of the smallest subtree containing all deepest nodes

To achieve this, we define a custom `Pair` class:
- `first` → depth
- `second` → subtree root

---

## Algorithm Explanation

For each node:
1. Recursively compute results for the **left** and **right** subtrees.
2. Compare their depths:
   - If left depth > right depth → propagate left result
   - If right depth > left depth → propagate right result
   - If both depths are equal → current node is the **lowest common ancestor**
3. Increment depth by 1 at each level.

---

## Key Insight
- When the deepest nodes are **split across left and right subtrees**, the current node becomes the **answer**.
- This ensures the returned subtree is the **smallest possible**.

---

##  Example

```

```
       3
     / \
    5   1
    / \   \
    6   2   8
    / \
    7   4
  
```

````

**Deepest nodes:** `7` and `4`  
**Answer subtree root:** `2`

---

##  Code Implementation (Java)

```java
class Solution {
    static class Pair {
        int first;        // depth
        TreeNode second;  // subtree root

        Pair(int first, TreeNode second) {
            this.first = first;
            this.second = second;
        }
    }

    static public Pair dfs(TreeNode root) {
        if (root == null)
            return new Pair(0, null);

        Pair left = dfs(root.left);
        Pair right = dfs(root.right);

        if (left.first > right.first) {
            return new Pair(left.first + 1, left.second);
        }
        if (right.first > left.first) {
            return new Pair(right.first + 1, right.second);
        }
        return new Pair(left.first + 1, root);
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).second;
    }
}
````

---

## ⏱️ Complexity Analysis

* **Time Complexity:** `O(N)`
  (Each node is visited once)
* **Space Complexity:** `O(H)`
  (Recursive call stack, where `H` is tree height)

---
