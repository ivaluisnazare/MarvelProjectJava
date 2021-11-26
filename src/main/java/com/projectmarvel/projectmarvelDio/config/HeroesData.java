package com.projectmarvel.projectmarvelDio.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import static com.projectmarvel.projectmarvelDio.constants.HeroesConstant.ENDPOINT_DYNAMO;
import static com.projectmarvel.projectmarvelDio.constants.HeroesConstant.REGION_DYNAMO;

public class HeroesData {
    public static void main(String[] args) throws Exception {

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
                .build();
        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("Heroes_Table");

        Item hero = new Item()
                .withPrimaryKey("id", "1")
                .withString("name", "WOLVERINE")
                .withString("universe", "COMICS")
                .withNumber("films", 4);

        Item hero2 = new Item()
                .withPrimaryKey("id", "3")
                .withString("name", "LUKE CAGE")
                .withString("universe", "COMICS")
                .withNumber("films", 0);

        Item hero3 = new Item()
                .withPrimaryKey("id", "5")
                .withString("name", "VENOM")
                .withString("universe", "COMICS")
                .withNumber("films", 2);

        PutItemOutcome outcome1 = table.putItem(hero);
        PutItemOutcome outcome2 = table.putItem(hero2);
        PutItemOutcome outcome3 = table.putItem(hero3);

    }
}
