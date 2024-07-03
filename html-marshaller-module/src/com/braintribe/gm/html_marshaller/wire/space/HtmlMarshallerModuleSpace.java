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
package com.braintribe.gm.html_marshaller.wire.space;

import com.braintribe.codec.marshaller.html.HtmlMarshaller;
import com.braintribe.wire.api.annotation.Import;
import com.braintribe.wire.api.annotation.Managed;

import tribefire.module.wire.contract.HardwiredMarshallersContract;
import tribefire.module.wire.contract.TribefireModuleContract;
import tribefire.module.wire.contract.TribefirePlatformContract;

/**
 * This module's javadoc is yet to be written.
 */
@Managed
public class HtmlMarshallerModuleSpace implements TribefireModuleContract {

	@Import
	private TribefirePlatformContract tfPlatform;
	
	@Import
	private HardwiredMarshallersContract hardwiredMarshallers;

	@Override
	public void bindHardwired() {
		hardwiredMarshallers.bindMarshaller("marshaller.html", "HTML Marshaller", this::htmlMarshaller, "text/html;spec=temp");
	}
	
	@Managed
	private HtmlMarshaller htmlMarshaller() {
		return new HtmlMarshaller();
	}

}
