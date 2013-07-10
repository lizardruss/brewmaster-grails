package org.brewmaster

class Recipe extends Describable {

    static hasMany = [
            hops: Hop,
            malts: Malt
    ];

}
