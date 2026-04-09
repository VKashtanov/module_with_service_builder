package ru.kashtanov.application;

import java.util.Collections;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.osgi.service.component.annotations.Component;
import ru.kashtanov.dad.model.Dad;
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
public class TestController extends Application {

    public Set<Object> getSingletons() {
        return Collections.singleton(this);
    }

    private static final Log log = LogFactoryUtil.getLog(TestController.class);


    @GET
    @Path("/test-sammy")
    @Produces(MediaType.TEXT_PLAIN)
    public String testApi() {
        try {
            // 1. CREATING a new Entity
            long newId = CounterLocalServiceUtil.increment(Dad.class.getName());
            Dad newDad = DadLocalServiceUtil.createDad(newId);
            newDad.setCompanyId(20097);
            newDad.setName("New_created_DAD_ID: " + newId);
            log.info("**CREATING** a new entity: " + newDad.toString());
            DadLocalServiceUtil.addDad(newDad);

            //2. GETTING an Entity
            Dad dad = DadLocalServiceUtil.getDad(newId);
            log.info("**GETTING** an entity: " + dad.toString());

            //3. UPDATING an Entity
            dad.setName("**UPDATING** " + newId);
            DadLocalServiceUtil.updateDad(dad);
            log.info("Updated a new entity: " + dad.toString());

            //4. DELETING an Entity
            DadLocalServiceUtil.deleteDad(dad);
            log.info("DELETING an entity: " + dad.toString());
            try {
                DadLocalServiceUtil.getDad(newId);
            } catch (PortalException e) {
                log.error("No such entity: " + dad.toString());
            }


            return "Success";

        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

}