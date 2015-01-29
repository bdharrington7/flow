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

package com.lithium.flow.db;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Nonnull;

/**
 * @author Matt Ayres
 */
public interface Database extends Closeable {
	@Nonnull
	Schema getSchema(@Nonnull String name);

	@Nonnull
	Connection getConnection(@Nonnull String name) throws SQLException;
}
