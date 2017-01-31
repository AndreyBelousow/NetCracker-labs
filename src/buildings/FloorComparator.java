package buildings;

import java.util.Comparator;

/**
 * Created by 1 on 06.12.2016.
 */
public class FloorComparator implements Comparator<Floor> {
    @Override
    public int compare(Floor o1, Floor o2) {
        if (o1.equals(o2)) {
            return 0;
        }
        if (o2.getTotalArea() <  o2.getTotalArea())
            return 1;
        return -1;
    }
}
