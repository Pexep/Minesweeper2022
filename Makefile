### VARIABLES ###

JC = javac

JAVAC_OPT = \
  -implicit:none \
  -d build -cp "build" \
  -sourcepath "src:tmp" \
	-encoding UTF-8

JVM = java
JVMFLAGS = -jar

### REGLES ESSENTIELLES ###

build/Demineur.class : src/Demineur.java build/MenuDebut.class
	${JC} ${JAVAC_OPT} $<

build/MenuDebut.class : src/MenuDebut.java build/Disposition.class build/ActionChoix.class build/ActionReprendre.class build/ActionQuitDebut.class
	${JC} ${JAVAC_OPT} $<

build/ActionChoix.class : src/ActionChoix.java build/MenuChoix.class
	${JC} ${JAVAC_OPT} $<

build/ActionReprendre.class : src/ActionReprendre.java
	${JC} ${JAVAC_OPT} $<

build/ActionQuitDebut.class : src/ActionQuitDebut.java
	${JC} ${JAVAC_OPT} $<

build/MenuChoix.class : src/MenuChoix.java build/Disposition.class build/ActionPlay.class
	${JC} ${JAVAC_OPT} $<

build/ActionPlay.class : src/ActionPlay.java build/Partie.class
	${JC} ${JAVAC_OPT} $<

build/Partie.class : src/Partie.java build/Disposition.class build/Grille.class build/WindowQuit.class build/ActionQuit.class
	${JC} ${JAVAC_OPT} $<

build/Disposition.class : src/Disposition.java
	${JC} ${JAVAC_OPT} $<

build/WindowQuit.class : src/WindowQuit.java
	${JC} ${JAVAC_OPT} $<

build/ActionQuit.class : src/ActionQuit.java
	${JC} ${JAVAC_OPT} $<

build/Grille.class : src/Grille.java build/Case.class
	${JC} ${JAVAC_OPT} $<

build/Case.class : src/Case.java build/ClickOnCase.class build/HideVoid.class build/Visible.class build/DefaiteOrigine.class build/DefaiteNonSuppose.class build/DefaiteSuppose.class build/GoodSuppose.class build/HideSuppose.class build/HideBombe.class
	${JC} ${JAVAC_OPT} $<

build/ClickOnCase.class : src/ClickOnCase.java
	${JC} ${JAVAC_OPT} $<

build/HideVoid.class : src/HideVoid.java build/HideCase.class
	${JC} ${JAVAC_OPT} $<

build/HideSuppose.class : src/HideSuppose.java build/HideCase.class
	${JC} ${JAVAC_OPT} $<

build/HideBombe.class : src/HideBombe.java build/HideCase.class
	${JC} ${JAVAC_OPT} $<

build/Visible.class : src/Visible.java build/FondCase.class
	${JC} ${JAVAC_OPT} $<

build/DefaiteOrigine.class : src/DefaiteOrigine.java build/FondCase.class
	${JC} ${JAVAC_OPT} $<

build/DefaiteNonSuppose.class : src/DefaiteNonSuppose.java build/FondCase.class
	${JC} ${JAVAC_OPT} $<

build/DefaiteSuppose.class : src/DefaiteSuppose.java build/FondCase.class
	${JC} ${JAVAC_OPT} $<

build/GoodSuppose.class : src/GoodSuppose.java build/FondCase.class
	${JC} ${JAVAC_OPT} $<

build/HideCase.class : src/HideCase.java build/FondCase.class
	${JC} ${JAVAC_OPT} $<

build/FondCase.class : src/FondCase.java
	${JC} ${JAVAC_OPT} $<


### REGLES OPTIONNELLES ###
jar : build/Demineur.class
	jar cvfe Demineur.jar Demineur -C build ./

run : Demineur.jar
	${JVM} ${JVMFLAGS} Demineur.jar

clean :
	-rm -f *.class


### BUTS FACTICES ###

.PHONY : run clean

### FIN ###
