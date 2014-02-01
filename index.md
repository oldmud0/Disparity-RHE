---
layout: index
---

Disparity: Rise of the Half-Elf
===============================

An ambitious attempt at an RPG game in Java using Slick2D. Right now, the game isn't playable. There's a lot going on behind the scenes, including character creation and things like that.

We hope to expect new members that will help us with the game art and music (if we ever reach that stage, of course).


## To-Do

  

1. Add blocking and shields 
2. Add magic 
    a. Add Spells (extends magic?) 
        i. Fireball 
        ii. Water Whip 
        iii. Shade Claw 
3. Add character races 
    a. Half-Elf  
    b. Half-Orc 
    c. Littling (hobbit-esque) 
4. Read monster objects from JSON file 
    a. Get rid of Gryphon 
    b. Hold all monster race info in JSON 
5. Make levels dynamic, and based on amount of skill levels per level 
6. Make it so that skills add abilities to a hashmap when levelled to certain levels 
    a. Find a good way to reference a method that runs the skill 
7. Add *diablo-esc II* levelling 
    a. Ability tree, ability points, can only get ability if skill lvl is high enough, etc. 
8. Add GUI application that allows for the following: 
    a. Create a Character 
    b. View Created Characters Stats 
        i. Inventory 
        ii. Base Stats 
        iii. Skills 
            - Level 
            - Damage Bonuses and such 

        iv. Equipped armor 
        v. All Abilities and Spells 
    c. Save Character as serialized data, so that players may not edit it easily 
        i. Put in a .ser with Java’s Serializable class 
    d. Allow character to do a text based battle vs a random monster of their level 
9. Using Slick2D, create a graphics Engine 
    a. Texture everything 
    b. Animate everything 
    c. Set up in game GUI 
    d. Set up overworld map 
    e. Set up battles 
        i. Set up multi-character vs multi-monster battles 
10. Add a storyline 
    - WIP, always need more lore


-----------------------
<!--- Don't delete me! :( -->
### GitHub Pages
This automatic page generator is the easiest way to create beautiful pages for all of your projects. Author your page content here using GitHub Flavored Markdown, select a template crafted by a designer, and publish. After your page is generated, you can check out the new branch:

```
$ cd your_repo_root/repo_name
$ git fetch origin
$ git checkout gh-pages
```

## Rather Drive Stick?
If you prefer to not use the automatic generator, push a branch named `gh-pages` to your repository to create a page manually. In addition to supporting regular HTML content, GitHub Pages support Jekyll, a simple, blog aware static site generator written by our own Tom Preston-Werner. Jekyll makes it easy to create site-wide headers and footers without having to copy them across every page. It also offers intelligent blog support and other advanced templating features.

## Authors and Contributors
You can @mention a GitHub username to generate a link to their profile.
