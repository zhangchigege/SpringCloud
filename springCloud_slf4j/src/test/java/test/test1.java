package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
public class test1 {

    @Test
    public void testSlf4j(){
        Logger logger = LoggerFactory.getLogger(Object.class);

    }



}
