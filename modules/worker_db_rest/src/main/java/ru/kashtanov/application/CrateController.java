package ru.kashtanov.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collections;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import com.liferay.portal.kernel.exception.PortalException;
import org.osgi.service.component.annotations.Component;
import ru.kashtanov.crate.model.Crate;
import ru.kashtanov.crate.service.CrateLocalServiceUtil;


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
	@Path("/health")
	@Produces(MediaType.TEXT_PLAIN)
	public String healthCheck() {
		System.out.println("CRATE_CONTROLLER:1 ");
        Crate crate = null;
        try {
            crate = CrateLocalServiceUtil.getCrate(1);
        } catch (PortalException e) {
			System.err.println("ERROR: " + e.getMessage());
        }
        System.out.println("CRATE_CONTROLLER:2  " +  crate.toString());
		return "OK";
	}


}