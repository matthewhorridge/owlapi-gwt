owlapi-gwt
==========

owlapi-gwt is a Google Web Toolkit (GWT) module for working with OWL API objects in GWT (both client and server side).
A large subset of the API is supported, which includes entities, class expressions and axioms.  These kinds of objects
can be used on the client side and sent over the wire using the GWT serialization mechanism.

Usage
=====

To use, declare the following maven dependency (or place the ```owlapi-gwt-3.4.8.jar``` on your class path).

```
<dependency>
    <groupId>net.sourceforge.owlapi</groupId>
    <artifactId>owlapi-gwt</artifactId>
    <version>3.4.8</version>
</dependency>
```

Add an ```<inherits name="org.semanticweb.owlapi.gwt.owlapi"/>``` declaration to your GWT module file.

You will also need the OWL API jars on your class path.  You can use the following maven dependency

```
<dependency>
    <groupId>net.sourceforge.owlapi</groupId>
    <artifactId>owlapi-distribution</artifactId>
    <version>3.4.8</version>
</dependency>
```