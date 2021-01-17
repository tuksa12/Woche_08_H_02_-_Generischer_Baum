package pgdp.tree;

import javax.swing.text.Segment;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
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
//        }else if (){
//
//        }else{
//
//        }
//        return true;
//    }


    private abstract class TreeNode<S,T> extends Tree {
        final S segment;

        public TreeNode(S segment) {
            super(super.comparator);
            this.segment = segment;
        }

        public S getSegment() {
            return segment;
        }

        private class LeafNode<S,T> extends TreeNode {
            final T value;

            public LeafNode(S segment, T value) {
                super(segment);
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

        private class InnerNode<S> extends TreeNode {
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

            @Override
            public Iterator iterator() {
                return innerNodeChildren.iterator();
            }

            private class RootNode extends InnerNode {
                public RootNode() {
                    super(null);

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

