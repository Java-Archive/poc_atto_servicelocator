package org.rapidpm.test.atto.remoteproxy.remote.service.locator.service;

import com.google.gson.Gson;

import javax.inject.Inject;
import javax.ws.rs.*;

/**
 * Copyright (C) 2010 RapidPM
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Created by RapidPM - Team on 02.06.16.
 */

@Path("/attoservicelocator")
public class AttoServiceLocatorREST {


  @Inject AttoServiceLocatorImpl attoServiceLocator;

  @GET()
  @Path(value = "resolve")
  @Produces("application/json")
  @Consumes("application/json")
  public String resolve(@QueryParam("classFQN") final String classFQN) {
    final Gson gson = new Gson();
    return gson.toJson(attoServiceLocator.resolve(gson.fromJson(classFQN, String.class)));
  }

  @GET()
  @Path(value = "registerService")
  @Produces("application/json")
  @Consumes("application/json")
  public void registerService(@QueryParam("classFQN") final String classFQN,
                              @QueryParam("target") final String target) {
    final Gson gson = new Gson();
    attoServiceLocator.setServiceLocation(gson.fromJson(classFQN, String.class), gson.fromJson(target, String.class));
  }


}
