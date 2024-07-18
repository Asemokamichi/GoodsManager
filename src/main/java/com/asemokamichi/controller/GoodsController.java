package com.asemokamichi.controller;

import com.asemokamichi.entity.Product;
import com.asemokamichi.service.GoodsService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/goods")
public class GoodsController {

    @Inject
    private GoodsService goodsService;

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        return Response.ok(goodsService.findAll()).build();
    }

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(Product product) {
        goodsService.save(product);
        return Response.ok().build();
    }
}