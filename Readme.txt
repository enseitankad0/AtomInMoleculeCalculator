Current version of app doesn't support calculating molecules with 2 brackets like
(C5H5)Fe(CO)2CH3 and 3 brackets like {[Co(NH3)4(OH)2]3Co}(SO4)3

To calculate atoms in a molecule perform method in Main class.

System.out.println(parseMolecule.getAtoms("molecule"));
 for example:
 System.out.println(parseMolecule.getAtoms("H2O"));



Meaning of multipliers used in app

FIRST MULTIPLIER
it's a number on the start of molecule.
For example: 22 H2O -> firstMultiplier will be 22.

SECOND MULTIPLIER
it's a number after an elementary.
For example: Fe2OH -> secondMultiplier for Fe will be 2

THIRD MULTIPLIER
is't a number after a round bracket ()
For example: Mg(OH)2 -> thirdMultiplier for O and H will be 2.

FOURTH MULTIPLIER
it's a number after a square bracket []
For example  K4[ON(SO3)2]2