package io.arrogantprogrammer.randomizer.waffles.infrastructure;

import io.arrogantprogrammer.randomizer.waffles.domain.Waffle;
import io.arrogantprogrammer.randomizer.waffles.domain.WaffleJson;

import javax.transaction.Transactional;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/waffle")
public class WaffleResource {

    @POST
    @Transactional
    public Response addWaffle(final WaffleJson waffleJson) {

        Waffle waffle = Waffle.from(waffleJson);
        waffle.persist();
        WaffleJson resultJson = new WaffleJson(waffle.id, waffle.getType(), waffle.getToppings());
        return Response.created(URI.create("/" + resultJson.id())).entity(resultJson).build();
    }
}
