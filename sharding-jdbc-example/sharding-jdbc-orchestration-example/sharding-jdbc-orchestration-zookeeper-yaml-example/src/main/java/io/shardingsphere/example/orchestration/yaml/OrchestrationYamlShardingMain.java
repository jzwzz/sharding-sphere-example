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

package io.shardingsphere.example.orchestration.yaml;

import io.shardingsphere.example.orchestration.yaml.repository.OrchestrationYamlRepository;
import io.shardingsphere.jdbc.orchestration.api.OrchestrationShardingDataSourceFactory;
import io.shardingsphere.jdbc.orchestration.api.util.OrchestrationDataSourceCloseableUtil;

import javax.sql.DataSource;
import java.io.File;

public final class OrchestrationYamlShardingMain {
    
    public static void main(final String[] args) throws Exception {
        DataSource dataSource = OrchestrationShardingDataSourceFactory.createDataSource(new File(
                OrchestrationYamlShardingMain.class.getResource("/META-INF/yamlShardingDatabaseAndTableByLocalConfig.yaml").getFile()));
//        DataSource dataSource = OrchestrationShardingDataSourceFactory.createDataSource(new File(
//                OrchestrationYamlShardingMain.class.getResource("/META-INF/yamlShardingDatabaseAndTableByCloudConfig.yaml").getFile()));
        new OrchestrationYamlRepository(dataSource).demo();
        OrchestrationDataSourceCloseableUtil.closeQuietly(dataSource);
    }
}