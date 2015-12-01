package com.elasticbox.jenkins.repository.api.criteria;

import com.elasticbox.jenkins.model.error.ElasticBoxModelException;
import com.elasticbox.jenkins.repository.api.factory.Factory;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by serna on 11/26/15.
 */
public abstract class AbstractJSONCriteria<T> implements JSONCriteria<T> {

    private Factory<T> factory;

    public AbstractJSONCriteria(Factory<T> factory) {
        this.factory = factory;
    }

    abstract boolean fits(JSONObject jsonObject);

    @Override
    public List<T> fits(JSONArray array){
        List<T> matched = new ArrayList<>();
            for (Iterator iter = array.iterator(); iter.hasNext();) {
                try {
                    JSONObject jsonObject = (JSONObject) iter.next();
                    if(fits(jsonObject))
                        matched.add(factory.create(jsonObject));

                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (ElasticBoxModelException e) {
                    e.printStackTrace();
                }
            }
        return  matched;
    }

}
