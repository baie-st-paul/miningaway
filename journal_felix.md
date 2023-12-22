# journal de felix

## 11 dec 2023

je viens de realiser que nos journaux sont manquants...
c'est pas si mal parce que on vas vraiment donner un boost que durant cette derniere semaine.

je cherche un peu plus d'info sur comment faire un mod minecraft et je me suis dit que j'allais me baser sur ce mod
ci: https://github.com/MehVahdJukaar/Supplementaries

en essayant de comprendre la structure de fichiers du projet je suis tombé sur cet article un peu useless a mon
avis... https://madelinemiller.dev/blog/forge-vs-fabric/ mais a ma surprise, l'auteur est une senior software engineer à
microsoft et a fait le mod WorldEdit, de toutes les choses.

--- 

petit break

---

on a outliné notre plan d'action pour un MVP pendant notre break

il se comprend de 4 morceaux majeurs:

- les zones magiques
    - apparaissent de maniere aleatoire dans le monde
    - optionnel: effet de particules
    - optionnel: grass changes color
- le Magic O'Meter
    - sur right click, dit dans le chat si le joueur est dans une zone magique
- le magicrafter
    - table de craft multiblock
    - peut etre assemblee partout
    - marche que dans les zones magiques
- la bombe magique
    - crafted in magicrafter
    - grosse explosion (BCP plus grande que TNT)
    - optionnel: laisse une zone magique deriere elle dans la blast zone.

---

j'e pense avoir catché comment enregistrer nos affaires dans un itemgroup. ca devrait nous permettre de voir nos objets
dans le menu creatif.

---

suddently nothing is working parce que mc arrive pas a loader la librairie du narrateur... -_-

---

its working!

i learned that i absolutely have to register an object even if i dont plan on using it.

that means that even if i only *instantiate* a block in a *class* as a private member, something static in the
constructor adds it to a list somewhere and that list is eventually traversed and validated during the loading phase.

turns out the problem really didnt have anything to do with the dreaded narrator...

---

je cherche comment faire la zone magique et je suis tombé la
dessus: https://fabricmc.net/wiki/tutorial:particles#adding_complex_particles

donc, maintenant on sais que le wiki est au moins pas complet pour fabric.

---

to implement the areas, i settled on simply making a block with an attached block entity, and to scan for a certain
number of that block in the suroundings. to do so, im looking through this very comprehensive
tutorial: https://fabricmc.net/wiki/tutorial:screenhandler 
and im also looking on using the `world.collectEntityByType` function.

---

en fin de compte j'ai pas du tout fait ca. j'ai juste fais une fonction qui prend une position 
et le `World` et qui parcoure manuellement avec des for loops les entourages de la position dans 
un range donné, retournant le nombre de NodeStoneEntity trouvée. probablement refactorable pour
n'importe quel bloc

## 22 decembre 2023

dernier jours!

---

philipe travail sur l'ajout du model pour la nodestone