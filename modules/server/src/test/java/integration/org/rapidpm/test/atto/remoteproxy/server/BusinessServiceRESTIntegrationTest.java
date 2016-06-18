package integration.org.rapidpm.test.atto.remoteproxy.server;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.rapidpm.ddi.DI;
import org.rapidpm.microservice.Main;
import org.rapidpm.test.atto.remoteproxy.api.service.BusinessService;
import org.rapidpm.test.atto.remoteproxy.remote.service.locator.api.AttoServiceLocator;

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

public class BusinessServiceRESTIntegrationTest {

  @Before
  public void setUp() throws Exception {
    DI.clearReflectionModel();
    DI.activatePackages("org.rapidpm");
    DI.activatePackages(this.getClass());


//    System.setProperty(Main.REST_HOST_PROPERTY, "127.0.0.1");
//    System.setProperty(Main.SERVLET_HOST_PROPERTY, "127.0.0.1");

//    final PortUtils portUtils = new PortUtils();
//    System.setProperty(Main.REST_PORT_PROPERTY, portUtils.nextFreePortForTest() + "");
//    System.setProperty(Main.SERVLET_PORT_PROPERTY, portUtils.nextFreePortForTest() + "");

    Main.deploy();
  }

  @Test
  public void chekIfRegistered() throws Exception {
    final AttoServiceLocator attoServiceLocator = DI.activateDI(AttoServiceLocator.class);
    final Optional<String> resolve = attoServiceLocator.resolve(BusinessService.class.getName());
    Assert.assertTrue(resolve.isPresent());
  }


  @After
  public void tearDown() throws Exception {
    Main.stop();
    DI.clearReflectionModel();
  }
}