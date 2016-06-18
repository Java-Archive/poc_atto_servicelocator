package org.rapidpm.test.atto.remoteproxy.remote.service.locator.service;

import org.rapidpm.test.atto.remoteproxy.remote.service.locator.api.AttoServiceLocator;

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
 *
 * Created by RapidPM - Team on 01.06.16.
 */
public class AttoServiceLocatorImpl implements AttoServiceLocator {


  private Map<String, String> serviceLocatorTargetMap = new HashMap<>();

  public void setServiceLocation(String clazzFQN, String target) {
    serviceLocatorTargetMap.put(clazzFQN, target);
  }

  public void removeLocation(Class clazz) {
    serviceLocatorTargetMap.remove(clazz);
  }

  @Override
  public Optional<String> resolve(final String clazzFQN) {
    return Optional.ofNullable(serviceLocatorTargetMap.get(clazzFQN));
  }

}
