//-----------------------------------------------------
// Title: BS Tree class
// Author: Tahsin Emre Sen
//-----------------------------------------------------
class BstNode {
    public String value;
    public BstNode left;
    public BstNode right;
    public int N;
    public BstNode(String value, int N) {
        this.value = value;
        this.N = N;
    }
}
public class BSTree {
    private BstNode root;

    public BstNode getNode(String value) {
        BstNode x = root;
        while(x != null) {
            int rwby = value.compareToIgnoreCase(x.value);
            if (rwby < 0) {
                x = x.left;
            }
            else if (rwby > 0) {
                x = x.right;
            }
            else {
                return x;
            }
        }
        return null;
    }

    public void insert(String value) {
        root = insert(root, value);
    }

    private BstNode insert(BstNode x, String value) {
        if (x == null) {
            return new BstNode(value, 1);
        }
        int rwby = value.compareToIgnoreCase(x.value);
        if (rwby < 0) {
            x.left = insert(x.left, value);
        }
        else if (rwby > 0) {
            x.right = insert(x.right, value);
        }
        else {
            x.value = value;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    private int size(BstNode x) {
        if (x == null) {
            return 0;
        }
        else {
            return x.N;
        }
    }
    public int position(BstNode n) {
        BstNode r = root;
        int count = 1;
        while(r != n && r != null){
            if(n.value.compareToIgnoreCase(r.value) < 0) {
                r = r.left;
                count++;
            }
            else if(n.value.compareToIgnoreCase(r.value) > 0) {
                r = r.right;
                count++;
            }
        }
        return count;
    }

}


