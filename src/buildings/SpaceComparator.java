package buildings;

import java.util.Comparator;

/**
 * Created by 1 on 06.12.2016.
 */
public class SpaceComparator implements Comparator<Space> {
    @Override
    public int compare(Space o1, Space o2) {
        if (o1.equals(o2)) {
            return 0;
        }
        if (o1.getNumberOfRooms() < (o2.getNumberOfRooms()))
            return 1;
        return -1;
    }
}
