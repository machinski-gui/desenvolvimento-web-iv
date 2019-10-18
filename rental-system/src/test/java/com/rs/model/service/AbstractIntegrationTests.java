package com.rs.model.service;

import java.util.Locale;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rs.api.RentalSystemApplicationTests;
import com.rs.api.TestApplication;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {TestApplication.class ,RentalSystemApplicationTests.class})
public abstract class AbstractIntegrationTests {

	public void beforeTest() {
		Locale.setDefault(new Locale("pt"));
	}
}
