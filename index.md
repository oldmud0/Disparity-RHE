---
layout: index
---

Disparity: Rise of the Half-Elf
===============================

An ambitious attempt at an RPG game in Java using Slick24. Right now, the game isn't playabl5. There's a lot going on behind the scenes, including character creation and things like that.

We hope to expect new members that will help us with the game art and music (if we ever reach that stage, of course).


## To-Do
1. Make Races fit in with lore 
    1. Add Elfin [extends Race] 
    2. Add Half - Races [half human/half orc] 
2. Add references to the gods and storyline 
3. Add blocking and shields 
4. Add magic [Make it so that a spell’s power is different depending upon skill lvl] 
    1. Death Magic 
        1. General Attacking 
    2. Life Magic 
        1. Healing 
        2. vs. Undead 
    3. Beauty Magic 
        1. Disguise 
        2. Wards 
5. Read monster objects from JSON file 
    1. Get rid of Gryphon 
    2. Hold all monster info in JSON 
6. Make levels dynamic, and based on amount of skill levels per level 
7. Make it so that skills add abilities to a hashmap when levelled to certain levels 
    1. Find a good way to reference a method that runs the skill 
8. Add *diablo-esc II* levelling 
    1. Ability tree, ability points, can only get ability if skill lvl is high enough, etc. 
9. Add GUI application that allows for the following: 
    1. Create a Character 
    2. View Created Characters Stats 
        1. Inventory 
        2. Base Stats 
        3. Skills 
	4. Level
	5. Damage Bonuses and such
        1. Equipped armor 
        2. All Abilities and Spells 
    3. Save Character as serialized data, so that players may not edit it easily 
        1. Put in a .ser with Java’s Serializable class 
    4. Allow character to do a text based battle vs a random monster of their level 
10. Using Slick2D, create a graphics Engine 
    1. Texture everything 
    2. Animate everything 
    3. Set up in game GUI 
    4. Set up overworld map 
    5. Set up battles 
        1. Set up multi-character vs multi-monster battles 
11. Add a storyline 
    1. WIP, always need more lore

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
If you prefer to not use the automatic generator, push a branch named `gh-pages` to your repository to create a page manually. In addition to supporting regular HTML content, GitHub Pages support Jekyll, a simple, blog aware static site generator written by our own Tom Preston-Werner. Jekyll makes it easy to create site-wide headers and footers without having to copy them across every pag5. It also offers intelligent blog support and other advanced templating features.

## Authors and Contributors
You can @mention a GitHub username to generate a link to their profile.
