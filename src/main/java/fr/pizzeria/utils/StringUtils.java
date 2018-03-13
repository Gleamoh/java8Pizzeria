package fr.pizzeria.utils;

import java.lang.reflect.Field;

/**
 * @author Kevin M.
 *
 */
public final class StringUtils {

	/**
	 * Constructor
	 * Classe stateless (pas de d'attributs ni methodes d'instance
	 */
	private StringUtils() {

	}

	/**
	 * Format l'affichage des attributs d'une classe
	 * @param object
	 * @return
	 */
	public static String toString(Object object) {

		String chaine = "";

		Field[] fields = object.getClass().getDeclaredFields();
		for (Field field : fields) {

			// pour outrepasser le modifieur "private" de l'attribut
			field.setAccessible(true);

			if (field.isAnnotationPresent(ToString.class)) {
				// récupérer l'annotation ToString
				ToString a = field.getAnnotation(ToString.class);
				try {
					Object value = field.get(object);
					if (a.upperstring())
						value = String.valueOf(value).toUpperCase();
					chaine += a.beginWith() + value + a.endWith() + " ";
					

				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}

		return chaine;
	}



	// public static Boolean isAnnoted(String annotationClass, Object object,
	// String callback) {
	//
	// // récupérer la class en fonction de la string
	//
	//
	// Field[] fields = object.getClass().getDe)claredFields();
	// for (Field field : fields) {
	// if (field.isAnnotationPresent(Class.forName(annotationClass).getClass()))
	// {
	// // récupérer l'annotation ToString
	// ToString annotation = field.getAnnotation(ToString.class);
	// try {
	// Object value = field.get(object);
	//
	// if (callback != null) {
	// try {
	// Class<?> foundClass = Class.forName(callback);
	// try {
	// Object newObject = foundClass.getConstructor().newInstance();
	// } catch (ReflectiveOperationException e) {
	// e.printStackTrace();
	// }
	//
	// } catch (ClassNotFoundException e) {
	// e.printStackTrace();
	// }
	// }
	//
	//
	//
	// } catch (IllegalArgumentException | IllegalAccessException e) {
	// e.printStackTrace();
	// }
	//
	// }
	// }
	// return false;
	// }
}
