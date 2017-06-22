package jr.eecs1022.piglatin;

import java.util.StringTokenizer;

public class PigLatinTranslator {
    private String english;
    private String pig;

    public PigLatinTranslator() {
        this.setEnglish("");
    }

    public PigLatinTranslator(String text) {
        this.setEnglish(text);
    }

    public String getEnglish() {
        return this.english;
    }

    public void setEnglish(String text) {
        this.english = text.toLowerCase();
        this.translate();
    }

    public String getPig() {
        return this.pig;
    }

    // Translate the state to PigLatin
    public void translate() {
        StringTokenizer st = new StringTokenizer(this.english);
        String result = "";
        while (st.hasMoreTokens()) {
            String word = st.nextToken();
            String pig = this.translateWord(word);
            if (result.length() == 0) {
                result = pig;
            } else {
                result = result + " " + pig;
            }
        }
        this.pig = result;
    }

    // Translate the given word to PigLatin
    // and return the translation
    private String translateWord(String word) {
        // replace with correct code

        /*
        1)consonants 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't','v', 'w', 'x', 'y', 'z'
        2)vowels a e i o u
        3)symbols ! " # $ % & ( ) * + , - . / : ; < = > ? @ [ ] }
        4) the loops to make the program work
         */
        String result = word;
        char conson[] = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't',
                'v', 'w', 'x', 'y', 'z'};
        char vowels[] = {'a', 'e', 'i', 'o', 'u'};
        char symbols[] = {'!', '"', '#', '$', '%', '&', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', ']'};
        //vowel
        for (int i = 0; i < vowels.length; i++) {
            if (word.charAt(0) == vowels[i]) {
                result = word + "way";
                break;
            }
        }
        //consonants
        for (int i = 0; i < conson.length; i++) {
            if (word.charAt(0) == conson[i]) {
                result = word.substring(1, word.length()) + word.charAt(0) + "ay";
                break;
            }
        }
        //symbols
        for (int i = 0; i < symbols.length; i++) {
            if (word.charAt(0) == symbols[i]) {
                if (word.charAt(1) == vowels[i]) {
                    result = word + "way";
                    break;
                }

            }
        }
        for(int i = 0; i < symbols.length; i++){
            if (word.charAt(0) == symbols[i]) {
                if (word.charAt(1) == conson[i]) {
                    result = word.substring(2, word.length()) + word.charAt(1) + "ay";
                    break;
                }
            }
        }
        for(int i = 0; i < symbols.length; i++){
                if (word.charAt(word.length() - 1) == symbols[i] && Character.isLetter(word.charAt(0))) {
                    result = word.substring(1, word.length() - 1) + word.charAt(0) + "ay" + word.charAt(word.length() - 1);
                    break;
                }
            }
            return result;
        }
    }
