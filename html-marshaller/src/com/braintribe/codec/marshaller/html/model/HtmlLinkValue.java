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
package com.braintribe.codec.marshaller.html.model;

import com.braintribe.model.generic.reflection.EntityType;
import com.braintribe.model.generic.reflection.EntityTypes;

/**
 * @author Christina Wilpernig
 * @author Neidhart.Orlich
 */

public interface HtmlLinkValue extends HtmlValue {

	final EntityType<HtmlLinkValue> T = EntityTypes.T(HtmlLinkValue.class);

	public HtmlValue getLinked();
	public void setLinked(HtmlValue linked);
	
	@Override
	default RenderType renderType() {
		return RenderType.link;
	}
	
}
