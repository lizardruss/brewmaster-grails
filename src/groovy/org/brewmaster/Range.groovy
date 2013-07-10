package org.brewmaster

class Range {

    Double from;
    Double to;

    String toString() {
        "${from}..${to}"
    }

    def contains(Double value) {
        return from.compareTo(value) <= 0 && to.compareTo(value) >=0;
    }

    static constraints = {
        from nullable: false;
        to nullable: false;
    }
}
