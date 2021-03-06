/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package io.shardingsphere.example.spring.namespace.mybatis.main.orche.etcd;

import io.shardingsphere.example.repository.api.service.CommonService;
import io.shardingsphere.example.repository.mybatis.service.SpringPojoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * Please make sure master-slave data sync on MySQL is running correctly. Otherwise this example will query empty data from slave.
 */
public class ShardingAndMasterSlaveTogether {

    private static final boolean LOAD_CONFIG_FROM_REG_CENTER = false;

    public static void main(final String[] args) {
        String configFileName = LOAD_CONFIG_FROM_REG_CENTER ? "META-INF/etcd/cloud/shardingMasterSlave.xml" : "META-INF/etcd/local/shardingMasterSlave.xml";
        try (ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(configFileName)) {
            CommonService commonService = (CommonService) applicationContext.getBean("springPojoService");
            commonService.initEnvironment();
            commonService.processSuccess();
            commonService.cleanEnvironment();
        }
    }
}
