package de.fhws.fiw.fds.suttondemo.server.api.services;

import de.fhws.fiw.fds.sutton.server.api.serviceAdapters.Exceptions.SuttonWebAppException;
import de.fhws.fiw.fds.sutton.server.api.services.AbstractJerseyService;
import de.fhws.fiw.fds.suttondemo.server.api.models.Module;
import de.fhws.fiw.fds.suttondemo.server.api.models.PartnerUniversity;
import de.fhws.fiw.fds.suttondemo.server.api.queries.QueryByUniversityNameAndCountry;
import de.fhws.fiw.fds.suttondemo.server.api.states.modules.*;
import de.fhws.fiw.fds.suttondemo.server.api.states.PartnerUniversities.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("partnerUniversities")
public class PartnerUniversityJerseyService extends AbstractJerseyService {

    public PartnerUniversityJerseyService() {
        super();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAllPartnerUniversities(
            @DefaultValue("") @QueryParam("universityName") final String universityName,
            @DefaultValue("") @QueryParam("country") final String country,
            @DefaultValue("0") @QueryParam("offset") int offset,
            @DefaultValue("20") @QueryParam("size") int size) {
        try {
            return new GetAllPartnerUniversities(
                    this.serviceContext,
                    new QueryByUniversityNameAndCountry<>(universityName, country, offset, size)
            ).execute();
        } catch (SuttonWebAppException e) {
            throw new WebApplicationException(e.getExceptionMessage(), e.getStatus().getCode());
        }
    }

    @GET
    @Path("{id: \\d+}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getSinglePartnerUniversity(@PathParam("id") final long id) {
        try {
            return new GetSinglePartnerUniversity(this.serviceContext, id).execute();
        } catch (SuttonWebAppException e) {
            throw new WebApplicationException(Response
                    .status(e.getStatus().getCode())
                    .entity(e.getExceptionMessage()).build()
            );
        }
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response createSinglePartnerUniversity(final PartnerUniversity partnerUniversity) {
        try {
            return new PostNewPartnerUniversity(this.serviceContext, partnerUniversity).execute();
        } catch (SuttonWebAppException e) {
            throw new WebApplicationException(Response.status(e.getStatus().getCode())
                    .entity(e.getExceptionMessage()).build());
        }
    }

    @PUT
    @Path("{id: \\d+}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response updateSinglePartnerUniversity(@PathParam("id") final long id, final PartnerUniversity partnerUniversity) {
        try {
            return new PutSinglePartnerUniversity(this.serviceContext, id, partnerUniversity).execute();
        } catch (SuttonWebAppException e) {
            throw new WebApplicationException(Response.status(e.getStatus().getCode())
                    .entity(e.getExceptionMessage()).build());
        }
    }

    @DELETE
    @Path("{id: \\d+}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response deleteSinglePartnerUniversity(@PathParam("id") final long id) {
        try {
            return new DeleteSinglePartnerUniversity(this.serviceContext, id).execute();
        } catch (SuttonWebAppException e) {
            throw new WebApplicationException(Response.status(e.getStatus().getCode())
                    .entity(e.getExceptionMessage()).build());
        }
    }

    @GET
    @Path("{universityId: \\d+}/modules")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getModulesOfUniversity(@PathParam("universityId") final long universityId,
                                           @DefaultValue("") @QueryParam("moduleName") final String moduleName,
                                           @DefaultValue("0") @QueryParam("offset") int offset,
                                           @DefaultValue("20") @QueryParam("size") int size) {
        try {
            return new GetAllModulesOfUniversity(this.serviceContext, universityId, new QueryByModuleName<>(universityId, moduleName, offset, size)).execute();
        } catch (SuttonWebAppException e) {
            throw new WebApplicationException(Response.status(e.getStatus().getCode())
                    .entity(e.getExceptionMessage()).build());
        }
    }

    @GET
    @Path("{universityId: \\d+}/modules/{moduleId: \\d+}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getModuleByIdOfUniversity(@PathParam("universityId") final long universityId,
                                              @PathParam("moduleId") final long moduleId) {
        try {
            return new GetSingleModuleOfUniversity(this.serviceContext, universityId, moduleId).execute();
        } catch (SuttonWebAppException e) {
            throw new WebApplicationException(Response.status(e.getStatus().getCode())
                    .entity(e.getExceptionMessage()).build());
        }
    }

    @POST
    @Path("{universityId: \\d+}/modules")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response createNewModuleOfUniversity(@PathParam("universityId") final long universityId, final Module module) {
        try {
            return new PostNewModuleOfUniversity(this.serviceContext, universityId, module).execute();
        } catch (SuttonWebAppException e) {
            throw new WebApplicationException(Response.status(e.getStatus().getCode())
                    .entity(e.getExceptionMessage()).build());
        }
    }

    @PUT
    @Path("{universityId: \\d+}/modules/{moduleId: \\d+}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response updateModuleOfUniversity(@PathParam("universityId") final long universityId,
                                             @PathParam("moduleId") final long moduleId, final Module module) {
        try {
            return new PutSingleModuleOfUniversity(this.serviceContext, universityId, moduleId, module).execute();
        } catch (SuttonWebAppException e) {
            throw new WebApplicationException(Response.status(e.getStatus().getCode())
                    .entity(e.getExceptionMessage()).build());
        }
    }

    @DELETE
    @Path("{universityId: \\d+}/modules/{moduleId: \\d+}")
    public Response deleteModuleOfUniversity(@PathParam("universityId") final long universityId,
                                             @PathParam("moduleId") final long moduleId) {
        try {
            return new DeleteSingleModuleOfUniversity(this.serviceContext, universityId, moduleId).execute();
        } catch (SuttonWebAppException e) {
            throw new WebApplicationException(Response.status(e.getStatus().getCode())
                    .entity(e.getExceptionMessage()).build());
        }
    }
}
