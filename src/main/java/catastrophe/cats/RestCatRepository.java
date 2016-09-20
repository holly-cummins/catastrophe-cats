package catastrophe.cats;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("cats")
public class RestCatRepository {

	private static final CatFactParser CAT_FACT_PARSER = new CatFactParser();

	@Path("facts")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Collection<String> getAllFacts() {
		return CAT_FACT_PARSER.getFacts();

	}

	@Path("fact/{creature}")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public String getFact(@PathParam(value = "creature") String creature) {
		return CAT_FACT_PARSER.getFact(creature);

	}
}
