/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.academik.rest;

import io.academik.controller.EduCourseFacade;
import io.academik.model.EduCourse;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

/**
 *
 * @author david
 */
@Path("course")
@RequestScoped
@Produces("application/json")
@Consumes("application/json")
public class eduCourseEnpoint {

    @EJB
    EduCourseFacade eduCourseService;

    @GET
    public List<EduCourse> listAll() {
        return eduCourseService.findAll();
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    public EduCourse findById(Long id) {
        return eduCourseService.find(id);
    }

    @POST
    public Response create(EduCourse student) {
        eduCourseService.create(student);
        return Response.created(UriBuilder.fromResource(eduCourseEnpoint.class)
                .path(String.valueOf(student.getCourseId())).build()).build();
    }

    @PUT
    @Path("/{id:[0-9][0-9]*}")
    public Response update(@PathParam("id") Long id, EduCourse student) {
        eduCourseService.edit(student);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/{id:[0-9][0-9]*}")
    public Response delete(@PathParam("id")Long id){
        EduCourse student = eduCourseService.find(id);
        eduCourseService.remove(student);
        return Response.noContent().build();
    }


}
