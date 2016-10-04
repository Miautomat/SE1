package se1app.applicationcore;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = Application.class)
public class CustomerRepositoryTest {

	@Autowired
	private CustomerRepository customerRepository;

	@Before
	public void setup() {
		Customer stefan = new Customer("Stefan");
		customerRepository.save(stefan);
	}

	@Test
	public void testFindAll(){
		List<Customer> customers = customerRepository.findAll();
		assertThat(customers).hasSize(1);
	}

	@Test
	public void testFindByName(){
		Optional<Customer> customer = customerRepository.findByName("Stefan");
		assertThat(customer.isPresent());
		assertThat(customer.get().getName().equals("Stefan"));
	}
}
