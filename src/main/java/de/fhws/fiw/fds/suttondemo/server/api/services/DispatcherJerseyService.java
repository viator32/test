package de.fhws.fiw.fds.suttondemo.server.api.services;

import de.fhws.fiw.fds.sutton.server.api.serviceAdapters.Exceptions.SuttonWebAppException;
import de.fhws.fiw.fds.sutton.server.api.services.AbstractJerseyService;
import de.fhws.fiw.fds.suttondemo.server.api.states.dispatcher.GetDispatcher;
import de.fhws.fiw.fds.suttondemo.server.database.utils.ResetDatabase;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("")
public class DispatcherJerseyService extends AbstractJerseyService {

    private static final Logger logger = LoggerFactory.getLogger(DispatcherJerseyService.class);

    @GET
    public Response getDispatcher() {
        try {
            return new GetDispatcher(this.serviceContext).execute();
        } catch (SuttonWebAppException e) {
            throw new WebApplicationException(Response.status(e.getStatus().getCode())
                    .entity(e.getExceptionMessage()).build());
        }
    }

    @GET
    @Path("resetdatabase")
    @Produces({MediaType.APPLICATION_JSON})
    public Response resetDatabase() {
        logger.info("Resetting database");
        try {
            ResetDatabase.resetAll();
            return Response.ok().build();
        } catch (Exception e) {
            logger.error("Error resetting database", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error resetting database").build();
        }
    }
}
