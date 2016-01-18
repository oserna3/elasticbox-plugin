package com.elasticbox.jenkins.repository;

import com.elasticbox.jenkins.model.box.AbstractBox;
import com.elasticbox.jenkins.model.box.policy.PolicyBox;
import com.elasticbox.jenkins.model.box.script.ScriptBox;
import com.elasticbox.jenkins.repository.error.RepositoryException;

import java.util.List;

/**
 * Created by serna on 11/26/15.
 */
public interface BoxRepository {

    public List<AbstractBox> getNoPolicyBoxes(String workspace) throws RepositoryException;

    public List<PolicyBox> getCloudFormationPolicyBoxes(String workspace) throws RepositoryException;

    public List<PolicyBox> getNoCloudFormationPolicyBoxes(String workspace) throws RepositoryException;

    public AbstractBox getBox(String boxId) throws RepositoryException;

}