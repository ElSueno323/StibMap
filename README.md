- 01-02-22 Creation par M.Bettens du projet Atlg4 + debut d'exercice

- 04-02-22 Fin Exercice td01

- 08-02-22 Debut td Thread.
        2.1.1 :
        
        1. Comment la thread est-elle créée et exécutée ?
                MyThread t = new MyThread("one"); t.start(); // lance Thread
        2. Quelle est l’utilité de la méthode start ? Ou est-elle implémentée ?
            Elle permet de lance le thread et ainsi d'excuté sa methode run.
        3. Changez la valeur maximale de la variable d’itération j de la méthode run dans la
            classe MyThread. Que consatez-vous après plusieurs exécutions ?
            Il y a un certain pattern dependant le valeur de j. Une valeur plsu grande prendra  
            plus de temps à le thread detre executé.

        4. Changez l’appel de la méthode start par celui de la méthode run dans la classe     
        TestMyThread. Quelles sont les conséquences sur l’exécution du programme ?
            Si on appel avec run. Cela execute comme un simple processus et ne fera rien comme un
             thread. Car ne crée pas une file d'execution.
        
        2.1.2 :

        1. Comment la thread est-elle créée et exécutée ? Quelles sont les différences avec l’exemple   
        précédent ? Il commence par MyRunnable mais ensuite reviens dans lautre thread et le fini avant 
        d'y revenir.

        2.2.1:
        1. Remarquez les différents appels à la méthode sleep() dans les deux classes. À quel output vous 
        attendez-vous après l’exécution de la méthode main ?
            Il y a deux output celui principale par le main et celui crée vi au thread.
        2.Pourquoi l’appel de la méthode sleep() diffère selon la classe où elle est appelée ?
            car MyTimer herite de Thread et TestMyTiemr n'est pas un thread.
        3.Qu’est ce qu’une InterruptedException ?
            Quand un thread est interromptu a par force quand il est  dans un état occupé.
        4. Quand la thread myTimer cesse-t-elle de s’exécuter ?
            Quand sa varirable shouldRun est a false. Cela l'arrete.
            
            yield()=> met thread courant en pause pour donner la main à un autre.
        2.1.3:
        1. Analysez et exécutez les deux classes. À quoi servent les méthodes interrupted()
        et interrupt() ?
            interrupted()=> regarde si il est interrompu.
            interrupt()=> change l'etat et indique qu'il est interrompu.
        2.Exécutez la classe test en ayant auparavant commenté le return de la méthode run. 
        Que se passe-t-il ? Quelle en est l’explication ?
        Le programme ne s'arrete jamais car le return permet de mettre fin a la boucle du thread qui a cause de cela est dans une boucle infini.
        2.3:
        1. Que les demons tournent en meme temps que les autres threads.
        2. Le deamons n'a pas eu le temps de faire un seul compte car celui ci se met en route 
        uniqement quand il n'est pas le seul threads(les autres threads doivent être autre que des 
        deamons).
        3. Permet d'attendre jusqu'a la fin de vie du thread sans l'interrompre avant.
    4.
        4.1:
        1. Que la valeur de fin est impair. Vu que la varibale est partagé alors la varaible a des 
        incohérence.
        
