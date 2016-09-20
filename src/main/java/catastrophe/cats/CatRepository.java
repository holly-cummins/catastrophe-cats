package catastrophe.cats;

import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CatRepository {

	public Collection<String> getAllFacts() {
		return new CatFactParser().getFacts();

	}

	public String getFact(String creature) {
		return new CatFactParser().getFact(creature);

	}
}
