package lab2_2;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;

public class IdEqualsFunctionTestIdIsNotEmpty {
	
Id id = Id.generate();


	@Test
	public void ObjectIsId() {
		Object obj = id;
		Assert.assertThat(id.equals(obj), is(true));
	}
	
	@Test
	public void ObjectIsNotIdIsIdType() {
		Id obj;
		do
		{
		obj = Id.generate();
		}
		while(obj==id);
		Assert.assertThat(id.equals(obj), is(false));
	}
	
	

}
