package com.example.leaguechest;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by Jenny on 2017-10-06.
 */

public class ChampionHandler {

    private Context context;
    private ViewGroup container;

    public ChampionHandler () {
        this(null);
    }

    public ChampionHandler (Context context) {
        this.context = context;
    }

    // add view that the icon will be placed in as parameter??
    protected void DrawChampionIcon (int id, ViewGroup container) {
        new ChampionIcon().execute(new Integer[]{id});
        this.container = container;
    }

    protected String getChampionName (int id) {
        switch (id) {
            case 1:
                return "Annie";
            case 2:
                return "Olaf";
            case 3:
                return "Galio";
            case 4:
                return "Twisted Fate";
            case 5:
                return "Xin Zhao";
            case 6:
                return "Urgot";
            case 7:
                return "LeBlanc";
            case 8:
                return "Vladimir";
            case 9:
                return "Fiddlesticks";
            case 10:
                return "Kayle";
            case 11:
                return "Master Yi";
            case 12:
                return "Alistar";
            case 13:
                return "Ryze";
            case 14:
                return "Sion";
            case 15:
                return "Sivir";
            case 16:
                return "Soraka";
            case 17:
                return "Teemo";
            case 18:
                return "Tristana";
            case 19:
                return "Warwick";
            case 20:
                return "Nunu";
            case 21:
                return "Miss Fortune";
            case 22:
                return "Ashe";
            case 23:
                return "Tryndamere";
            case 24:
                return "Jax";
            case 25:
                return "Morgana";
            case 26:
                return "Zilean";
            case 27:
                return "Singed";
            case 28:
                return "Evelynn";
            case 29:
                return "Twitch";
            case 30:
                return "Karthus";
            case 31:
                return "Cho'Gath";
            case 32:
                return "Amumu";
            case 33:
                return "Rammus";
            case 34:
                return "Anivia";
            case 35:
                return "Shaco";
            case 36:
                return "Dr. Mundo";
            case 37:
                return "Sona";
            case 38:
                return "Kassadin";
            case 39:
                return "Irelia";
            case 40:
                return "Janna";
            case 41:
                return "Gangplank";
            case 42:
                return "Corki";
            case 43:
                return "Karma";
            case 44:
                return "Taric";
            case 45:
                return "Veigar";
            case 48:
                return "Trundle";
            case 50:
                return "Swain";
            case 51:
                return "Caitlyn";
            case 53:
                return "Blitzcrank";
            case 54:
                return "Malphite";
            case 55:
                return "Katarina";
            case 56:
                return "Nocturne";
            case 57:
                return "Maokai";
            case 58:
                return "Renekton";
            case 59:
                return "Jarvan IV";
            case 60:
                return "Elise";
            case 61:
                return "Orianna";
            case 62:
                return "Wukong";
            case 63:
                return "Brand";
            case 64:
                return "Lee Sin";
            case 67:
                return "Vayne";
            case 68:
                return "Rumble";
            case 69:
                return "Cassiopeia";
            case 72:
                return "Skarner";
            case 74:
                return "Heimerdinger";
            case 75:
                return "Nasus";
            case 76:
                return "Nidalee";
            case 77:
                return "Udyr";
            case 78:
                return "Poppy";
            case 79:
                return "Gragas";
            case 80:
                return "Pantheon";
            case 81:
                return "Ezreal";
            case 82:
                return "Mordekaiser";
            case 83:
                return "Yorick";
            case 84:
                return "Akali";
            case 85:
                return "Kennen";
            case 86:
                return "Garen";
            case 89:
                return "Leona";
            case 90:
                return "Malzahar";
            case 91:
                return "Talon";
            case 92:
                return "Riven";
            case 96:
                return "Kog'Maw";
            case 98:
                return "Shen";
            case 99:
                return "Lux";
            case 101:
                return "Xerath";
            case 102:
                return "Shyvana";
            case 103:
                return "Ahri";
            case 104:
                return "Graves";
            case 105:
                return "Fizz";
            case 106:
                return "Volibear";
            case 107:
                return "Rengar";
            case 110:
                return "Varus";
            case 111:
                return "Nautilus";
            case 112:
                return "Viktor";
            case 113:
                return "Sejuani";
            case 114:
                return "Fiora";
            case 115:
                return "Ziggs";
            case 117:
                return "Lulu";
            case 119:
                return "Draven";
            case 120:
                return "Hecarim";
            case 121:
                return "Kha'Zix";
            case 122:
                return "Darius";
            case 126:
                return "Jayce";
            case 127:
                return "Lissandra";
            case 131:
                return "Diana";
            case 133:
                return "Quinn";
            case 134:
                return "Syndra";
            case 136:
                return "Aurelion Sol";
            case 141:
                return "Kayn";
            case 143:
                return "Zyra";
            // FROM HERE + kayn, syndra, quinn, kha'zix, aurelion, elise, lissandra
            case 150:
                return "Gnar";
            case 154:
                return "Zac";
            case 157:
                return "Yasuo";
            case 161:
                return "Vel'Koz";
            case 163:
                return "Taliyah";
            case 201:
                return "Braum";
            case 202:
                return "Jhin";
            case 203:
                return "Kindred";
            case 222:
                return "Jinx";
            case 223:
                return "Tahm Kench";
            case 236:
                return "Lucian";
            case 238:
                return "Zed";
            case 240:
                return "Kled";
            case 245:
                return "Ekko";
            case 254:
                return "Vi";
            case 266:
                return "Aatrox";
            case 267:
                return "Nami";
            case 268:
                return "Azir";
            case 412:
                return "Thresh";
            case 420:
                return "Illaoi";
            case 421:
                return "Rek'Sai";
            case 427:
                return "Ivern";
            case 429:
                return "Kalista";
            case 432:
                return "Bard";
            case 497:
                return "Rakan";
            case 498:
                return "Xayah";
            case 516:
                return "Ornn";
            default:
                return Integer.toString(id);
        }
    }

