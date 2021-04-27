package hystrix;

import com.hansin.order.ScOrderApplication;
import com.hansin.order.iservice.IscOrderService;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @Description
 * @Author Hans
 * @Date 16:42 2020/3/2
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ScOrderApplication.class)
@WebAppConfiguration
public class HystrixTest {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Rule
    public ContiPerfRule contiPerfRule = new ContiPerfRule();

    @Autowired
    IscOrderService iscOrderService;

    /**
     * @description 并发测试接口:
     * invocation 调用，threads线程数
     */
    @Test
    @PerfTest(invocations = 11,threads = 11)
    public void hystrixIsolation(){
        logger.info(Thread.currentThread().getName()+"->"+iscOrderService.createOrder());
    }

    @Value("${password}")
    private String password;

    @Test
    public void testProperty(){
        System.out.println(password);
    }
}
