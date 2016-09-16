package catastrophe.cats;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.ibm.json.java.JSON;
import com.ibm.json.java.JSONArray;
import com.ibm.json.java.JSONObject;

public class CatParser {
	private static Map<Long, Cat> cats;

	/**
	 * @param string
	 */
	public CatParser() {
		if (cats == null) {
			cats = new HashMap<Long, Cat>();
			InputStream stream = this.getClass().getResourceAsStream("/catstore.json");
			try {
				JSONArray ar = (JSONArray) JSON.parse(stream);
				@SuppressWarnings("unchecked")
				Iterator<JSONObject> it = ar.iterator();
				while (it.hasNext()) {
					JSONObject catJson = it.next();
					// The JsonObject returns a long by default for numbers
					Long id = (Long) catJson.get("id");
					Cat cat = new Cat(id, (String) catJson.get("realName"), (String) catJson.get("image"),
							(String) catJson.get("attribution"));
					cats.put(id, cat);
				}
			} catch (NullPointerException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public Collection<Cat> getCats() {
		return cats.values();
	}

	public Cat getCat(long id) {
		return cats.get(id);
	}

}
