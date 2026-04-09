package ru.kashtanov.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collections;

import java.util.Date;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import org.osgi.service.component.annotations.Component;
import ru.kashtanov.dad.model.Dad;
import ru.kashtanov.dad.service.DadLocalService;
import ru.kashtanov.dad.service.DadLocalServiceUtil;


/**
 * @author ASUS
 */
@Component(
        property = {
                "osgi.jaxrs.application.base=/product",
                "osgi.jaxrs.name=Product.Rest",
                "liferay.access.control.disable=true",
                "liferay.oauth.disable=true"
        },
        service = Application.class
)
public class CrateController extends Application {

    public Set<Object> getSingletons() {
        return Collections.singleton(this);
    }


    @GET
    @Path("/test-sammy")
    @Produces(MediaType.TEXT_PLAIN)
    public String createIriWithTransaction() {
        try {

            long newId = CounterLocalServiceUtil.increment(Dad.class.getName());

            System.out.println("here it is " + newId);
            Dad iri = DadLocalServiceUtil.createDad(newId);
            System.out.println(iri.toString());

            try {
                DadLocalServiceUtil.addDad(iri);
            } catch (Exception e) {
                System.out.println("Exception occured while adding Iri " + e.getMessage());
                e.printStackTrace();
            }

            return "Success";

        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

}