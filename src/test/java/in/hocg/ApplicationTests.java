package in.hocg;

import in.hocg.web.pojo.domain.Example;
import in.hocg.web.service.ExampleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

  @Autowired
  private ExampleService userService;

	@Test
	public void contextLoads() {
    Example user = new Example();

    user.setName("name");
    userService.insert(user);
	}


}