    protected String getChampionIconName (int id) {
        switch (id) {
            case 1: return "Annie";
            case 2: return "Olaf";
            case 3: return "Galio";
            case 4: return "TwistedFate";
            case 5: return "XinZhao";
            case 6: return "Urgot";
            case 7: return "LeBlanc";
            case 8: return "Vladimir";
            case 9: return "Fiddlesticks";
            case 10: return "Kayle";
            case 11: return "MasterYi";
            case 12: return "Alistar";
            case 13: return "Ryze";
            case 14: return "Sion";
            case 15: return "Sivir";
            case 16: return "Soraka";
            case 17: return "Teemo";
            case 18: return "Tristana";
            case 19: return "Warwick";
            case 20: return "Nunu";
            case 21: return "MissFortune";
            case 22: return "Ashe";
            case 23: return "Tryndamere";
            case 24: return "Jax";
            case 25: return "Morgana";
            case 26: return "Zilean";
            case 27: return "Singed";
            case 28: return "Evelynn";
            case 29: return "Twitch";
            case 30: return "Karthus";
            case 31: return "Chogath";
            case 32: return "Amumu";
            case 33: return "Rammus";
            case 34: return "Anivia";
            case 35: return "Shaco";
            case 36: return "DrMundo";
            case 37: return "Sona";
            case 38: return "Kassadin";
            case 39: return "Irelia";
            case 40: return "Janna";
            case 41: return "Gangplank";
            case 42: return "Corki";
            case 43: return "Karma";
            case 44: return "Taric";
            case 45: return "Veigar";
            case 48: return "Trundle";
            case 50: return "Swain";
            case 51: return "Caitlyn";
            case 53: return "Blitzcrank";
            case 54: return "Malphite";
            case 55: return "Katarina";
            case 56: return "Nocturne";
            case 57: return "Maokai";
            case 58: return "Renekton";
            case 59: return "JarvanIV";
            case 60: return "Elise";
            case 61: return "Orianna";
            case 62: return "Wukong";
            case 63: return "Brand";
            case 64: return "LeeSin";
            case 67: return "Vayne";
            case 68: return "Rumble";
            case 69: return "Cassiopeia";
            case 72: return "Skarner";
            case 74: return "Heimerdinger";
            case 75: return "Nasus";
            case 76: return "Nidalee";
            case 77: return "Udyr";
            case 78: return "Poppy";
            case 79: return "Gragas";
            case 80: return "Pantheon";
            case 81: return "Ezreal";
            case 82: return "Mordekaiser";
            case 83: return "Yorick";
            case 84: return "Akali";
            case 85: return "Kennen";
            case 86: return "Garen";
            case 89: return "Leona";
            case 90: return "Malzahar";
            case 91: return "Talon";
            case 92: return "Riven";
            case 96: return "KogMaw";
            case 98: return "Shen";
            case 99: return "Lux";
            case 101: return "Xerath";
            case 102: return "Shyvana";
            case 103: return "Ahri";
            case 104: return "Graves";
            case 105: return "Fizz";
            case 106: return "Volibear";
            case 107: return "Rengar";
            case 110: return "Varus";
            case 111: return "Nautilus";
            case 112: return "Viktor";
            case 113: return "Sejuani";
            case 114: return "Fiora";
            case 115: return "Ziggs";
            case 117: return "Lulu";
            case 119: return "Draven";
            case 120: return "Hecarim";
            case 121: return "Khazix";
            case 122: return "Darius";
            case 126: return "Jayce";
            case 127: return "Lissandra";
            case 131: return "Diana";
            case 133: return "Quinn";
            case 134: return "Syndra";
            case 136: return "AurelionSol";
            case 141: return "Kayn";
            case 143: return "Zyra";
            case 150: return "Gnar";
            case 154: return "Zac";
            case 157: return "Yasuo";
            case 161: return "Velkoz";
            case 163: return "Taliyah";
            case 201: return "Braum";
            case 202: return "Jhin";
            case 203: return "Kindred";
            case 222: return "Jinx";
            case 223: return "TahmKench";
            case 236: return "Lucian";
            case 238: return "Zed";
            case 240: return "Kled";
            case 245: return "Ekko";
            case 254: return "Vi";
            case 266: return "Aatrox";
            case 267: return "Nami";
            case 268: return "Azir";
            case 412: return "Thresh";
            case 420: return "Illaoi";
            case 421: return "RekSai";
            case 427: return "Ivern";
            case 429: return "Kalista";
            case 432: return "Bard";
            case 497: return "Rakan";
            case 498: return "Xayah";
            case 516: return "Ornn";
            default: return Integer.toString(id);
        }
    }

