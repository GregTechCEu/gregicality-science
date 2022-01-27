package gregicality.science.common.items;

import gregtech.api.items.metaitem.StandardMetaItem;

import static gregicality.science.common.items.GCYSMetaItems.MAGNETRON;

public class GCYSMetaItem1 extends StandardMetaItem {

    public GCYSMetaItem1() {
        super();
    }

    @Override
    public void registerSubItems() {
        MAGNETRON = addItem(0, "magnetron");
    }
}
