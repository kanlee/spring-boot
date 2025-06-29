/*
 * Copyright 2012-present the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.boot.loader.jarmode;

import java.util.Arrays;

/**
 * {@link JarMode} for testing.
 *
 * @author Phillip Webb
 */
class TestJarMode implements JarMode {

	@Override
	public boolean accepts(String mode) {
		return "test".equals(mode);
	}

	@Override
	public void run(String mode, String[] args) {
		System.out.println("running in " + mode + " jar mode " + Arrays.asList(args));
		if (args.length > 0 && "error".equals(args[0])) {
			throw new JarModeErrorException("error message");
		}
		if (args.length > 0 && "fail".equals(args[0])) {
			throw new IllegalStateException("bad");
		}
	}

}
