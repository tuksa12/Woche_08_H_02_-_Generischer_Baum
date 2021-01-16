package pgdp.tree;

import java.util.ArrayList;
import java.util.List;

public interface Segmentable<T> {
    //Implementierungen des Interfaces dürfen nie null oder eine leere Liste zurückgegeben
    // und die Segmente eines Segmentable-Objekts dürfen sich nicht ändern.
    public abstract List<T> getSegments();

}
