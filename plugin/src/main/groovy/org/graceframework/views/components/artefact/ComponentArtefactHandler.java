/*
 * Copyright 2022-2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.graceframework.views.components.artefact;

import grace.views.GrailsComponentClass;
import grails.core.ArtefactHandlerAdapter;
import org.graceframework.views.components.component.DefaultGrailsComponentClass;

/**
 * Grails View Component.
 *
 * <p>This class is responsible for looking up component classes for views.</p>
 *
 * @author Michael Yan
 * @since 0.0.1
*/
public class ComponentArtefactHandler extends ArtefactHandlerAdapter {

    public static final String TYPE = "Component";
    public static final String PLUGIN_NAME = "viewComponents";

    public ComponentArtefactHandler() {
        super(TYPE, GrailsComponentClass.class, DefaultGrailsComponentClass.class,
                DefaultGrailsComponentClass.COMPONENT, false);
    }

    @Override
    public String getPluginName() {
        return PLUGIN_NAME;
    }

}
