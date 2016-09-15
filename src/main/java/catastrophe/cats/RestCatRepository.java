package catastrophe.cats;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("cats")
public class RestCatRepository {

	@Path("cats")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Collection<MiniCat> getAllCats() {
		return new CatParser().getCats();

	}

	@Path("cat/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public MiniCat getCat(@PathParam(value = "id") long id) {
		return new CatParser().getCat(id);

	}
}
