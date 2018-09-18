# Tested on Mac OS Sierra 10.12.6
# Tested with Java 1.8.0_92

JC = javac
JFLAGS = -g
.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
  PrintTree.java

default: classes
classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class

