/*
 * (C) Copyright 2019 Boni Garcia (http://bonigarcia.github.io/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package io.github.bonigarcia.wdm.test;

import static java.lang.invoke.MethodHandles.lookup;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Test asserting Edge driver versions.
 *
 * @author Boni Garcia (boni.gg@gmail.com)
 * @since 3.5.0
 */
public class EdgeReadVersionTest {

    final Logger log = getLogger(lookup().lookupClass());

    @Test
    public void edgeVersionsTest() {
        String[] expectedVersions = { "1.10240", "2.10586", "3.14393",
                "4.15063", "5.16299", "6.17134", "75.0.137.0" };
        List<String> versions = WebDriverManager.edgedriver().getVersions();

        log.debug("Expected edge versions: {}",
                Arrays.asList(expectedVersions));
        log.debug("Edge versions read from the web page: {}", versions);

        assertThat(versions, contains(expectedVersions));
    }

}