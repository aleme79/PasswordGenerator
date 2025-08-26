package programa;

import java.util.Random;

public class PasswordGenerator {

	public static final String MINUSCULA = "abcdefghijklmnñopqrstuvwxyz";
	public static final String MAYUSCULA = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
	public static final String NUMEROS = "0123456789";
	public static final String SIMBOLOS = "~`!@#$%^&*()_-+={[}]|\\:;\"'<,>.?/";

	private final Random random;

	public PasswordGenerator() {
		random = new Random();
	}

	public String generarContraseña(int length, boolean incluyeMayuscula, boolean incluyeMinuscula,
			boolean incluyeNumeros, boolean incluyeSimbolos) {

		StringBuilder passwordBuilder = new StringBuilder();
		String caracteresValidos = "";

		if (incluyeMayuscula)
			caracteresValidos += MAYUSCULA;
		if (incluyeMinuscula)
			caracteresValidos += MINUSCULA;
		if (incluyeNumeros)
			caracteresValidos += NUMEROS;
		if (incluyeSimbolos)
			caracteresValidos += SIMBOLOS;

		for (int i = 0; i < length; i++) {
			int randomIndex = random.nextInt(caracteresValidos.length());

			char randomChar = caracteresValidos.charAt(randomIndex);

			passwordBuilder.append(randomChar);
		}

		return passwordBuilder.toString();
	}
}
