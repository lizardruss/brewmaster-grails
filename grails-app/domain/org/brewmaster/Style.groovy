package org.brewmaster

class Style extends Describable {
    String appearance;
    String aroma;
    String comments;
    String flavor;
    String history;
    String impression;
    String ingredients;
    String mouthfeel;

    static hasMany = [
            statistics: StyleStatistics
    ];

    static mapping = {
        statistics column: 'style_style_statistics_id'
    };
}
