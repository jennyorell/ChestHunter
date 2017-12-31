package com.example.leaguechest;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.api.endpoints.summoner.dto.Summoner;
import net.rithms.riot.constant.Platform;

/**
 * This example demonstrates using the RiotApi to request summoner information for a given summoner name
 */
public class SummonerExample {

    public static void main(String[] args) throws RiotApiException {
        ApiConfig config = new ApiConfig().setKey("RGAPI-16c6e9a9-f179-4856-841d-524490355c66");
        RiotApi api = new RiotApi(config);

        Summoner summoner = api.getSummonerByName(Platform.NA, "tryndamere");

        System.out.println("Name: " + summoner.getName());
        System.out.println("Summoner ID: " + summoner.getId());
        System.out.println("Account ID: " + summoner.getAccountId());
        System.out.println("Summoner Level: " + summoner.getSummonerLevel());
        System.out.println("Profile Icon ID: " + summoner.getProfileIconId());
    }
}