package org.brewmaster



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Range)
class RangeTests {

    void testContains() {
        Range range = new Range(from: 4.5, to: 9.0);
        assert range.contains(5.5);
    }

    void testDoesntContains() {
        Range range = new Range(from: 4.5, to: 9.0);
        assert !range.contains(12);
    }
}