    // Private class for doing network operations (server calls)
    private class ChampionIcon extends AsyncTask<Integer, Void, Drawable> {
        String iconName;
        String championName;

        @Override
        protected Drawable doInBackground(Integer[] params) {
            try {
                iconName = getChampionIconName(params[0]);
                championName = getChampionName(params[0]);

                String url = "http://ddragon.leagueoflegends.com/cdn/7.19.1/img/champion/" +
                        iconName + ".png";
                InputStream is = (InputStream) new URL(url).getContent();

                // Return drawable of champion icon
                return Drawable.createFromStream(is, "src name");
            } catch (Exception e) {
                Log.e("League Mastery", "Exception when setting image for champion " + championName,
                        e);
                Log.d("E", "error loading image for champion " + params[0]);
                return null;
            }
        }

        protected void onPostExecute(Drawable champIcon) {
            // TODO: check this.exception
            // TODO: do something with the feed

            Log.d("LEAGUE MASTERY", "Drawing image for " + championName);

            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            ViewGroup vg = (ViewGroup) vi.inflate(R.layout.champion_view, container, false);

            TextView champName = (TextView) vg.findViewById(R.id.champion_name);
            champName.setText(championName);

            ImageView champIcn = (ImageView) vg.findViewById(R.id.icon);
            champIcn.setImageDrawable(champIcon);
            container.addView(vg);
        }

    }
}

