package com.elasticbox.jenkins.model.repository.api.criteria.box;

import com.elasticbox.Constants;
import com.elasticbox.jenkins.model.box.BoxType;
import com.elasticbox.jenkins.model.repository.api.criteria.AbstractJSONCriteria;
import com.elasticbox.jenkins.model.repository.api.factory.box.BoxFactory;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by serna on 11/27/15.
 */
public abstract class BoxJSONCriteria<T> extends AbstractJSONCriteria<T> {


    public BoxJSONCriteria(BoxFactory<T> factory) {
        super(factory);
    }

    abstract boolean performFit(JSONObject jsonObject);

    @Override
    protected boolean fits(JSONObject jsonObject) {

        if(!BoxType.isBox(jsonObject.getString("schema")))
            return false;

        if(Constants.SERVICES_BOXES_TO_BE_EXCLUDED.containsKey(jsonObject.getString("name"))){
            return false;
        }

        return performFit(jsonObject);
    }


}