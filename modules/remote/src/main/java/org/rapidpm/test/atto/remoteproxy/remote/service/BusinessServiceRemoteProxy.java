package org.rapidpm.test.atto.remoteproxy.remote.service;

import com.google.gson.Gson;
import org.rapidpm.test.atto.remoteproxy.api.service.BusinessService;
import org.rapidpm.test.atto.remoteproxy.remote.service.locator.api.AttoServiceLocator;

import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.util.Optional;

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

//TODO die technischen Details fehlen im Interface
public class BusinessServiceRemoteProxy implements BusinessService {

  private Client client = ClientBuilder.newClient();
  @Inject AttoServiceLocator attoServiceLocator;


  @Override
  public String doWork(final String txt) {

    final Optional<String> resolve = attoServiceLocator.resolve(BusinessService.class.getName());
    if (resolve.isPresent()) {
      final Gson gson = new Gson();
      String json = client
          .target(resolve.get())
          .path("doWork")
          .queryParam("txt", gson.toJson(txt)) //Quest wo kommt das her ?
          .request()
          .get(String.class);

      return gson.fromJson(json, String.class);
    } else {
      return ""; //TODO  how to handle error / exceptions
    }
  }
}
