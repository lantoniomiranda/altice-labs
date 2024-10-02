package pt.altice.controllers;

import jakarta.inject.Inject;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import pt.altice.services.LabSeqService;

@Path("/labseq")
public class LabSeqController {

    @Inject
    LabSeqService labSeqService;

    @GET
    @Path("/{n:\\d+}") // restriction to accept only non-negative integer numbers
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLabSeq(@PathParam("n") int n){
        JsonObject res = labSeqService.getLabSeqResponse(n);
        return Response.ok(res).build();
    }

}
