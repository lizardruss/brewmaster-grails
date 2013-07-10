package org.brewmaster

abstract class Describable {

    String name;
    String description;

    String toString() { "${name}" }

    static constraints = {
        name blank: false;
        description blank: false, maxSize: 1024;
    }

    static mapping = {
        tablePerHierarchy false
    }

}
