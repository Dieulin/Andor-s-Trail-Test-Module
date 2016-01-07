# REPONSE A QUESTION TECHNIQUE
CAL - maintenance et évolution

* Groupe : 
    * Jean Baptiste DELAETER
    * Pauline DESSINGUE
    * Dieulin MAMBOUANA
    * Thibaud VERBAERE	

* Question :
    * Quelle partie du code déclenche le changement de niveau du personnage et les améliorations de caractéristiques qui s'en suivent?

* Réponse : 
    * Le changement du niveau du personnage s'effectue dans le contrôleur SkillController plus précisément dans les actions addSkillLevel, levelUpSkillByQuest et levelUpSkillManually. Les améliorations sont gérées par les actions suivantes applySkillEffectsFromPlayerAttack, applySkillEffectsFromMonsterAttack, applySkillEffectsFromMonsterAttack et applySkillEffects.
