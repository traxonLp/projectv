package de.traxonlp.projectv;

import de.traxonlp.projectv.Item.CreativeTabProjectV;
import de.traxonlp.projectv.Item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main implements ModInitializer {

    public static final String MOD_ID = "projectv";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItems.registerModItems();
        CreativeTabProjectV.registerCreativeTab();
    }
}
