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

//    boolean add(T value){
//        if(value == null){
//            return false;
//        }else if (){
//
//        }else{
//
//        }
//        return true;
//    }

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

    private abstract class TreeNode extends Tree{
        final S segment;

        public TreeNode(S segment) {
            super(new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    return 0;
                }
            });
            this.segment = segment;
        }

        public S getSegment() {
            return segment;
        }

        private class LeafNode extends TreeNode {
            final T value;

            public LeafNode(S segment, T value) {
                super(segment);
                this.value = value;

            }

            public T getValue() {
                return value;
            }
        }

        private class InnerNode extends TreeNode {
            final ArrayList innerNodeChildren = new ArrayList();
            final ArrayList leafNodeChildren = new ArrayList();

            public InnerNode(S segment) {
                super(segment);
                innerNodeChildren.add(this);
                leafNodeChildren.add(LeafNode.class);
            }

            public ArrayList getInnerNodeChildren() {
                return innerNodeChildren;
            }

            public ArrayList getLeafNodeChildren() {
                return leafNodeChildren;
            }

            private class RootNode extends InnerNode {
                public RootNode() {
                    super(null);

                }
            }
        }

    }
}
