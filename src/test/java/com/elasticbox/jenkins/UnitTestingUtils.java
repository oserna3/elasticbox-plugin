package com.elasticbox.jenkins;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by serna on 12/3/15.
 */
public class UnitTestingUtils {

    private static String applicationBox = "{\n" +
            "\"updated\": \"2015-12-03 13:53:47.562301\",\n" +
            "\"description\": \"just to test that exists\",\n" +
            "\"created\": \"2015-12-03 13:53:47.562301\",\n" +
            "\"deleted\": null,\n" +
            "\"variables\": [],\n" +
            "\"uri\": \"/services/boxes/f616cc35-9d33-47d8-8ebd-7c8acebcd906\",\n" +
            "\"visibility\": \"workspace\",\n" +
            "\"name\": \"ApplicationBoxTest\",\n" +
            "\"owner\": \"operations\",\n" +
            "\"members\": [],\n" +
            "\"services\": [],\n" +
            "\"organization\": \"elasticbox\",\n" +
            "\"id\": \"f616cc35-9d33-47d8-8ebd-7c8acebcd906\",\n" +
            "\"schema\": \"http://elasticbox.net/schemas/boxes/application\"\n" +
            "}";

    private static  String  scriptBox = "{\n" +
            "\"updated\": \"2015-11-17 16:47:06.005841\",\n" +
            "\"automatic_updates\": \"off\",\n" +
            "\"requirements\": [\n" +
            "\"req1\",\n" +
            "\"req2\"\n" +
            "],\n" +
            "\"description\": \"desc of the box\",\n" +
            "\"name\": \"PruebaS3\",\n" +
            "\"created\": \"2015-11-05 23:47:02.643547\",\n" +
            "\"deleted\": null,\n" +
            "\"variables\": [],\n" +
            "\"uri\": \"/services/boxes/f3ef667a-2d3b-4846-af75-7d7996505a92\",\n" +
            "\"visibility\": \"workspace\",\n" +
            "\"id\": \"f3ef667a-2d3b-4846-af75-7d7996505a92\",\n" +
            "\"members\": [],\n" +
            "\"owner\": \"operations\",\n" +
            "\"organization\": \"elasticbox\",\n" +
            "\"events\": {},\n" +
            "\"schema\": \"http://elasticbox.net/schemas/boxes/script\"\n" +
            "}";

    private static String cloudFormationTemplatePolicyBox = "{\n" +
            "\"profile\": {\n" +
            "\"location\": \"ap-northeast-1\",\n" +
            "\"schema\": \"http://elasticbox.net/schemas/aws/cloudformation/profile\"\n" +
            "},\n" +
            "\"schema\": \"http://elasticbox.net/schemas/boxes/policy\",\n" +
            "\"provider_id\": \"77bb43a7-7122-44ba-aa6f-6f0886eccabd\",\n" +
            "\"automatic_updates\": \"off\",\n" +
            "\"name\": \"PolicyCF\",\n" +
            "\"created\": \"2015-11-30 10:46:45.554591\",\n" +
            "\"deleted\": null,\n" +
            "\"variables\": [],\n" +
            "\"updated\": \"2015-11-30 10:46:45.554591\",\n" +
            "\"lifespan\": {\n" +
            "\"operation\": \"none\"\n" +
            "},\n" +
            "\"uri\": \"/services/boxes/fa7472a4-c284-43c1-9b96-ada6965d365f\",\n" +
            "\"visibility\": \"workspace\",\n" +
            "\"members\": [],\n" +
            "\"claims\": [],\n" +
            "\"owner\": \"operations\",\n" +
            "\"organization\": \"elasticbox\",\n" +
            "\"id\": \"fa7472a4-c284-43c1-9b96-ada6965d365f\",\n" +
            "\"description\": \"Una policy para desplegar CF Template boxes\"\n" +
            "}";

    private static String policyBox = "{\n" +
            "\"profile\": {\n" +
            "\"subnet\": \"us-east-1a\",\n" +
            "\"cloud\": \"EC2\",\n" +
            "\"image\": \"Linux Compute\",\n" +
            "\"instances\": 1,\n" +
            "\"keypair\": \"None\",\n" +
            "\"location\": \"us-east-1\",\n" +
            "\"volumes\": [],\n" +
            "\"flavor\": \"m1.large\",\n" +
            "\"security_groups\": [\n" +
            "\"Automatic\"\n" +
            "],\n" +
            "\"schema\": \"http://elasticbox.net/schemas/aws/ec2/profile\"\n" +
            "},\n" +
            "\"provider_id\": \"77bb43a7-7122-44ba-aa6f-6f0886eccabd\",\n" +
            "\"automatic_updates\": \"off\",\n" +
            "\"name\": \"default-large-us-east-1\",\n" +
            "\"created\": \"2015-11-05 17:53:55.266635\",\n" +
            "\"deleted\": null,\n" +
            "\"variables\": [],\n" +
            "\"updated\": \"2015-11-17 16:47:06.000420\",\n" +
            "\"visibility\": \"workspace\",\n" +
            "\"uri\": \"/services/boxes/0308884a-d373-4e37-9e4f-70c1645cad0b\",\n" +
            "\"owner\": \"operations\",\n" +
            "\"members\": [],\n" +
            "\"organization\": \"elasticbox\",\n" +
            "\"readme\": {\n" +
            "\"url\": \"/resources/default_box_overview.md\",\n" +
            "\"upload_date\": \"2015-11-05 17:53:55.265901\",\n" +
            "\"length\": 1302,\n" +
            "\"content_type\": \"text/x-markdown\"\n" +
            "},\n" +
            "\"claims\": [\n" +
            "\"large\",\n" +
            "\"linux\"\n" +
            "],\n" +
            "\"id\": \"0308884a-d373-4e37-9e4f-70c1645cad0b\",\n" +
            "\"schema\": \"http://elasticbox.net/schemas/boxes/policy\"\n" +
            "}";

