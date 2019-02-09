package theDefault.relics;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.relics.AbstractRelic;

import basemod.abstracts.CustomRelic;
import theDefault.DefaultMod;

public class PlaceholderRelic2 extends CustomRelic {
    /*
     * https://github.com/daviscook477/BaseMod/wiki/Custom-Relics
     * 
     * At the start of each combat, gain 1 Strength (i.e. Vajra)
     */
    
    // ID, images, text.
    public static final String ID = theDefault.DefaultMod.makeID("PlaceholderRelic2");
    public static final String IMG = "theDefaultResources/images/relics/placeholder_relic2.png";
    public static final String OUTLINE = "theDefaultResources/images/relics/outline/placeholder_relic2.png";

    public PlaceholderRelic2() {
        super(ID, ImageMaster.loadImage(IMG), new Texture(OUTLINE), RelicTier.COMMON, LandingSound.MAGICAL);
    }


    // Gain 1 Strength on on equip.
    @Override
    public void atBattleStart() {
        flash();
        AbstractDungeon.actionManager.addToTop(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new StrengthPower(AbstractDungeon.player, 1), 1));
        AbstractDungeon.actionManager.addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));
    }
    

    // Description
    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }

    // Which relic to return on making a copy of this relic.
    @Override
    public AbstractRelic makeCopy() {
        return new PlaceholderRelic2();
    }
}
