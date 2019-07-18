package pe.feo.config;

import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import pe.feo.config.MyBatisConfig;
import pe.feo.config.TestConfig;

@ContextConfiguration(classes = { TestConfig.class, MyBatisConfig.class })
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseTest {

	@Autowired
	private DataSource dataSource;

	protected static Gson gson;

	@BeforeClass
	public static void setUpBeforesClass() {
		gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
	}

	@Test
	public void dataSourceTest() {
		assertNotNull(dataSource);
	}
}
