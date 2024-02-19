stib ride

graphe :
	 *-*-*-*
	 |    	|
	*-*-*-*-*

	1.id->node , on construit les noeuds.(PAS DE CONSTRUTCTION SUPPLEMENTAIRE , PAS DOUBLON)
	2.
	Graphe= liste/map de noeud.
	Node= id/valeur , liste voisin.
	

dijkstra:
	calcule toute les distances le depart à la destination(et tout les voisins).
	Chnage la valeur des voisins(pass de infini à 'val') et prend le voisin. Le met à jour
	et recheck le chemin le plus cours entre les voisins.
	tant que le voisin n'est pas définitif(destination) etc...
	
-> il faut donc implementer le code avec le type dans dijkstra donc grapher et node.
