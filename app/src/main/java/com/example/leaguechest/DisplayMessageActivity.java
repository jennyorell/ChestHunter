package com.example.leaguechest;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.rithms.riot.api.ApiConfig;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiAsync;
import net.rithms.riot.api.endpoints.static_data.dto.Champion;
import net.rithms.riot.api.endpoints.champion_mastery.dto.ChampionMastery;
import net.rithms.riot.api.endpoints.league.constant.LeagueQueue;
import net.rithms.riot.api.endpoints.league.dto.LeaguePosition;
import net.rithms.riot.api.endpoints.static_data.dto.Image;
import net.rithms.riot.api.endpoints.summoner.dto.Summoner;
import net.rithms.riot.constant.Platform;
import net.rithms.riot.api.RiotApiException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Retrieve summoner data and print on new screen.
        new FindSummoner().execute(new String[]{message});
    }

    // Inner class to store information in
    private class ExtendedSummoner {
        public Summoner summoner;
        public String tier;
        public ChampionMastery firstMastery;
        public Champion firstChampion;
        public ChampionMastery secondMastery;
        public Champion secondChampion;
        public ChampionMastery thirdMastery;
        public Champion thirdChampion;

        public String masteryList;
        public int nbrOfChests = 0;

        public List<Integer> chestChampions = new ArrayList<Integer>();
    }


    // Private class for doing network operations (server calls)
    private class FindSummoner extends AsyncTask<String, Void, ExtendedSummoner> {
        private Exception exception;

        @Override
        protected ExtendedSummoner doInBackground(String[] params) {

            String key = ""; // Insert Riot API key here!
            ApiConfig config = new ApiConfig().setKey(key);
            RiotApi api = new RiotApi(config);
            Platform platform = Platform.EUW;
            Summoner summoner;
            long summonerId;
            final ExtendedSummoner eSummoner = new ExtendedSummoner(); // Object where we want to store the data
            Set<LeaguePosition> leaguePos;

            try {
                summoner = api.getSummonerByName(platform, params[0]);
                eSummoner.summoner = summoner;
                summonerId = summoner.getId();

                // Get the summoner's ranked SOLO/DUO tier and rank.
                /*leaguePos = api.getLeaguePositionsBySummonerId(platform, summonerId);
                if (leaguePos == null || leaguePos.isEmpty()) {
                    eSummoner.tier = "unranked";
                }
                for (LeaguePosition pos : leaguePos) {
                    if (pos.getQueueType().equals(LeagueQueue.RANKED_SOLO_5x5.name())) {
                        eSummoner.tier = pos.getTier() + " " + pos.getRank();
                    }
                }*/

                // Placeholder to reduce nbr of API calls. Should be replaced with the code above.
                eSummoner.tier = "GOLD V";

                // Get champion masteries
                List<ChampionMastery> masteries = api.getChampionMasteriesBySummoner(platform, summonerId);
                eSummoner.masteryList = "";
                ChampionHandler ch = new ChampionHandler();

                for (int i=0; i<masteries.size(); i++) {
                    if (masteries.get(i).isChestGranted()) {
                        eSummoner.nbrOfChests ++;
                        //eSummoner.masteryList += ch.getChampionName(masteries.get(i).getChampionId()) + ", ";

                        eSummoner.chestChampions.add(masteries.get(i).getChampionId());
                    }
                }

            } catch (RiotApiException e) {
                Log.e("League Mastery", "EXCEPTION", e);
                return null;
            }

            Log.i("eSummoner status", eSummoner + "");
            return eSummoner;
        }

        // Updates UI, receives result from doInBackground()
        @Override
        protected void onPostExecute(ExtendedSummoner eSum) {
            // Capture the layout's TextView and set the string as its text

            if (eSum == null) {
                TextView textView = (TextView) findViewById(R.id.summoner_name);
                textView.setText("Summoner not found.");
                return;
            }

            TextView textView = (TextView) findViewById(R.id.summoner_name);
            textView.setText(eSum.summoner.getName());

            //textView = (TextView) findViewById(R.id.summoner_level);
            //textView.setText("Level " + eSum.summoner.getSummonerLevel());

            textView = (TextView) findViewById(R.id.summoner_rank);
            textView.setText(eSum.tier);

            textView = (TextView) findViewById(R.id.chestView);
            textView.setText(eSum.nbrOfChests + " chests aquired this season");

            // Draw ChampionView element for champions with aquired chest
            ChampionHandler ch = new ChampionHandler(DisplayMessageActivity.this);
            for (int id : eSum.chestChampions) {
                ch.DrawChampionIcon(id, (ViewGroup)findViewById(R.id.champion_list));
            }

        }
    }
}