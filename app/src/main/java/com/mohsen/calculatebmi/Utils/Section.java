package com.mohsen.calculatebmi.Utils;

public interface Section {
    int HEADER = 0;
    int ITEM = 1;
    int CUSTOM_HEADER = 2;

    int type();

    int sectionPosition();
}
