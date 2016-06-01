package org.rapidpm.test.atto.remoteproxy.server;

import com.google.gson.Gson;
import org.rapidpm.test.atto.remoteproxy.api.service.BusinessService;

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
 * Created by RapidPM - Team on 31.05.16.
 */


@Path("/businessservice")
//@IsGeneratedProxy
//public class BusinessServiceRest implements BusinessService {
public class BusinessServiceRest {

  @Inject BusinessService delegator;

//  @GET()
//  @Produces("application/json")
//  @Consumes("text/plain")
//  public String get(@QueryParam("value") String txt) {
//    return new Gson().toJson(delegator.doWork(txt));
//  }

  //  @Override
  @GET()
  @Path(value = "doWork")
  @Produces("application/json")
  @Consumes("application/json")
  public String doWork(@QueryParam("txt") final String txt) {
    return new Gson().toJson(delegator.doWork(txt));
  }
}
