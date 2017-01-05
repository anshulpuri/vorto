/**
 * Copyright (c) 2015-2016 Bosch Software Innovations GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v1.0 which accompany this distribution.
 *
 * The Eclipse Public License is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 * Bosch Software Innovations GmbH - Please refer to git log
 */
package org.eclipse.vorto.http.model;

import java.util.ArrayList;
import java.util.List;

public class EntityModelDto extends AbstractModelDto {

	public EntityModelDto(ModelIdDto modelId, ModelTypeDto modelType) {
		super(modelId, modelType);
	}

	private List<ModelPropertyDto> properties = new ArrayList<ModelPropertyDto>();
		
	public List<ModelPropertyDto> getProperties() {
		return properties;
	}

	public void setProperties(List<ModelPropertyDto> properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "EntityModelDto [properties=" + properties + "]";
	}
	
	

}