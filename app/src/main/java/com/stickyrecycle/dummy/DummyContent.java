package com.stickyrecycle.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static final int COUNT = 99;
    public static final int ITEM_HEADER = 123;
    public static final int ITEM_HEADER_PENDING = 234;
    public static final int ITEM_COLUMN = 321;
    public static final int ITEM_COLUMN_PENDING = 432;

    static {
        // Add some sample items.
        for (int i = 0; i < COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static DummyItem createDummyItem(int position) {
        if (position < 9) {
            return new DummyItem(String.valueOf(position), "Item " + position, makeDetails(position), ((position % 9 == 0) ? ITEM_HEADER_PENDING : ITEM_COLUMN_PENDING));
        }
        return new DummyItem(String.valueOf(position), "Item " + position, makeDetails(position), ((position % 9 == 0) ? ITEM_HEADER : ITEM_COLUMN));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String id;
        public final String content;
        public final String details;
        public final int itemType;

        public DummyItem(String id, String content, String details, int itemType) {
            this.id = id;
            this.itemType = itemType;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
