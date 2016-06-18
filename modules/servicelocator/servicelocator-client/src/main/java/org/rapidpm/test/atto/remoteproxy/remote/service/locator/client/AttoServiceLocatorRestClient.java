package org.rapidpm.test.atto.remoteproxy.remote.service.locator.client;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.rapidpm.test.atto.remoteproxy.remote.service.locator.api.AttoServiceLocator;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import java.lang.reflect.Type;
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
 * Created by RapidPM - Team on 02.06.16.
 */
public class AttoServiceLocatorRestClient implements AttoServiceLocator {

  private static final Type TYPE = new TypeToken<Optional<String>>() { }.getType();
  // get connection to the cluster
  private final String serviceLocatorURL = "http://10.1.1.5:9999/rest/attoservicelocator/"; //TODO how to get or default?

  public void registerService(final String clazzFQN, String target) {
    final Gson gson = new Gson();
    final Response response = ClientBuilder
        .newClient()
        .target(serviceLocatorURL)
        .path("registerService")
        .queryParam("classFQN", gson.toJson(clazzFQN)) //Quest wo kommt das her ?
        .queryParam("target", gson.toJson(target)) //Quest wo kommt das her ?
        .request()
        .get();
    //TODO logging if OK or not

    response.close();
  }

  @Override
  public Optional<String> resolve(final String clazzFQN) {
    final Gson gson = new Gson();
    final Client client = ClientBuilder.newClient();
    final String responseJsonValue = client
        .target(serviceLocatorURL)
        .path("resolve")
        .queryParam("classFQN", gson.toJson(clazzFQN)) //Quest wo kommt das her ?
        .request()
        .get(String.class);

    if (responseJsonValue != null && !responseJsonValue.equals("{}")) {
      return new Gson().fromJson(responseJsonValue, TYPE);
    } else return Optional.empty();
  }
}
