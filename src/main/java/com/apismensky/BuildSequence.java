package com.apismensky;

//
// camera { videoplayer }
// chat { camera, friends }
// friends { core }
// bitmoji { }
// core {}
// videoplayer
// memories { camera, friends, chat }

//
// Edits a module -> rebuild everything
// Edit a module -> rebuild only selective number of modules
//
// memores -> rebuild memorries
// core -> core, friends, chat memories
//

// given module definiitions List<Module> { module has a list of dependent modules }
//
// edit Set<Module> x,y,z => minimal set<module> to rebuild
// Module = string

import static com.google.common.collect.Sets.newHashSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class BuildSequence {

    private static class Module {
        String name;
        Set<Module> modules;

        public Module(String name) {
            this.name = name;
        }

        public Module(String name, Set<Module> modules) {
            this.name = name;
            this.modules = modules;
        }

        @Override
        public String toString() {
            return "Module{" +
                   "name='" + name + '\'' +
                   '}';
        }
    }

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Module core = new Module("core");
        Module videoplayer = new Module("videoplayer");
        Module camera = new Module("camera", newHashSet(videoplayer));
        Module friends = new Module("friend", newHashSet(core));
        Module chat = new Module("chat", newHashSet(camera, friends));
        Module memories = new Module("memories", newHashSet(camera, friends, chat));
        BuildSequence bs = new BuildSequence();
        bs.register(newHashSet(core, videoplayer, camera, friends, chat, memories));
        Set<Module> toRebuild = bs.getModulesToRebuild(newHashSet(friends, videoplayer));
        System.out.println(toRebuild);
    }

    HashMap<Module, Set<Module>> allModules = new HashMap<>();

    public void register(Set<Module> input) {
        for (Module mod: input) {
            if (mod.modules == null) {
                continue;
            }
            for (Module child : mod.modules) {
                Set<Module> parentSet = allModules.getOrDefault(child, new HashSet<>());
                parentSet.add(mod);
                allModules.put(child, parentSet);
            }
        }
    }

    public Set<Module> getModulesToRebuild(Set<Module> input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        Set<Module> result = new HashSet<>();
        for (Module mod: input) {
            Set<Module> r = new HashSet<>();
            getParents(mod, result);
            result.addAll(r);
        }
        return result;
    }

    private void getParents(Module module, Set<Module> result) {
        if (module == null) {
            return;
        }
        result.add(module);
        Set<Module> parents = allModules.get(module);
        if (parents == null) {
            return;
        }
        for (Module parent : parents) {
            getParents(parent, result);
        }
    }

}
