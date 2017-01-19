package lab2_2;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import pl.com.bottega.ecommerce.sharedkernel.Money;

public class MoneyClassTest {
	
	@Test 
	public void moneyDefaultCurrency() {
		Money money = new Money(10);
		String expected = "10,00 EUR";
		assertThat(money.toString(), is(equalTo(expected)));	
	}
	
	@Test
	public void moneyCustomCurrency() {
		Money money = new Money(10, "PLN");
		String expected = "10,00 z�";
		assertThat(money.toString(), is(equalTo(expected)));
	}

}
