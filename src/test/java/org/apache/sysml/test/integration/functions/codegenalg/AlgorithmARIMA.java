/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.sysml.test.integration.functions.codegenalg;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.File;

import org.apache.sysml.test.integration.applications.ArimaTest;

@RunWith(value = Parameterized.class)
public class AlgorithmARIMA extends ArimaTest 
{
	private final static String LOCAL_TEST_DIR = "functions/codegenalg/";
	private final static String TEST_CONF = "SystemML-config-codegen.xml";
	private final static File   TEST_CONF_FILE = new File(SCRIPT_DIR + LOCAL_TEST_DIR, TEST_CONF);
	
	public AlgorithmARIMA(int m, int p, int d, int q, int P, int D, int Q, int s, int include_mean, int useJacobi) {
		super(m, p, d, q, P, D, Q, s, include_mean, useJacobi);
		TEST_CLASS_DIR = TEST_DIR + AlgorithmARIMA.class.getSimpleName() + "/";
	}

	@Test
	public void testArimaDml() {
		testArima(ScriptType.DML);
	}
	
	@Override
	protected File getConfigTemplateFile() {
		System.out.println("This test case overrides default configuration with " + TEST_CONF_FILE.getPath());
		return TEST_CONF_FILE;
	}
}
