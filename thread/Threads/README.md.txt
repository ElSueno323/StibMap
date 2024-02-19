2.1.1
	1. Crée via la creation d'objet avec new
	
	2. start permet de mettre le thread dans la file d'execution 
		 et d'executer la method run de MyThread
	
	3.MyThread sera executer dependa sa boucle j, si plus grande
	 elle aura plus de chance d'etre la derniere à ete terminer.
	
	4. l'appel run permet de terminer d'abord l'execution
	de myThread 'one' et ensuite TestMyThread 
	
ps: * thread.run() , plusieurs fois est interdit

2.1.2
	1.crée via l'interface Runnable(interface fonctionnelle) on crée un Thread ,
	l'autre on tuilisait directement
	Thread. Cela permet d'executer sa methode run juste apres start.

2.2.2
	1.interrupt() : interrompe la methode en lançant une exception.
	interrupted():permet de check si le thread est interrompue et le remet en marche.

	2.On interromp le processus mais dans le 'while()' on check si est interrompu,si c'est 
	le cas le remet en marche.
2.3
	1.le demon continue en arriere plan, durant le sleep tant qu'un autre processeur est en vie
	2.le demon n'a pa pu faire beaucoup de tou de boucle.
	3.Le thread utilisateur attend que demon fini jusqu'a la fin de son exection.

4.1
	1.que le programme s'arret grace au System.exit(0)

4.2
	1. Obj: th main, obj in print -> Th: in run -> Obj:th main,obt out print
		Que la methode print de Obj est lancé d'abord, le thread ensuite.
		apre fin print -> debut show + fin show -> fin thread.
	
	2. 	2Sync: in print-> in run |stop|-> out print -> in show |stop|-> out show -> out run
		x-Sync: in print -> in run-> in show |stop|-> out print-> out show-> out run
		Sync-x: in print -> in run-> in show |stop|-> out print-> out show-> out run
		x-x: in print -> in run-> in show |stop|-> out print-> out show-> out run


Question examen: 
	a.Expliquez l’utilité du mot clef synchronized :
	Rend une methode synchronized ,qui exprime le fait que le l'execution de la methode doit être possible
	uniqueme,nt si le thread actual a la clé du verrou de l'objet actuel.
	Si c'est un bloc , le thread actual doit avoir la clé qui est inqiué dans le parametre du synchronized
	our renté dans le bloc sinon il patiente.