package com.pluralsight.drink;

public enum CocktailMenu {
RANCH_WATER("Ranch Water",Liquor.TEQUILA,PourSize.SINGLE,GlassSize.TALL,Mixer.SODA_WATER,Garnish.LIME),
MARKY_MARK("Marky Mark",Liquor.RUM,PourSize.SINGLE,GlassSize.SHORT,Mixer.COKE,Garnish.LIME);
private String name;
private final Liquor liquor;
private final PourSize pourSize;
private final GlassSize glassSize;
private final Mixer mixer;
private final Garnish garnish;

CocktailMenu(String name,Liquor liquor, PourSize pourSize, GlassSize glassSize, Mixer mixer,Garnish garnish){
    this.name = name;
    this.liquor = liquor;
    this.pourSize =pourSize;
    this.glassSize = glassSize;
    this.mixer = mixer;
    this.garnish = garnish;
}

    public Liquor getLiquor() {
        return liquor;
    }

    public String getName() {
        return name;
    }

    public PourSize getPourSize() {
        return pourSize;
    }

    public GlassSize getGlassSize() {
        return glassSize;
    }

    public Mixer getMixer() {
        return mixer;
    }

    public Garnish getGarnish() {
        return garnish;
    }
    public void setName(String name) {
        this.name = name;
    }

}
