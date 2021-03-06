package ar.edu.unq.tip.marchionnelattenero.services;


import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/WEB-INF/webApplicationContext.xml", "classpath*:config/BeanLocations.xml", "classpath*:database/DataSource.xml", "classpath*:database/Hibernate.xml"})
@Transactional(value = "persistence.transactionManager")
public abstract class AbstractServiceTest {
}
