/*******************************************************************************
 * Copyright (c) 2016 Francisco Gonzalez-Armijo Riádigos
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
 ******************************************************************************/

package com.kuassivi.october.compiler;

import java.util.Set;

import javax.lang.model.element.Element;

/**
 * @author Francisco Gonzalez-Armijo
 */
public class ValidationException extends Exception {

    Set<String> messages;
    Element element;

    public ValidationException(Element element, Set<String> messages) {
        this.element = element;
        this.messages = messages;
    }

    public Element getElement() {
        return element;
    }

    public Set<String> getMessages() {
        return messages;
    }
}
