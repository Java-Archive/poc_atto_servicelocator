package org.rapidpm.test.atto.remoteproxy.remote.service.locator.service;

import org.rapidpm.ddi.DI;
import org.rapidpm.ddi.scopes.provided.JVMSingletonInjectionScope;
import org.rapidpm.microservice.Main;
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
 * Created by RapidPM - Team on 02.06.16.
 */
public class AttoServiceStartupAction implements Main.MainStartupAction {
  @Override
  public void execute(final Optional<String[]> args) {
    System.setProperty(Main.REST_HOST_PROPERTY, "127.0.0.1");
    System.setProperty(Main.SERVLET_HOST_PROPERTY, "127.0.0.1");

//    final PortUtils portUtils = new PortUtils();
    System.setProperty(Main.REST_PORT_PROPERTY, "9999");
//    System.setProperty(Main.SERVLET_PORT_PROPERTY, portUtils.nextFreePortForTest() + "");
    DI.registerClassForScope(AttoServiceLocator.class, JVMSingletonInjectionScope.class.getSimpleName());
  }
}
