package org.semanticweb.owlapi.gwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.rpc.AsyncCallback;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.vocab.OWL2Datatype;
import uk.ac.manchester.cs.owl.owlapi.*;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 19/11/2013
 * <p>
 *     This class name is prefixed with GwtTest so that it is recognized by the maven GWT plugin as a GWTTestCase.
 *     Also, it does not end with "TestCase" so that it is not picked up by the maven sure fire plugin and run
 *     as a regular test case.
 * </p>
 */
public class GwtTest_OWLObject_Serialization extends GWTTestCase {

    public static final int TEST_DELAY_MS = 10000;

    @Override
    public String getModuleName() {
        return "org.semanticweb.owlapi.gwt.OWLObjectSerializationTestsJUnit";
    }

    public void testShouldSerializeAxiomType() {
        delayTestFinish(TEST_DELAY_MS);
        final AxiomType<?> in = AxiomType.ANNOTATION_ASSERTION;
        OWLObjectSerializationTestsServiceAsync service = GWT.create(OWLObjectSerializationTestsService.class);
        service.testAxiomType(in, new AsyncCallback<AxiomType<?>>() {
            @Override
            public void onFailure(Throwable throwable) {
                fail(throwable.getMessage());
            }

            @Override
            public void onSuccess(AxiomType<?> out) {
                assertEquals(in, out);
                finishTest();
            }
        });
    }

    public void testShouldSerializeEntityType() {
        delayTestFinish(TEST_DELAY_MS);
        final EntityType<?> in = EntityType.CLASS;
        OWLObjectSerializationTestsServiceAsync service = GWT.create(OWLObjectSerializationTestsService.class);
        service.testEntityType(in, new AsyncCallback<EntityType<?>>() {
            @Override
            public void onFailure(Throwable throwable) {
                fail(throwable.getMessage());
            }

            @Override
            public void onSuccess(EntityType<?> out) {
                assertEquals(in, out);
                finishTest();
            }
        });
    }

    public void testShouldSerializeIRI() {
        delayTestFinish(TEST_DELAY_MS);
        final IRI in = IRI.create("http://stuff.com/A");
        OWLObjectSerializationTestsServiceAsync service = GWT.create(OWLObjectSerializationTestsService.class);
        service.testIRI(in, new AsyncCallback<IRI>() {
            @Override
            public void onFailure(Throwable throwable) {
                fail(throwable.getMessage());
            }

            @Override
            public void onSuccess(IRI out) {
                assertEquals(in, out);
                finishTest();
            }
        });
    }

    public void testShouldSerializeOWLOntologyID() {
        delayTestFinish(TEST_DELAY_MS);
        final OWLOntologyID in = new OWLOntologyID(IRI.create("http://stuff.com/A"));
        OWLObjectSerializationTestsServiceAsync service = GWT.create(OWLObjectSerializationTestsService.class);
        service.testOWLOntologyId(in, new AsyncCallback<OWLOntologyID>() {
            @Override
            public void onFailure(Throwable throwable) {
                fail(throwable.getMessage());
            }

            @Override
            public void onSuccess(OWLOntologyID out) {
                assertEquals(in, out);
                finishTest();
            }
        });
    }
    
    public void testShouldSerializeOWLClassImpl() {
        delayTestFinish(TEST_DELAY_MS);
        final OWLClassImpl in = new OWLClassImpl(IRI.create("http://org.semanticweb.owlapi.gwt#A"));
        OWLObjectSerializationTestsServiceAsync service = GWT.create(OWLObjectSerializationTestsService.class);
        service.testOWLClassImpl(in, new AsyncCallback<OWLClassImpl>() {
            @Override
            public void onFailure(Throwable throwable) {
                fail(throwable.getMessage());
            }

            @Override
            public void onSuccess(OWLClassImpl out) {
                assertEquals(in, out);
                finishTest();
            }
        });
    }

    public void testShouldSerializeOWLObjectPropertyImpl() {
        delayTestFinish(TEST_DELAY_MS);
        final OWLObjectPropertyImpl in = new OWLObjectPropertyImpl(IRI.create("http://org.semanticweb.owlapi.gwt#A"));
        OWLObjectSerializationTestsServiceAsync service = GWT.create(OWLObjectSerializationTestsService.class);
        service.testOWLObjectPropertyImpl(in, new AsyncCallback<OWLObjectPropertyImpl>() {
            @Override
            public void onFailure(Throwable throwable) {
                fail(throwable.getMessage());
            }

            @Override
            public void onSuccess(OWLObjectPropertyImpl out) {
                assertEquals(in, out);
                finishTest();
            }
        });
    }


    public void testShouldSerializeOWLDataPropertyImpl() {
        delayTestFinish(TEST_DELAY_MS);
        final OWLDataPropertyImpl in = new OWLDataPropertyImpl(IRI.create("http://org.semanticweb.owlapi.gwt#A"));
        OWLObjectSerializationTestsServiceAsync service = GWT.create(OWLObjectSerializationTestsService.class);
        service.testOWLDataPropertyImpl(in, new AsyncCallback<OWLDataPropertyImpl>() {
            @Override
            public void onFailure(Throwable throwable) {
                fail(throwable.getMessage());
            }

            @Override
            public void onSuccess(OWLDataPropertyImpl out) {
                assertEquals(in, out);
                finishTest();
            }
        });
    }

