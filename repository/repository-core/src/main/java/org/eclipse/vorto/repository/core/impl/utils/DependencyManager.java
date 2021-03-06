/**
 * Copyright (c) 2018 Contributors to the Eclipse Foundation
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.vorto.repository.core.impl.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.vorto.model.ModelId;
import org.eclipse.vorto.repository.core.ModelInfo;



public class DependencyManager {

  private Set<ModelInfo> resources = new HashSet<>();

  public DependencyManager() {

  }

  public DependencyManager(Set<ModelInfo> resources) {
    this.resources = resources;
  }

  public void addResource(ModelInfo resource) {
    this.resources.add(resource);
  }

  public List<ModelInfo> getSorted() {
    List<ModelInfo> sorted = new ArrayList<>();

    for (ModelInfo resource : resources) {
      addResourceRecursive(resource, sorted);
    }
    return sorted;
  }

  private void addResourceRecursive(ModelInfo resource, List<ModelInfo> sorted) {
    for (ModelId reference : resource.getReferences()) {
      ModelInfo referencedResource = findResource(reference);
      if (referencedResource != null) {
        addResourceRecursive(referencedResource, sorted);
      }
    }
    if (!sorted.contains(resource)) {
      sorted.add(resource);
    }
  }

  private ModelInfo findResource(final ModelId modelId) {
    for (ModelInfo resource : this.resources) {
      if (resource.getId().equals(modelId)) {
        return resource;
      }
    }
    return null;
  }
}
