# Projet_Api_Evenements_Membres

L’application à réaliser gère les événements d’une association et de ses membres.

Membre : un membre d’association est caractérisé par son nom, son prénom, son âge et son
adresse. Il n’existe pas deux membres ayant le même nom et le même prénom. Un membre se
connecte à l’application en précisant un mot de passe.

Événement : un événement est défini par un nom, une date et une heure, une durée, un lieu et
un nombre maximum de personnes y participant. Deux événements ne peuvent pas avoir lieu
en même temps dans le même lieu. Le lieu choisi pour l’événement doit avoir une capacité
suffisante pour accueillir tous les participants. Les membres ont la possibilité de déposer des
commentaires sur un événement (message textuel).

Lieu : un lieu est défini par un nom, par une adresse et par une capacité d'accueil (nombre
maximum de personnes dans la salle).

Inscription : un membre peut s’inscrire à un événement. La contrainte est que le membre ne
doit pas être déjà inscrit à un événement qui se chevauche dans le temps avec le nouvel
événement auquel il veut s’inscrire. On ne peut également s’inscrire à un événement que s’il
n’a pas déjà eu lieu et que le nombre maximal de participants n’est pas atteint. Un membre
peut se désinscrire d’un événement s’il n’a pas encore eu lieu.

Fonctionnalités attendues : on doit pouvoir visualiser l’ensemble des membres de
l’association, l’ensemble des événements (tous ou ceux à venir), l’ensemble des inscriptions
pour un événement donné (avec le nombre d’inscrits) et pour chaque membre, pouvoir lister
les événements auxquels il est inscrit (tous ou ceux à venir). L’application doit permettre de
créer, modifier et supprimer de nouveaux membres ou événements (par soucis de
simplification, n’importe quel membre connecté peut créer un événement). On doit également
pouvoir afficher les événements d’un lieu (tous ou ceux à venir) avec la carte d’accès au lieu.



Contraintes techniques

La base de données stockant les informations sur les événements, lieux et membres sera une
base de données SQL. L’accès aux données de cette base se fera via des entités JPA. Les
commentaires seront stockés dans une base MongoDB.

L’interface client Web sera développée en utilisant le framework Vue.js. Elle permet
d’accéder et de modifier les informations sur les membres et événements. Pour un lieu, en
complément de l’adresse, une carte localisant la salle sera intégrée dans l’interface via un
appel à l’API d’OpenStreetMap.
Plusieurs API REST seront développées :

● TODO

Vous choisirez d’implémenter une API soit via Spring soit plus basiquement avec une Servlet
avec obligation d’avoir au moins une implémentation Spring et au moins une implémentation
Servlet.
Pour partager le code au sein de votre trinôme, vous utiliserez Git.


Membre du groupe :

- CharlotteMenou : Charlotte Menou
- Kirawashi : Léo Paugam
- NathanaelMo : Nathanaël Monnier
