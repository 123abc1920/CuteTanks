package cs.vsu.ru.myshkevich_a_n.littletanks;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

public class Level {
	private Gson gson = new Gson();
	private JsonReader reader;
	private JsonObject jsonObject;
	private JsonArray jsonArray;

	public Level(String s) {
		try {
			reader = new JsonReader(new FileReader("src//cs//vsu//ru//myshkevich_a_n//files//levels.json"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		jsonObject = gson.fromJson(reader, JsonObject.class);
		jsonArray = jsonObject.getAsJsonArray(s);
	}

	public char getCell(int i, int j) {
		return jsonArray.get(i).getAsJsonArray().get(j).getAsCharacter();
	}

}
