package integration.org.rapidpm.test.atto.remoteproxy.server;

import com.google.gson.Gson;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.rapidpm.ddi.DI;
import org.rapidpm.dependencies.core.net.PortUtils;
import org.rapidpm.microservice.Main;
import org.rapidpm.microservice.test.RestUtils;
import org.rapidpm.test.atto.remoteproxy.server.BusinessServiceRest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import static org.rapidpm.test.atto.remoteproxy.server.BusinessServiceRest.METHOD_DO_WORK_Q_TXT;

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
public class BusinessServiceRESTTest {

  @Before
  public void setUp() throws Exception {
    DI.clearReflectionModel();
    DI.activatePackages("org.rapidpm");
    DI.activatePackages(this.getClass());


    System.setProperty(Main.REST_HOST_PROPERTY, "127.0.0.1");
    System.setProperty(Main.SERVLET_HOST_PROPERTY, "127.0.0.1");

    final PortUtils portUtils = new PortUtils();
    System.setProperty(Main.REST_PORT_PROPERTY, portUtils.nextFreePortForTest() + "");
    System.setProperty(Main.SERVLET_PORT_PROPERTY, portUtils.nextFreePortForTest() + "");

    Main.deploy();
  }

  @Test
  public void get() throws Exception {
    final RestUtils restUtils = new RestUtils();
    final String basicReqURL = restUtils.generateBasicReqURL(BusinessServiceRest.class, Main.CONTEXT_PATH_REST);

    Client client = ClientBuilder.newClient();
    System.out.println("basicReqURL = " + basicReqURL);
    String json = client
        .target(basicReqURL)
        .path(BusinessServiceRest.METHOD_DO_WORK)
        .queryParam(METHOD_DO_WORK_Q_TXT, "Hello World")
        .request()
        .get(String.class);

    final String val = new Gson().fromJson(json, String.class);

    System.out.println("val = " + val);
    Assert.assertEquals("hello world", val);
    client.close();
  }


  @After
  public void tearDown() throws Exception {
    Main.stop();
    DI.clearReflectionModel();
  }
}