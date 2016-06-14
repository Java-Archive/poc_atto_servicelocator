package org.rapidpm.test.atto.remoteproxy.server;

import org.rapidpm.microservice.Main;
import org.rapidpm.test.atto.remoteproxy.api.service.BusinessService;
import org.rapidpm.test.atto.remoteproxy.remote.service.locator.client.AttoServiceLocatorRestClient;

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
 * <p>
 * Created by RapidPM - Team on 02.06.16.
 */
public class BusinessServiceStartupAction implements Main.MainStartupAction {

    private final String serviceLocatorURL = "http://10.1.1.5:9999/rest/attoservicelocator"; // TODO how to get or default?

    @Override
    public void execute(final Optional<String[]> args) {
        //Register at ServiceLocator

        final AttoServiceLocatorRestClient locatorRestClient = new AttoServiceLocatorRestClient();
        locatorRestClient.registerService(BusinessService.class.getName(), "http://10.1.1.5:7081/rest/businessservice");


    }
}