    private static String templateCloudFormationBox = "{\n" +
            "\"updated\": \"2015-11-26 10:11:54.669276\",\n" +
            "\"automatic_updates\": \"off\",\n" +
            "\"requirements\": [],\n" +
            "\"name\": \"CF Template\",\n" +
            "\"created\": \"2015-11-25 16:40:12.054144\",\n" +
            "\"deleted\": null,\n" +
            "\"type\": \"CloudFormation Service\",\n" +
            "\"variables\": [\n" +
            "{\n" +
            "\"required\": false,\n" +
            "\"type\": \"Text\",\n" +
            "\"name\": \"KeyName\",\n" +
            "\"value\": \"\",\n" +
            "\"visibility\": \"public\"\n" +
            "},\n" +
            "{\n" +
            "\"required\": false,\n" +
            "\"type\": \"Text\",\n" +
            "\"name\": \"InstanceType\",\n" +
            "\"value\": \"m1.small\",\n" +
            "\"visibility\": \"public\"\n" +
            "},\n" +
            "{\n" +
            "\"visibility\": \"public\",\n" +
            "\"type\": \"Text\",\n" +
            "\"name\": \"DBName\",\n" +
            "\"value\": \"wordpressdb\"\n" +
            "},\n" +
            "{\n" +
            "\"visibility\": \"public\",\n" +
            "\"type\": \"Text\",\n" +
            "\"name\": \"SSHLocation\",\n" +
            "\"value\": \"0.0.0.0/0\"\n" +
            "},\n" +
            "{\n" +
            "\"visibility\": \"public\",\n" +
            "\"type\": \"Text\",\n" +
            "\"name\": \"DBPassword\",\n" +
            "\"value\": \"\"\n" +
            "},\n" +
            "{\n" +
            "\"visibility\": \"public\",\n" +
            "\"type\": \"Text\",\n" +
            "\"name\": \"DBUser\",\n" +
            "\"value\": \"\"\n" +
            "},\n" +
            "{\n" +
            "\"visibility\": \"public\",\n" +
            "\"type\": \"Text\",\n" +
            "\"name\": \"DBRootPassword\",\n" +
            "\"value\": \"\"\n" +
            "}\n" +
            "],\n" +
            "\"description\": \"Tiene policy\",\n" +
            "\"uri\": \"/services/boxes/3d87d385-8710-47c3-951e-7112d8db25f4\",\n" +
            "\"visibility\": \"workspace\",\n" +
            "\"members\": [],\n" +
            "\"owner\": \"operations\",\n" +
            "\"organization\": \"elasticbox\",\n" +
            "\"template\": {\n" +
            "\"url\": \"/services/blobs/download/5656daea14841238d2f083a1/template.json\",\n" +
            "\"upload_date\": \"2015-11-26 10:11:54.628201\",\n" +
            "\"length\": 15489,\n" +
            "\"content_type\": \"text/x-shellscript\"\n" +
            "},\n" +
            "\"id\": \"3d87d385-8710-47c3-951e-7112d8db25f4\",\n" +
            "\"schema\": \"http://elasticbox.net/schemas/boxes/cloudformation\"\n" +
            "}";

