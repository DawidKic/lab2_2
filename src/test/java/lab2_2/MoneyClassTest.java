package lab2_2;

import org.junit.Test;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

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
	
	@Test
	public void moneyMaxDoubleValue() {
		Money money = new Money(Double.MAX_VALUE);
		String expected = new BigDecimal(Double.MAX_VALUE).toPlainString()+",00 EUR";
		assertThat(money.toString(), is(equalTo(expected)));
	}
	
	@Test
	public void moneyMinDoubleValue() {
		Money money = new Money(-Double.MAX_VALUE);
		String expected = new BigDecimal(-Double.MAX_VALUE).toPlainString()+",00 EUR";
		assertThat(money.toString(), is(equalTo(expected)));
	}
	
	@Test
	public void moneyPositiveMultiplier() {
		Money money = new Money(10);
		String expected = "100,00 EUR";
		assertThat(money.multiplyBy(10).toString(), is(equalTo(expected)));
	}
	
	@Test
	public void moneyNegativeMultiplier() {
		Money money = new Money(10);
		String expected = "-100,00 EUR";
		assertThat(money.multiplyBy(-10).toString(), is(equalTo(expected)));
	}
	
	@Test
	public void moneyMaxDoubleMultiplierValue() {
		Money money = new Money(10);
		String expected = new BigDecimal((Double.MAX_VALUE)).toPlainString()+"0,00 EUR";
		assertThat(money.multiplyBy(Double.MAX_VALUE).toString(), is(equalTo(expected)));
	}
	
	@Test
	public void moneyMinDoubleMultiplierValue() {
		Money money = new Money(10);
		String expected = new BigDecimal(-Double.MAX_VALUE).toPlainString()+"0,00 EUR";
		assertThat(money.multiplyBy(-Double.MAX_VALUE).toString(), is(equalTo(expected)));
	}
	
	@Test
	public void moneyAddFunctionSameCurrency() {
		Money money = new Money(10);
		Money money2 = new Money(10);
		String expected = "20,00 EUR";
		Money sum = money.add(money2);
		assertThat(sum.toString(), is(equalTo(expected)));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void moneyAddFunctionDifferentCurrency() {
		Money money = new Money(10, "PLN");
		Money money2 = new Money(10);
		money.add(money2);
	}
	
	@Test
	public void moneySubtractFunctionSameCurrency() {
		Money money = new Money(10);
		Money money2 = new Money(5);
		String expected = "5,00 EUR";
		Money sum = money.subtract(money2);
		assertThat(sum.toString(), is(equalTo(expected)));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void moneySubtractFunctionDifferentCurrency() {
		Money money = new Money(10, "PLN");
		Money money2 = new Money(5);
		money.subtract(money2);
	}
	
	@Test
	public void moneySubtractFunctionSubtractMore() {
		Money money = new Money(10);
		Money money2 = new Money(20);
		String expected = "-10,00 EUR";
		Money sum = money.subtract(money2);
		assertThat(sum.toString(), is(equalTo(expected)));
	}
	
	@Test
	public void moneyMultiplyByDouble() {
		Money money = new Money(10);
		String expected = "5,00 EUR";
		assertThat(money.multiplyBy(0.5).toString(), is(equalTo(expected)));
	}
	

}
