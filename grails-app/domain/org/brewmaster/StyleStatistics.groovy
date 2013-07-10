package org.brewmaster

class StyleStatistics extends Describable {
    Range alcoholByVolume;
    Range bitterness;
    Range color;
    Range finalGravity;
    Range originalGravity;

    static embedded = ['alcoholByVolume', 'bitterness', 'color', 'finalGravity', 'originalGravity'];
}
