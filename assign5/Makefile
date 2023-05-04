JAVAC=/usr/bin/javac
.SUFFIXES: .java .class
SRCDIR=src/main
BINDIR=bin

$(BINDIR)/main/%.class:$(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<


CLASSES= GraphException.class Graph.class Graphgen.class GraphExperiment.class
CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/main/%.class)

default: $(CLASS_FILES)

clean:
	rm $(BINDIR)/main/*.class

run: $(CLASS_FILES)
	java -cp $(BINDIR) main/GraphExperiment
javadoc:
	javadoc -d docs -cp $(BINDIR):$(LIBDIR)/* -sourcepath src/ main