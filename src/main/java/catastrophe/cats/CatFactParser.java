package catastrophe.cats;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import com.ibm.json.java.JSON;
import com.ibm.json.java.JSONArray;
import com.ibm.json.java.JSONObject;

/**
 * This data is static and never changes, so we don't bother with a database.
 *
 */
public class CatFactParser {
	private final Map<String, List<String>> facts;
	private final Set<String> allFacts;
	private Random random = new Random();

	/**
	 * @param string
	 * @throws IOException
	 * @throws NullPointerException
	 */
	public CatFactParser() {
		System.out.println("PARSING");
		facts = new HashMap<String, List<String>>();
		allFacts = new HashSet<String>();
		try {
			InputStream stream = this.getClass().getResourceAsStream("/catfacts.json");
			JSONArray ar = (JSONArray) JSON.parse(stream);
			@SuppressWarnings("unchecked")
			Iterator<JSONObject> it = ar.iterator();
			while (it.hasNext()) {
				JSONObject catJson = it.next();
				String creature = (String) catJson.get("creature");
				System.out.println("doing " + creature);
				JSONArray rawFacts = (JSONArray) catJson.get("facts");

				if (rawFacts != null) {
					List<String> creatureFacts = new ArrayList<>(rawFacts.size());
					@SuppressWarnings("unchecked")
					Iterator<JSONObject> factit = rawFacts.iterator();
					// Cache our flattened view of facts
					while (factit.hasNext()) {
						String nextFact = (String) factit.next().get("fact");
						creatureFacts.add((String) nextFact);
						allFacts.add((String) nextFact);
					}
					facts.put(creature, creatureFacts);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Collection<String> getFacts() {
		return allFacts;
	}

	public String getFact(String creature) {
		List<String> creatureFacts = facts.get(creature);
		if (creatureFacts != null && creatureFacts.size() > 0) {
			return creatureFacts.get(random.nextInt(creatureFacts.size()));
		} else {
			return "I've never heard of a " + creature;
		}
	}

}
