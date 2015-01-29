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

package com.lithium.flow.matcher;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.regex.Pattern;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @author Matt Ayres
 */
public class RegexStringMatcher implements StringMatcher {
	private final Pattern pattern;

	public RegexStringMatcher(@Nonnull String regex) {
		pattern = Pattern.compile(checkNotNull(regex));
	}

	@Override
	public boolean matches(@Nullable String input) {
		return input != null && pattern.matcher(input).matches();
	}
}
