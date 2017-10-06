package Patrones;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import Patrones.Builder.AuthorTest;
import Patrones.Builder.BookTest;
import Patrones.Composite.BookCompositeTest;
import Patrones.Factory.BookFactoryTest;
import Patrones.Strategy.ArchivoTest;

@RunWith(Suite.class)
@SuiteClasses({
    AuthorTest.class,
    BookTest.class,
    BookCompositeTest.class,
    BookFactoryTest.class,
    ArchivoTest.class
})
public class AllPatronesTests {

}
