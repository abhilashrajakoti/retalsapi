package com.rentals.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.rentals.core.beans.Tenant;
import com.rentals.core.dao.TenantDao;

@Path("tenant")
public class RestTenant {
	private static final Logger logger = Logger.getLogger("RestTenant.class");

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public boolean createTenant(Tenant t) {
		boolean bool = false;
		try {
			TenantDao dao = new TenantDao();
			bool = dao.createTenant(t);
		} catch (Exception e) {
			logger.error("resttenant create", e);
		}
		return bool;
	}

}
