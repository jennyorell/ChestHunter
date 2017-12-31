package com.example.leaguechest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Jenny on 2017-10-06.
 */

public class ChampionView extends ViewGroup {

    public TextView name;
    public ImageView image;
    private ChampionHandler ch;
    private String championName;
    private int championID;

    public ChampionView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ChampionView(Context context, AttributeSet attrs, int id) {
        super(context, attrs);

        this.ch = new ChampionHandler();
        this.championName = ch.getChampionName(id);
        this.championID = id;

        init();
    }

    public ChampionView(Context context, AttributeSet attrs, String name) {
        super(context, attrs);

        this.ch = new ChampionHandler();
        this.championName = name;

        init();
    }

    /**
     * Position all children within this layout.
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    private void init() {
        inflate(getContext(), R.layout.champion_view, this);

        //LayoutInflater inflater = LayoutInflater.from(getContext());
        //inflater.inflate(R.layout.champion_view, this);

        //this.name = (TextView) this.findViewById(R.id.champion_name);
        TextView v = (TextView) this.findViewById(R.id.champion_name);
        v.setText(championName);

        this.image = (ImageView) this.findViewById(R.id.icon);
        //this.image.setBackgroundDrawable(ch.LoadImageFromWebOperations(championName));
    }

    /**
     * Inflates the views in the layout.
     *
     * @param context
     *           the current context for the view.
     */
    /*private void initializeViews(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.champion_view, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        // Sets the images for the previous and next buttons. Uses
        // built-in images so you don't need to add images, but in
        // a real application your images should be in the
        // application package so they are always available.
        this.name = (TextView) this.findViewById(R.id.name);

        this.image = (ImageView) this.findViewById(R.id.image);

        this.image.setBackgroundDrawable(ch.LoadImageFromWebOperations(championName));
    }*/
}
