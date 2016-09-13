package catastrophe.cats;

import java.util.Set;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CatRepository {

	public Set<MiniCat> getAllCats() {
		return new CatParser().getCats();

	}

	public Cat getCat(long id) {
		return new CatParser().getCat(id);

	}
}
