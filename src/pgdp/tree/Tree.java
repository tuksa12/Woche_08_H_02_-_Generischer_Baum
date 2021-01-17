package pgdp.tree;

import javax.swing.text.Segment;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Tree<S, T extends Segmentable<S>> implements Iterable<T> {
    Comparator<S> comparator;
    final Iterator<T> iterator = iterator();


    public Tree(Comparator<S> comparator) {
        this.comparator = comparator;

    }


//    boolean add(T value){
//        if(value == null){
//            return false;
//        }else if (treeNode.leafNode.value == value){
//            return false;
//        }else{
//            treeNode.leafNode = new TreeNode.LeafNode(treeNode.segment, value);
//        }
//        return true;
//    }


    private abstract class TreeNode extends Tree<S,T> {
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

        private  class LeafNode extends TreeNode {
            final S segment;
            final T value;

            public LeafNode(S segment, T value) {
                super(segment);
                this.segment = (S) super.getSegment();
                this.value = value;

            }

            public T getValue() {
                return value;
            }

            @Override
            public Iterator iterator() {
                //iterator.next() = value;
                return iterator;
            }
        }

        private class InnerNode extends TreeNode {
            final S segment;
            final ArrayList innerNodeChildren = new ArrayList();
            final ArrayList leafNodeChildren = new ArrayList();


            public InnerNode(S segment) {
                super(segment);
                this.segment = (S) super.getSegment();
                innerNodeChildren.add(this);
                leafNodeChildren.add(LeafNode.class);
            }

            public ArrayList getInnerNodeChildren() {
                return innerNodeChildren;
            }

            public ArrayList getLeafNodeChildren() {
                return leafNodeChildren;
            }

            @Override
            public Iterator iterator() {
                return innerNodeChildren.iterator();
            }

            private  class RootNode extends InnerNode {
                final S segment;
                public RootNode() {
                    super(null);
                    this.segment = null;

                }
            }
        }

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

    <R> R map(Function<T, R> leafMapper, BiFunction<S, List<R>, R> innerNodeMapper){
        return null;
    }
}

