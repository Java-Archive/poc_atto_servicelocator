package integration.org.rapidpm.test.atto.remoteproxy.server.service

import org.junit.Assert
import org.junit.Test
import org.rapidpm.test.atto.remoteproxy.server.service.BusinessServiceImpl

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

 * Created by RapidPM - Team on 31.05.16.
 */
class BusinessServiceImplTest {


  //  @Test
  //  public void test001() throws Exception {
  //    final BusinessService s = new BusinessServiceImpl();
  //    Assert.assertEquals("", s.doWork(null));
  //  }

  @Test
  @Throws(Exception::class)
  fun test002() {
    val s = BusinessServiceImpl()
    Assert.assertEquals("abc", s.doWork("ABC"))
  }

  @Test
  @Throws(Exception::class)
  fun test003() {
    val s = BusinessServiceImpl()
    Assert.assertEquals("abc", s.doWork("abc"))
  }

}