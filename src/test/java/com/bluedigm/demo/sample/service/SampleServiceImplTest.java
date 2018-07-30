package com.bluedigm.demo.sample.service;

import com.bluedigm.demo.api.sample.model.SampleModel;
import com.bluedigm.demo.api.sample.service.SampleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class SampleServiceImplTest {

	@Autowired
	private SampleService service;

	@Test
	public void select() {
		List<SampleModel> select = service.selectSample();

		assertThat(select.size(), is(2));

	}
}
