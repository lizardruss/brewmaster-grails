package org.brewmaster

class Hop extends Describable {
    String aroma;
    String origin;
    Range alphaAcidRange;

    static hasMany = [
            substitutes: Hop,
            uses: HopUsage
    ];

    static embedded = ['alphaAcidRange'];
}
