owlapi-gwt
==========

owlapi-gwt is a Google Web Toolkit (GWT) module for working with OWL API objects in GWT (both client and server side).
A large subset of the API is supported, which includes entities, class expressions and axioms.  These kinds of objects
can be used on the client side and sent over the wire using the GWT serialization mechanism.

To use the module, include owlapi-gwt.jar on your class path and add an inherits declaration to your GWT module file
with a name of "org.semanticweb.owlapi.gwt.owlapi".
