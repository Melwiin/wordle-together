package de.lausebuben;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;

import java.util.Random;


public class WordDatabase {
    private Array<String> words;
    private Random randomNumber;
    private String targetWord;

    public static class WordList {
        public Array<String> words;
    }

    public WordDatabase() {
        randomNumber = new Random();
        loadTargetWordFromFile();
    }

    public String loadTargetWordFromFile() {
        FileHandle file = Gdx.files.internal("words.json");
        Json json = new Json();
        WordList wordList = json.fromJson(WordList.class, file);
        words = wordList.words;

        targetWord = words.get(randomNumber.nextInt(words.size));
        System.out.println("Target word: " + targetWord);
        return targetWord;
    }
}


