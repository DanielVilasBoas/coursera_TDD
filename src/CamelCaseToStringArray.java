import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CamelCaseToStringArray {

	public static final String NUMBER_REGEX = "^[0-9]+";
	public static final String NO_SPECIAL_CHARACTER_REGEX = "(\\w)*";
	public static final String REGEX = "(?<!(^|[A-Z0-9]))(?=[A-Z0-9])|(?<!(^|[^A-Z]))(?=[0-9])|(?<!(^|[^0-9]))(?=[A-Za-z])|(?<!^)(?=[A-Z][a-z])";

	public static List<String> convertCamelCase(String original) {

		String[] palavras = original.split(REGEX);

		if (allUpperCase(original)) {
			return Arrays.asList(original);
		} else {
			List<String> wordList = convertToLowerCase(Arrays.asList(palavras));
			startWithNumber(wordList);
			specialCharacter(original);
			return wordList;
		}
	}

	public static List<String> convertToLowerCase(List<String> palavras) {
		List<String> wordList = new ArrayList<>();

		for (String letter : palavras) {
			if (allUpperCase(letter)) {
				wordList.add(letter);
			} else {
				wordList.add(letter.toLowerCase());
			}
		}
		return wordList;
	}

	public static boolean allUpperCase(String original) {
		return original.toUpperCase() == original;
	}

	public static void startWithNumber(List<String> words) {
		String[] palavras = words.toArray(new String[0]);
		if (palavras[0].matches(NUMBER_REGEX)) {
			throw new StartWithNumberException("não deve começar com números");
		}

	}

	public static void specialCharacter(String original) {
		if (!original.matches(NO_SPECIAL_CHARACTER_REGEX)) {
			throw new SpecialCharacterException("caracteres especiais não são permitidos, somente letras e números");
		}
	}
}
