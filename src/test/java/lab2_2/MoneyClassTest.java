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
		String expected = "10,00 z³";
		assertThat(money.toString(), is(equalTo(expected)));
	}
	
	@Test
	public void moneyMaxIntegerValue() {
		Money money = new Money(Integer.MAX_VALUE);
		String expected = Integer.toString(Integer.MAX_VALUE)+",00 EUR";
		assertThat(money.toString(), is(equalTo(expected)));
	}
	
	@Test
	public void moneyMinIntegerValue() {
		Money money = new Money(Integer.MIN_VALUE);
		String expected = Integer.toString(Integer.MIN_VALUE)+",00 EUR";
		assertThat(money.toString(), is(equalTo(expected)));
	}
	
	

}
