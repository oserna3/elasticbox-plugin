/*
 * ElasticBox Confidential
 * Copyright (c) 2014 All Right Reserved, ElasticBox Inc.
 *
 * NOTICE:  All information contained herein is, and remains the property
 * of ElasticBox. The intellectual and technical concepts contained herein are
 * proprietary and may be covered by U.S. and Foreign Patents, patents in process,
 * and are protected by trade secret or copyright law. Dissemination of this
 * information or reproduction of this material is strictly forbidden unless prior
 * written permission is obtained from ElasticBox.
 */

package com.elasticbox.jenkins.builders;

import com.elasticbox.jenkins.model.instance.Instance;
import com.elasticbox.jenkins.model.repository.api.deserializer.transformer.instances.InstanceTransformer;

import hudson.model.AbstractBuild;

import net.sf.json.JSONObject;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class InstanceManager {
    private final Map<String, Instance> buildIdToInstanceMap;

    public InstanceManager() {
        buildIdToInstanceMap = new ConcurrentHashMap<String, Instance>();
    }

    public Instance getInstance(AbstractBuild build) {
        return buildIdToInstanceMap.get(build.getId());
    }

    public void setInstance(AbstractBuild build, JSONObject jsonInstance) {

        final Instance instance = new InstanceTransformer().apply(jsonInstance);
        this.setInstance(build, instance);

    }

    public void setInstance(AbstractBuild build, Instance instance) {

        buildIdToInstanceMap.put(build.getId(), instance);

        for (Iterator<String> iter = buildIdToInstanceMap.keySet().iterator(); iter.hasNext();) {

            Object currentBuild = build.getProject().getBuild(iter.next());

            if (!(currentBuild instanceof AbstractBuild) || !((AbstractBuild) currentBuild).isBuilding()) {
                iter.remove();
            }
        }
    }

}
