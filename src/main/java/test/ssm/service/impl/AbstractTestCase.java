package test.ssm.service.impl;

import junit.framework.TestCase;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/9/17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public abstract class AbstractTestCase extends TestCase {
}
