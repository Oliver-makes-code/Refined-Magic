package olivermakesco.de.refmagic.item;

public class FireNecklaceItem extends BaseNecklaceItem {
    public FireNecklaceItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean isFireproof() {
        return true;
    }
}
