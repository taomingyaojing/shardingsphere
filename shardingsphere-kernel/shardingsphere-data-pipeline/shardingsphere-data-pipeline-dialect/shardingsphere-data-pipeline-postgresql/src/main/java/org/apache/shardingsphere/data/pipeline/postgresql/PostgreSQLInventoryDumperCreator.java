/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.data.pipeline.postgresql;

import javax.sql.DataSource;
import org.apache.shardingsphere.data.pipeline.api.config.ingest.InventoryDumperConfiguration;
import org.apache.shardingsphere.data.pipeline.api.ingest.channel.PipelineChannel;
import org.apache.shardingsphere.data.pipeline.core.ingest.dumper.InventoryDumperCreator;
import org.apache.shardingsphere.data.pipeline.core.metadata.loader.PipelineTableMetaDataLoader;
import org.apache.shardingsphere.data.pipeline.postgresql.ingest.PostgreSQLInventoryDumper;
import org.apache.shardingsphere.data.pipeline.spi.ingest.dumper.InventoryDumper;

/**
 * PostgreSQL inventory dumper creator.
 */
public class PostgreSQLInventoryDumperCreator implements InventoryDumperCreator {
    
    @Override
    public InventoryDumper createInventoryDumper(final InventoryDumperConfiguration inventoryDumperConfig,
                                                 final PipelineChannel channel, final DataSource sourceDataSource,
                                                 final PipelineTableMetaDataLoader sourceMetaDataLoader) {
        return new PostgreSQLInventoryDumper(inventoryDumperConfig, channel, sourceDataSource, sourceMetaDataLoader);
    }
    
    @Override
    public String getType() {
        return "PostgreSQL";
    }
}
