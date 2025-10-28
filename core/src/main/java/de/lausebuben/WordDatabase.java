package de.lausebuben;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import de.lausebuben.model.WordsJsonModel;

import java.util.Random;

public class WordDatabase {
    private Array<String> words;

    public WordDatabase() {
        loadWordsFromFile();
    }

    public String selectRandomWord() {
        Random randomNumber = new Random();
        String targetWord = words.get(randomNumber.nextInt(words.size));
        System.out.println("Target word: " + targetWord);
        return targetWord;
    }

    private void loadWordsFromFile() {
        FileHandle file = Gdx.files.internal("words.json");
        Json json = new Json();
        WordsJsonModel parsedJson = json.fromJson(WordsJsonModel.class, file);
        words = parsedJson.words;
    }
}


