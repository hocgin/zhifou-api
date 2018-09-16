package in.hocg.web.mapper;

import in.hocg.web.pojo.domain.Example;
import in.hocg.web.pojo.domain.enums.ExampleType;
import in.hocg.web.service.ExampleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExampleMapperTest {
  @Autowired
  private ExampleMapper exampleMapper;
  @Autowired
  private ExampleService exampleService;

  @Test
  public void testFindLike() {
    Collection<Example> list = exampleMapper.findLike("n");
    System.out.println(list);
    Collection<Example> empty = exampleMapper.findLike("xxx");
    System.out.println(empty);
  }


  @Test
  public void testFindByIDs() {
    Collection<Example> examples = exampleMapper.findByIDs("0a85f3fd0ea94e3382703640ffa1a514", "23141a7f86224146958db65e50bd8ccd");
    System.out.println(String.format("Length %d", examples.size()));
  }

  @Test
  public void testInserts() {
    Example example = new Example();
    example.setName(String.valueOf(Math.random()).substring(0, 10));
    example.setType(ExampleType.AliPay);
    exampleMapper.insert(example);
  }

  @Test
  public void testDelete() {
//    Collection<Example> examples = exampleMapper.findByIDs("cc666ad883464c77a17b61502041aaae");
    exampleMapper.deleteById("ea462069ce614955adffc09ac8533c31");
  }

  @Test
  public void testUpdate() {
    Example example = exampleMapper.selectById("8c40e9bf5d4942f7b901aa3caffae272");
    example.setName("sd");
    exampleService.insertOrUpdate(example);
  }
}
