package course.manager

import groovy.transform.CompileStatic

import java.text.Normalizer

/**
 * Converts a Course/Lesson name in a URL suitable string
 */
@CompileStatic
class Slugifier {
    static String generate(String original) {
        Normalizer
                .normalize(original.trim(), Normalizer.Form.NFD)
                .replaceAll("[^a-zA-Z0-9 ]", "")
                .replaceAll(" ", "-").toLowerCase()
    }
}