    private static String managedCloudFormationBox = "{\n" +
            "\"profile\": {\n" +
            "\"range\": {\n" +
            "\"type\": \"none\",\n" +
            "\"name\": \"\"\n" +
            "},\n" +
            "\"capacity\": {\n" +
            "\"read\": 5,\n" +
            "\"write\": 5\n" +
            "},\n" +
            "\"location\": \"ap-northeast-1\",\n" +
            "\"key\": {\n" +
            "\"type\": \"str\",\n" +
            "\"name\": \"Key Name\"\n" +
            "},\n" +
            "\"schema\": \"http://elasticbox.net/schemas/aws/ddb/profile\"\n" +
            "},\n" +
            "\"schema\": \"http://elasticbox.net/schemas/boxes/cloudformation\",\n" +
            "\"provider_id\": \"77bb43a7-7122-44ba-aa6f-6f0886eccabd\",\n" +
            "\"automatic_updates\": \"off\",\n" +
            "\"requirements\": [],\n" +
            "\"name\": \"CF Managed\",\n" +
            "\"created\": \"2015-11-25 16:39:14.925122\",\n" +
            "\"deleted\": null,\n" +
            "\"variables\": [\n" +
            "{\n" +
            "\"visibility\": \"public\",\n" +
            "\"type\": \"Options\",\n" +
            "\"name\": \"key_type\",\n" +
            "\"value\": \"str\",\n" +
            "\"options\": \"int,long,float,str,unicode,Binary\"\n" +
            "},\n" +
            "{\n" +
            "\"type\": \"Text\",\n" +
            "\"visibility\": \"public\",\n" +
            "\"value\": \"str\",\n" +
            "\"name\": \"key_name\"\n" +
            "},\n" +
            "{\n" +
            "\"type\": \"Port\",\n" +
            "\"visibility\": \"public\",\n" +
            "\"value\": \"80\",\n" +
            "\"name\": \"port\"\n" +
            "},\n" +
            "{\n" +
            "\"type\": \"Text\",\n" +
            "\"visibility\": \"public\",\n" +
            "\"value\": \"\",\n" +
            "\"name\": \"range_name\"\n" +
            "},\n" +
            "{\n" +
            "\"visibility\": \"public\",\n" +
            "\"type\": \"Options\",\n" +
            "\"name\": \"range_type\",\n" +
            "\"value\": \"none\",\n" +
            "\"options\": \"none,int,long,float,str,unicode,Binary\"\n" +
            "},\n" +
            "{\n" +
            "\"type\": \"Number\",\n" +
            "\"visibility\": \"public\",\n" +
            "\"value\": \"5\",\n" +
            "\"name\": \"read_capacity_units\"\n" +
            "},\n" +
            "{\n" +
            "\"type\": \"Number\",\n" +
            "\"visibility\": \"public\",\n" +
            "\"value\": \"5\",\n" +
            "\"name\": \"write_capacity_units\"\n" +
            "}\n" +
            "],\n" +
            "\"updated\": \"2015-11-25 16:40:25.599207\",\n" +
            "\"visibility\": \"workspace\",\n" +
            "\"uri\": \"/services/boxes/02fab23c-5278-41ec-8d9e-0f7936582937\",\n" +
            "\"members\": [],\n" +
            "\"owner\": \"operations\",\n" +
            "\"organization\": \"elasticbox\",\n" +
            "\"type\": \"Dynamo DB Domain\",\n" +
            "\"id\": \"02fab23c-5278-41ec-8d9e-0f7936582937\",\n" +
            "\"description\": \"No tiene policy\"\n" +
            "}";


    public static JSONObject getFakeEmptyApplicationBox(){
        return (JSONObject) JSONSerializer.toJSON(applicationBox);
    }

    public static JSONObject getFakeScriptBox(){
        return (JSONObject) JSONSerializer.toJSON(scriptBox);
    }

    public static JSONObject getFakePolicyBox(){
        return (JSONObject) JSONSerializer.toJSON(policyBox);
    }

    public static JSONObject getFakeCloudFormationTemplatePolicyBox(){
        return (JSONObject) JSONSerializer.toJSON(cloudFormationTemplatePolicyBox);
    }

    public static JSONObject getFakeCloudFormationTemplateBox(){
        return (JSONObject) JSONSerializer.toJSON(templateCloudFormationBox);
    }

    public static JSONObject getFakeCloudFormationManagedBox(){
        return (JSONObject) JSONSerializer.toJSON(managedCloudFormationBox);
    }

    public static JSONObject [] getFakeArrayContainingOneFakeBoxForEachType(){
        return new JSONObject[]{
                getFakeScriptBox(),
                getFakePolicyBox(),
                getFakeCloudFormationTemplateBox(),
                getFakeCloudFormationManagedBox(),
                getFakeEmptyApplicationBox()
        };

    }

    public static JSONArray getFakeJSONArrayContainingOneFakeBoxForEachType(){
            final JSONArray array = new JSONArray();
            array.add(getFakeScriptBox());
            array.add(getFakePolicyBox());
            array.add(getFakeCloudFormationTemplateBox());
            array.add(getFakeCloudFormationManagedBox());
            array.add(getFakeEmptyApplicationBox());
            array.add(getFakeCloudFormationTemplatePolicyBox());
            return array;
    }

    public static JSONArray getJSONArrayFromFile(String file) throws IOException {
        InputStream is = UnitTestingUtils.class.getResourceAsStream(file);
        String jsonTxt = IOUtils.toString(is);
        return (JSONArray) JSONSerializer.toJSON(jsonTxt);
    }


}