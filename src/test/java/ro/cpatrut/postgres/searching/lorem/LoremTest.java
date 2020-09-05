package ro.cpatrut.postgres.searching.lorem;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.junit.jupiter.api.Test;

public class LoremTest {

    @Test
    public void succeedOnCreatingLorem(){
        Lorem lorem = LoremIpsum.getInstance();
        String nameMale = lorem.getNameMale();
        System.out.println(nameMale);
    }
}
