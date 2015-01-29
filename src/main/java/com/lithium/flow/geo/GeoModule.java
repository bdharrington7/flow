/*
 * Copyright 2015 Lithium Technologies, Inc.
 *
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
 */

package com.lithium.flow.geo;

import static com.google.common.base.Preconditions.checkNotNull;

import com.lithium.flow.config.Config;

import java.io.File;

import javax.annotation.Nonnull;

/**
 * @author Matt Ayres
 */
public class GeoModule {
	@Nonnull
	public static GeoProvider buildGeoProvider(@Nonnull Config config) {
		checkNotNull(config);

		String database = config.getString("geo.database");
		File file = new File(database);
		if (!file.exists()) {
			throw new RuntimeException("no database: " + file);
		}

		String reader = config.getString("geo.reader", MaxMindGeoReader.class.getName());
		try {
			GeoReader instance = (GeoReader) Class.forName(reader).newInstance();
			return new FastGeoProvider(instance.readBlocks(file));
		} catch (Exception e) {
			throw new RuntimeException("failed to build reader: " + reader, e);
		}
	}
}
