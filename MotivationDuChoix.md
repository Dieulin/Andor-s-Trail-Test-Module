# MOTIVATION DU CHOIX DE LA PARTIE TESTEE

CAL - Maintenance et évolution

* Groupe : 
	* Jean Baptiste DELAETER
	* Pauline DESSINGUE
	* Dieulin MAMBOUANA
	* Thibaud VERBAERE

Nous avons décidé de tester les fonnctionnalités du contrôleur ItemController. En particulier les fonctionnalités des actions dropItem, equipItem unequipSlot et useItem.

1. Action: void dropItem(ItemType type, int quantity) :
    - scénario1 : On retire un item avec une quantité q possible (Fait)
        * retour attendu : le joueur a q items en moins dans son inventaire
    -scénario2 : On retire un item avec une quantité supérieure à ce qui est possible (Fait)
        * retour attendu : aucun effet sur l'inventaire
    -scénario3 : On essaye de retirer un item non contenu dans l'inventaire de l'utilisateur (Fait)
        * retour attendu: apparemment un crash car pas de catch !

2. Action: void equipItem(ItemType type, Inventory.WearSlot slot) :
    - scénario1 : On essaye de s'équiper d'un item durant un combat alors que celui-ci n'est pas usé (Fait)
        * retour attendu : aucun effet sur l'équipement du joueur
    - scénario2 : On essaye de s'équiper d'un item durant un combat alors que celui-ci est usé (Fait)
        * retour attendu : le joueur est équipé avec cet item
    - scénario3 : On essaye de s'équiper d'un item qu'on a pas (Fait)
        * retour attendu : aucun effet sur l'équipement du joueur
    - scénario4 : On s'équipe d'une arme a deux mains en ayant un bouclier sur le joueur (Fait)
        * retour attendu : le joueur ne porte plus le bouclier et celui-ci retombe dans l'inventaire
    - scénario5 : On  s'équipe d'un bouclier en ayant une arme a deux mains (Fait)
        * retour attendu : le joueur ne porte plus l'arme et celui-ci retombe dans l'inventaire
    - scénario6 : On s'équipe d'une arme (Fait)
        retour attendu : le joueur est équipé de cette arme

3. Action: void unequipSlot(ItemType type, Inventory.WearSlot slot) :
    - scénario1 : On essaye de deséquiper le personnage avec un élément qui ne se porte pas
        * retour attendu : aucun effet sur l'équipement du joueur
    - scénario2 : On essaye de deséquiper le personnage alors qu'il n'a aucun equipement
        * retour attendu : aucun effet sur l'équipement du joueur
    - scénario3 : On essaye de se deséquiper en plein combat d'un élément usé
        * retour attendu : le joueur ne porte plus élément
    - scénario4 : On essaye de se deséquiper en plein combat d'un élément pas usé
        * retour attendu : aucun effet sur l'équipement du joueur
    - scénario5 : On essaye de deséquiper le joueur d'un élement
        * retour attendu : le joueur ne porte l'élément et celui-ci retombe dans l'inventaire

4. Action: void useItem(ItemType type)
    - scénario1 : On essaye d'utiliser un élément qui n'est pas utilisable (Fait)
        * retour attendu : aucun effet sur le joueur
    - scénario2 : On essaye d'utiliser un élément utilisable (Fait)
        * retour attendu : le joueur ne porte plus élément et les effets de l'élément sont appliqués
    - scénario3 : On utilise un élement utilisable (Fait)
        * retour attendu : l'élément est ajouté à la liste des éléments utilisés 
    - scénario4 : On essaye d'utiliser un élement qui est totalement consommé 
        * retour attendu : plus d'élément dans l'inventaire
