package replaceToken;

import java.util.HashMap;

/**
 * Transforms a texte by replacing a set of tokens by
 * predefined values.
 *
 * Example:
 *
 * I am {name} => I am Robert
 *
 * A token should be a name between brackets: {token}
 *
 * @author Administrateur
 */

public class Transformer {

    private HashMap<String, String> hashTemplate = new HashMap<String, String>();

    /**
     * Adds a new token which will user when transforming
     * texts.
     *
     * @param token : the identifier of the tocken, without te brackets : "name"
     * @param value : the value which will replace the token in the text
     */

    public void addToken(String token, String value) {
        hashTemplate.put(token, value);
    }

    /**
     * Transforms a text by replacing the token with their corresponding values.
     *
     * Each token should be between brackets, for example :
     *
     * Hello {name}, how are you doing ?
     *
     * If a token is not known, then it is left in place as-is
     *
     * @param text : the take which will be transformed.
     * @return : the transformed text.
     */

    public String transform(String text) {
        String newText = text;

        for (String token : hashTemplate.keySet()) {
            newText = text.replace("[" + token + "]", hashTemplate.get(token));
        }

        return newText;

        /*
        * 2nd solution
        * int capacity = (int) (text.length() * 1.2f);
        * StringBuilder stringBuilder = new StringBuilder(capacity);
        *
        * Pattern pattern = Pattern.compile("(\\{(.*?)\\}");
        * Matcher matcher = pattern.matcher(text);
        *
        * while (matcher.find()) {
        *   String token = matcher.group(1);
        *   String value = tokens.get(token);
        *   if (value != null)
        *       matcher.appendReplacement(stringBuilder, token);
        *   else
        *       matcher.appendReplacement(stringBuilder, "{" + token "}");
        * }
        *
        * return stringBuilder.toString();
         */
    }

}
