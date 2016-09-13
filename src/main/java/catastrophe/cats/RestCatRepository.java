package catastrophe.cats;

import java.util.Set;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("cats")
public class RestCatRepository {

	@Path("cats")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Set<MiniCat> getAllCats() {
		return new CatParser().getCats();

	}

	@Path("cat/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Cat getCat(@PathParam(value = "id") long id) {
		return new CatParser().getCat(id);

	}
}
