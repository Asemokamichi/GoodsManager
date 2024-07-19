package com.asemokamichi.controller;

import com.asemokamichi.entity.Product;
import com.asemokamichi.service.GoodsService;
import com.asemokamichi.service.impl.GoodsServiceImpl;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/goods")
public class GoodsController {
    private final GoodsService goodsService = new GoodsServiceImpl();

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        return Response.ok(goodsService.findAll()).build();
    }

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProduct(@PathParam("id") Long id ) {
        return Response.ok(goodsService.findById(id)).build();
    }

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(Product product) {
        goodsService.save(product);
        return Response.ok().build();
    }
}
