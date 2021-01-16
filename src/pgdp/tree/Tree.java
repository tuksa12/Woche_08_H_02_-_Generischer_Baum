package pgdp.tree;

import javax.swing.text.Segment;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class Tree<S, T extends Segmentable<S>> implements Iterable<T> {
    final Comparator<S> comparator;


    public Tree(Comparator<S> comparator) {
        this.comparator = comparator;
    }

    boolean add(T value){
        if(value == null){
            return false;
//        }else if (){

        }else{

        }
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public T next() {
                return null;
            }
        };
    }

    private abstract class TreeNode {
        final S segment;

        public TreeNode(S segment) {
            this.segment = segment;
        }

        public S getsegment() {
            return segment;
        }

        private class LeafNode {
            final S treeNode;
            final T value;

            public LeafNode(S treeNode, T value) {
                this.treeNode = treeNode;
                this.value = value;
            }

            public S getTreeNode() {
                return treeNode;
            }

            public T getValue() {
                return value;
            }
        }

        private class InnerNode{
            S treeNode;
            final ArrayList innerNodeChildren = new ArrayList();
            final ArrayList leafNodeChildren = new ArrayList();

            public InnerNode(S s) {
                this.treeNode = s;
            }

            private class RootNode{
                S segment = null;

            }
        }
    }


}
