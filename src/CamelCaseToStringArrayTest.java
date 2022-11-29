import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CamelCaseToStringArrayTest {

	@Test
	public void convertCamelCase_normal() {
		String inputText1 = "nome";
		String inputText2 = "Nome";
		
		List<String> expected = Arrays.asList("nome");
		
		List<String> reality1 = CamelCaseToStringArray.convertCamelCase(inputText1);
		List<String> reality2 = CamelCaseToStringArray.convertCamelCase(inputText2);
		
		assertEquals(expected, reality1);
		assertEquals(expected, reality2);
	}
	
	
	@Test
	public void convertCamelCase_hasUpperCase() {
		String inputText1 = "nomeComposto";
		String inputText2 = "NomeComposto";
		
		List<String> expected = Arrays.asList("nome", "composto");
		
		List<String> reality1 = CamelCaseToStringArray.convertCamelCase(inputText1);
		List<String> reality2 = CamelCaseToStringArray.convertCamelCase(inputText2);
		
		assertEquals(expected, reality1);
		assertEquals(expected, reality2);
	}
	
	@Test
	public void convertCamelCase_allUpperCase() {
		String inputText = "CPF";
		
		List<String> expected = Arrays.asList("CPF");
		List<String> reality = CamelCaseToStringArray.convertCamelCase(inputText);
		
		assertEquals(expected, reality);
	}
	
	@Test
	public void convertCamelCase_partUpperCase() {
		String inputText = "numeroCPF";
		
		List<String> expected = Arrays.asList("numero","CPF");
		List<String> reality = CamelCaseToStringArray.convertCamelCase(inputText);
		
		assertEquals(expected, reality);
	}
	
	@Test
	public void convertCamelCase_mixUpperCase() {
		String inputText = "numeroCPFContribuinte";
		
		List<String> expected = Arrays.asList("numero", "CPF", "contribuinte");
		List<String> reality = CamelCaseToStringArray.convertCamelCase(inputText);
		
		assertEquals(expected, reality);
	}
	
	@Test
	public void convertCamelCase_hasNumber() {
		String inputText = "recupera10Primeiros";
		
		List<String> expected = Arrays.asList("recupera","10","primeiros");
		List<String> reality = CamelCaseToStringArray.convertCamelCase(inputText);
		
		assertEquals(expected, reality);
	}
	
	@Test(expected = StartWithNumberException.class)
	public void convertCamelCase_startNumber() {
		String inputText = "10Primeiros";
		
		CamelCaseToStringArray.convertCamelCase(inputText);

	}
	
	@Test(expected = SpecialCharacterException.class)
	public void convertCamelCase_specialCharacter() {
		String inputText = "nome#Composto";
		
		CamelCaseToStringArray.convertCamelCase(inputText);

	}


}
