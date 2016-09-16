package catastrophe.cats;

import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CatRepository {

	public Collection<Cat> getAllCats() {
		return new CatParser().getCats();

	}

	public Cat getCat(long id) {
		return new CatParser().getCat(id);

	}
}
