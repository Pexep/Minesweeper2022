### VARIABLES ###

JC = javac
JCFLAGS = -encoding UTF-8 -implicit:none

JVM = java
JVMFLAGS =

### REGLES ESSENTIELLES ###

Demineur.class : Demineur.java MenuDebut.class
	${JC} ${JCFLAGS} Demineur.java

MenuDebut.class : MenuDebut.java Disposition.class ActionChoix.class ActionReprendre.class ActionQuitDebut.class
	${JC} ${JCFLAGS} MenuDebut.java

ActionChoix.class : ActionChoix.java Disposition.class MenuChoix.class
	${JC} ${JCFLAGS} ActionChoix.java

ActionReprendre.class : ActionReprendre.java MenuDebut.class
	${JC} ${JCFLAGS} ActionReprendre.java

ActionQuitDebut.class : ActionQuitDebut.java MenuDebut.class
	${JC} ${JCFLAGS} ActionQuitDebut.java

MenuChoix.class : MenuChoix.java Disposition.class ActionPlay.class
	${JC} ${JCFLAGS} MenuChoix.java

MenuDebut.class : MenuDebut.java Disposition.class ActionChoix.class ActionReprendre.class ActionQuitDebut.class
	${JC} ${JCFLAGS} MenuDebut.java

ActionPlay.class : ActionPlay.java MenuChoix.class Partie.class
	${JC} ${JCFLAGS} ActionPlay.java

Partie.class : Partie.java Disposition.class Grille.class WindowQuit.class ActionQuit.class ActionChoix.class
	${JC} ${JCFLAGS} Partie.java

Disposition.class : Disposition.java
	${JC} ${JCFLAGS} Disposition.java

WindowQuit.class : WindowQuit.java Partie.class
	${JC} ${JCFLAGS} WindowQuit.java

ActionQuit.class : ActionQuit.java Partie.class
	${JC} ${JCFLAGS} ActionQuit.java

Grille.class : Grille.java Case.class Partie.class
	${JC} ${JCFLAGS} Grille.java

Case.class : Case.java Grille.class ClickOnCase.class HideVoid.class Visible.class DefaiteOrigine.class DefaiteNonSuppose.class DefaiteSuppose.class GoodSuppose.class HideSuppose.class HideBombe.class
	${JC} ${JCFLAGS} Case.java

ClickOnCase.class : ClickOnCase.java Partie.class Case.class
	${JC} ${JCFLAGS} ClickOnCase.java

HideVoid.class : HideVoid.java HideCase.class
	${JC} ${JCFLAGS} HideVoid.java

HideSuppose.class : HideSuppose.java HideCase.class
	${JC} ${JCFLAGS} HideSuppose.java

HideBombe.class : HideBombe.java HideCase.class
	${JC} ${JCFLAGS} HideBombe.java

Visible.class : Visible.java FondCase.class
	${JC} ${JCFLAGS} Visible.java

DefaiteOrigine.class : DefaiteOrigine.java FondCase.class
	${JC} ${JCFLAGS} DefaiteOrigine.java

DefaiteNonSuppose.class : DefaiteNonSuppose.java FondCase.class
	${JC} ${JCFLAGS} DefaiteNonSuppose.java

DefaiteSuppose.class : DefaiteSuppose.java FondCase.class
	${JC} ${JCFLAGS} DefaiteSuppose.java

GoodSuppose.class : GoodSuppose.java FondCase.class
	${JC} ${JCFLAGS} GoodSuppose.java

HideCase.class : HideCase.java FondCase.class
	${JC} ${JCFLAGS} HideCase.java

FondCase.class : FondCase.java
	${JC} ${JCFLAGS} FondCase.java


### REGLES OPTIONNELLES ###

run : Demineur.class
	${JVM} ${JVMFLAGS} Demineur

clean :
	-rm -f *.class


### BUTS FACTICES ###

.PHONY : run clean

### FIN ###
