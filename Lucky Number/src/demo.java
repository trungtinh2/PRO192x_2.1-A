import java.util.ArrayList;
import java.util.List;

public class demo {

    public static void main(String[] args) {
        List list = new ArrayList();

        list.add(10);
        list.add(10);

        System.out.print(list.size());

        list.remove(new Integer(10));

        System.out.print(list.size());
    }
}
