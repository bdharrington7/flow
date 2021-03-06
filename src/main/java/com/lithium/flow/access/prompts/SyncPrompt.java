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

package com.lithium.flow.access.prompts;

import static com.google.common.base.Preconditions.checkNotNull;

import com.lithium.flow.access.Prompt;

import javax.annotation.Nonnull;

/**
 * @author Matt Ayres
 */
public class SyncPrompt implements Prompt {
	private final Prompt delegate;

	public SyncPrompt(@Nonnull Prompt delegate) {
		this.delegate = checkNotNull(delegate);
	}

	@Override
	@Nonnull
	public synchronized Response prompt(@Nonnull String name, @Nonnull String message, @Nonnull Type type) {
		return delegate.prompt(name, message, type);
	}
}
