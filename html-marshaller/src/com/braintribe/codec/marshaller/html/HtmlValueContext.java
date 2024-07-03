// ============================================================================
// Copyright BRAINTRIBE TECHNOLOGY GMBH, Austria, 2002-2022
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
// ============================================================================
package com.braintribe.codec.marshaller.html;

import java.util.IdentityHashMap;
import java.util.Map;

import com.braintribe.codec.marshaller.api.GmSerializationOptions;
import com.braintribe.codec.marshaller.html.model.HtmlValue;
import com.braintribe.model.generic.GMF;
import com.braintribe.model.generic.reflection.EntityType;
import com.braintribe.model.generic.reflection.GenericModelType;

public class HtmlValueContext {
	private final Map<Object, HtmlValue> visitedObjects = new IdentityHashMap<>();
	private GenericModelType currentlyExpectedType;
	private GmSerializationOptions options;
	
	public HtmlValueContext(GmSerializationOptions options) {
		this.options = options;
	}

	public HtmlValue getVisitedObject(Object object) {
		return visitedObjects.get(object);
	}
	
	public <T extends HtmlValue> T registerObject(Object value, EntityType<T> entityType) {
		T htmlValue = entityType.create();
		
		if (value != null)
			visitedObjects.put(value, htmlValue);
		
		enrichHtmlValue(value, htmlValue, this);
		
		return htmlValue;
	}
	
	HtmlValueContext expectingType(GenericModelType type) {
		currentlyExpectedType = type;
		return this;
	}
	
	public GenericModelType getCurrentlyExpectedType() {
		return currentlyExpectedType;
	}
	
	public static void enrichHtmlValue(Object value, HtmlValue htmlValue, HtmlValueContext context) {
		htmlValue.setValue(value);
		String typeSignature = GMF.getTypeReflection().getType(value).getTypeSignature();
		htmlValue.setTypeSignature(typeSignature);
		htmlValue.setExpectedTypeSignature(context.currentlyExpectedType.getTypeSignature());
	}
	
	public GmSerializationOptions getOptions() {
		return options;
	}
}
