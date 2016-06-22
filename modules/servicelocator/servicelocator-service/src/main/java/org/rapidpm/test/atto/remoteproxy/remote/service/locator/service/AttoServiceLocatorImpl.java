package org.rapidpm.test.atto.remoteproxy.remote.service.locator.service;

import org.rapidpm.test.atto.remoteproxy.remote.service.locator.api.AttoServiceLocator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
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
 * Created by RapidPM - Team on 01.06.16.
 */
public class AttoServiceLocatorImpl implements AttoServiceLocator {

    private static final Logger LOGGER = LoggerFactory.getLogger(AttoServiceLocatorImpl.class);


    private Map<String, String> serviceLocatorTargetMap = new HashMap<>();

    public void setServiceLocation(String clazzFQN, String target) {
        serviceLocatorTargetMap.put(clazzFQN, target);
        LOGGER.debug("registered target <{}> for class <{}>", target, clazzFQN);
    }

    public void removeLocation(Class clazz) {
        serviceLocatorTargetMap.remove(clazz);
    }

    @Override
    public Optional<String> resolve(final String clazzFQN) {
        String target = serviceLocatorTargetMap.get(clazzFQN);
        LOGGER.debug("resolved target <{}> for class <{}>", target, clazzFQN);
        return Optional.ofNullable(target);
    }

}
