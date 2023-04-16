# pockemonApp
=>La Description generale de L'application :
-Cette application montre comment interagir avec des Apis restfull
-elle va permettre de saisir le nom de pockemon pour faire une recherche sur tout les pockemons qui recuperent par 
Api "https://pokeapi.co/api/v2/pokemon/",quand on clique sur pockemon ,elle envoie une requete pour afficher la liste des repositories qui contiennent les informations de pockemon selectionnee.
qui viennent par Api "https://pokeapi.co/api/v2/pokemon/{id ou nom}/"

-La description detaillee de l'application :
 la technologie utilisee:
 Dans mon projet ,j'ai utilisee la bibliotheque Retrofit qui permet d'interagir aux apis Rest de maniere declarative.
 pour pouvoir l'utiliser ,j'ai ajoutee les dependances de Retrofit (librairie Gson,librairie de maven,librairie de circleimage pour la forme des images) dans le fichier graded(App) 
 
 -Les fonctionnalites :
  -la gestion des Pockemons : l'affiche des informations de pockemons (nom,image)
  -la gestion des Apis: gerer la reponse des Apis
  
  -La description d'une Activite 1:
  -premierement ,on recupere les champs et lister tout les pockemons
  les evenements utilisees:
      
   ->l'evenement OnClick sur le Button search , on declare la variable de type GitRepoServiceAPI pour que Retrofit creer un objet qui utilise l'interface qui concerne Activite 1 
          " final GitRepoServiceAPI gitRepoServiceAPI = retrofit.create(GitRepoServiceAPI.class)"
   ->cet evenement permet de lister tout les Pockemons existants 
   
   -la gestion des erreurs:
     - erreur est l'erreur de Connexion.
    
    ->les fonctions dans l'activite:
        = la fonction OnResponse qui afficher l'objet appelee par call.request().url().
     la description d'une Activite 2:
       -recupere les donnees de pockemon par Api 'https://pokeapi.co/api/v2/pokemon/{id ou nom}/'
         
   
   
  
  
 
 
 
 
