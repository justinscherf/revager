package org.revager.test.app.comparators;

import org.junit.jupiter.api.Test;
import org.revager.app.comparators.AspectComparator;
import org.revager.app.model.schema.Aspect;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AspectComparatorTest {

    /*
     * Test overwritten compare-function
     */
    @Test
    public void testCompare() {
        AspectComparator aspectComparator = new AspectComparator();

        Aspect asp1 = new Aspect();
        asp1.setId("Test id 1");
        asp1.setCategory("Test Category 1");
        asp1.setDescription("Test Description 1");
        asp1.setDirective("Test Directive 1");

        Aspect asp2 = new Aspect(); // with same values as asp1
        asp2.setId(asp1.getId());
        asp2.setCategory(asp1.getCategory());
        asp2.setDescription(asp1.getDescription());
        asp2.setDirective(asp1.getDirective());

        // should return 0 because asp1 equals asp2
        assertEquals(0, aspectComparator.compare(asp1, asp2));

        asp2.setCategory("Test Category 2"); // change category of asp2
        // should return -1 (difference of chars at last index of String)
        assertEquals(-1, aspectComparator.compare(asp1, asp2));

        asp2.setDescription("Test Description 2"); // change description of asp2
        // should return -1 (difference of chars at last index of String)
        assertEquals(-1, aspectComparator.compare(asp1, asp2));

        asp2.setDirective("Test Directive 2"); // change directive of asp2
        // should return -1 (difference of chars at last index of String)
        assertEquals(-1, aspectComparator.compare(asp1, asp2));
    }
}