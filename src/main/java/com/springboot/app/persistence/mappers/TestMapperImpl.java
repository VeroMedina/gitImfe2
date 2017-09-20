package com.springboot.app.persistence.mappers;

import com.springboot.app.persistence.models.TestModel;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class TestMapperImpl implements TestMapper {

  @Override
  public List<TestModel> testMapper(TestModel obj) throws Exception {

    return null;
  }

}
