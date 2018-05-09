//-----------------------------------------------------
// Title: BS Tree class
// Author: Tahsin Emre Sen
// Description: This class describes Level Finder
//-----------------------------------------------------

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LevelFinder {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(args[0]);
        Scanner scan = new Scanner(file);
        BSTree bstree = new BSTree();
        AVLTree avltree = new AVLTree();
        while (scan.hasNext()) {
            String str = scan.nextLine();
            bstree.insert(str);
            avltree.insert(str);
        }
        file = new File(args[1]);
        scan = new Scanner(file);
        File file2 = new File(args[2]);
        PrintWriter printer = new PrintWriter(file2);
        while (scan.hasNext()) {
            String str = scan.nextLine();
            if (bstree.getNode(str) != null) {
                double firstTime = System.nanoTime()/1000;
                int bstNodePosition = bstree.position(bstree.getNode(str));
                double endTime = System.nanoTime()/1000;
                double bstTime = (endTime - firstTime);

                firstTime = System.nanoTime()/1000;
                int avlNodePosition = avltree.position(str);
                endTime = System.nanoTime()/1000;
                double avlTime = (endTime - firstTime);

                printer.println(bstNodePosition + " " + avlNodePosition + " " + str);
                System.out.println("Query " + str + " found in " + bstTime + " microseconds in BST, " + avlTime + " microseconds in AVL");
            } else {
                printer.println("0 0 " + str);
                System.out.println("Query " + str + " not found in BST, not found in AVL");
            }
        }
        printer.close();
    }
}

