package catastrophe.cats;

import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CatRepository {

	public Collection<MiniCat> getAllCats() {
		return new CatParser().getCats();

	}

	public MiniCat getCat(long id) {
		return new CatParser().getCat(id);

	}
}