    public void testShouldSerializeOWLAnnotationPropertyImpl() {
        delayTestFinish(TEST_DELAY_MS);
        final OWLAnnotationPropertyImpl in = new OWLAnnotationPropertyImpl(IRI.create("http://org.semanticweb.owlapi.gwt#A"));
        OWLObjectSerializationTestsServiceAsync service = GWT.create(OWLObjectSerializationTestsService.class);
        service.testOWLAnnotationPropertyImpl(in, new AsyncCallback<OWLAnnotationPropertyImpl>() {
            @Override
            public void onFailure(Throwable throwable) {
                fail(throwable.getMessage());
            }

            @Override
            public void onSuccess(OWLAnnotationPropertyImpl out) {
                assertEquals(in, out);
                finishTest();
            }
        });
    }

    public void testShouldSerializeOWLNamedIndividualImpl() {
        delayTestFinish(TEST_DELAY_MS);
        final OWLNamedIndividualImpl in = new OWLNamedIndividualImpl(IRI.create("http://org.semanticweb.owlapi.gwt#A"));
        OWLObjectSerializationTestsServiceAsync service = GWT.create(OWLObjectSerializationTestsService.class);
        service.testOWLNamedIndividualImpl(in, new AsyncCallback<OWLNamedIndividualImpl>() {
            @Override
            public void onFailure(Throwable throwable) {
                fail(throwable.getMessage());
            }

            @Override
            public void onSuccess(OWLNamedIndividualImpl out) {
                assertEquals(in, out);
                finishTest();
            }
        });
    }

    public void testShouldSerializeOWLDatatypeImpl() {
        delayTestFinish(TEST_DELAY_MS);
        final OWLDatatypeImpl in = new OWLDatatypeImpl(IRI.create("http://org.semanticweb.owlapi.gwt#A"));
        OWLObjectSerializationTestsServiceAsync service = GWT.create(OWLObjectSerializationTestsService.class);
        service.testOWLDatatypeImpl(in, new AsyncCallback<OWLDatatypeImpl>() {
            @Override
            public void onFailure(Throwable throwable) {
                fail(throwable.getMessage());
            }

            @Override
            public void onSuccess(OWLDatatypeImpl out) {
                assertEquals(in, out);
                finishTest();
            }
        });
    }

    public void testShouldSerializeOWLLiteralImplBoolean() {
        delayTestFinish(TEST_DELAY_MS);
        final OWLLiteralImplBoolean in = new OWLLiteralImplBoolean(true);
        OWLObjectSerializationTestsServiceAsync service = GWT.create(OWLObjectSerializationTestsService.class);
        service.testOWLLiteralImplBoolean(in, new AsyncCallback<OWLLiteralImplBoolean>() {
            @Override
            public void onFailure(Throwable throwable) {
                fail(throwable.getMessage());
            }

            @Override
            public void onSuccess(OWLLiteralImplBoolean out) {
                assertEquals(in, out);
                finishTest();
            }
        });
    }

    public void testShouldSerializeOWLLiteralImplDouble() {
        delayTestFinish(TEST_DELAY_MS);
        final OWLLiteralImplDouble in = new OWLLiteralImplDouble(3.3, new OWLDatatypeImpl(IRI.create("http://stuff.com/A")));
        OWLObjectSerializationTestsServiceAsync service = GWT.create(OWLObjectSerializationTestsService.class);
        service.testOWLLiteralImplDouble(in, new AsyncCallback<OWLLiteralImplDouble>() {
            @Override
            public void onFailure(Throwable throwable) {
                fail(throwable.getMessage());
            }

            @Override
            public void onSuccess(OWLLiteralImplDouble out) {
                assertEquals(in, out);
                finishTest();
            }
        });
    }

    public void testShouldSerializeOWLLiteralImplInteger() {
        delayTestFinish(TEST_DELAY_MS);
        final OWLLiteralImplInteger in = new OWLLiteralImplInteger(3, new OWLDatatypeImpl(IRI.create("http://stuff.com/A")));
        OWLObjectSerializationTestsServiceAsync service = GWT.create(OWLObjectSerializationTestsService.class);
        service.testOWLLiteralImplInteger(in, new AsyncCallback<OWLLiteralImplInteger>() {
            @Override
            public void onFailure(Throwable throwable) {
                fail(throwable.getMessage());
            }

            @Override
            public void onSuccess(OWLLiteralImplInteger out) {
                assertEquals(in, out);
                finishTest();
            }
        });
    }

    public void testShouldSerializeOWL2DatatypeImpl() {
        delayTestFinish(TEST_DELAY_MS);
        final OWL2DatatypeImpl in = (OWL2DatatypeImpl) OWL2DatatypeImpl.getDatatype(OWL2Datatype.RDF_PLAIN_LITERAL);
        OWLObjectSerializationTestsServiceAsync service = GWT.create(OWLObjectSerializationTestsService.class);
        service.testOWL2DatatypeImpl(in, new AsyncCallback<OWL2DatatypeImpl>() {
            @Override
            public void onFailure(Throwable throwable) {
                fail(throwable.getMessage());
            }

            @Override
            public void onSuccess(OWL2DatatypeImpl out) {
                assertEquals(in, out);
                finishTest();
            }
        });
    }

    public void testShouldSerializeOWLLiteralImplNoCompression() {
        delayTestFinish(TEST_DELAY_MS);
        final OWLLiteralImplNoCompression in = new OWLLiteralImplNoCompression("xyz", null, null);
        OWLObjectSerializationTestsServiceAsync service = GWT.create(OWLObjectSerializationTestsService.class);
        service.testOWLLiteralImplNoCompression(in, new AsyncCallback<OWLLiteralImplNoCompression>() {
            @Override
            public void onFailure(Throwable throwable) {
                throwable.printStackTrace();
                fail(throwable.getMessage());

            }

            @Override
            public void onSuccess(OWLLiteralImplNoCompression out) {
                assertEquals(in, out);
                finishTest();
            }
        });
    }


}
