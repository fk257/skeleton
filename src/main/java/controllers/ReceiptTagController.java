package controllers;

import api.ReceiptResponse;
import dao.ReceiptTagDao;
import generated.tables.records.ReceiptsRecord;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static java.util.stream.Collectors.toList;


@Path("/tags/{tag}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReceiptTagController {
    final ReceiptTagDao receipt_tags;

    public ReceiptTagController(ReceiptTagDao receipt_tags) {
        this.receipt_tags = receipt_tags;
    }

    @PUT
    public Response toggleTag(@PathParam("tag") String tagName, int receipt_id ){
        if (!receipt_tags.receiptExists(receipt_id)){
            return Response.status(400).build();
        }

        if (receipt_tags.receiptTagExists(tagName, receipt_id)){
            receipt_tags.deleteTag(tagName, receipt_id);
        }
        else {
            receipt_tags.insertTag(tagName, receipt_id);
        }
        return Response.ok().build();
    }

    @GET
    public List<ReceiptResponse> getReceiptsByTag(@PathParam("tag") String tagName) {
        List<ReceiptsRecord> receiptTagRecords = receipt_tags.getAllReceiptsByTag(tagName);
        return receiptTagRecords.stream().map(ReceiptResponse::new).collect(toList());
    }

}
