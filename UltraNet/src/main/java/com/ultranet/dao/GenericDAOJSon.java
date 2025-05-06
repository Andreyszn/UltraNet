/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ultranet.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Blaith
 */
public class GenericDAOJSon<T> {

    private String fileName;
    private Gson gson;
    private Type type;

    public GenericDAOJSon() {
    }

    public GenericDAOJSon(String fileName, Type type) {
        this.fileName = fileName;
        this.type = type;
        gson = new GsonBuilder().setPrettyPrinting().create();//formato al Json
    }

    public ArrayList<T> getAll() {
        try (FileReader reader = new FileReader(fileName)) {
            T[] elements = gson.fromJson(reader, type);
            if (elements == null) {
//                System.out.println("getAll retorno Array vacio");
                return new ArrayList<>();
            } else {
//                System.out.println("getAll retorno con elementos");
                return new ArrayList<>(Arrays.asList(elements));
            }
        } catch (IOException e) {
//            System.out.println("getAll retorno execpcion");
            return new ArrayList<>();
        }
    }

    public void writeJson(ArrayList<T> elements) {
        try (FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(elements.toArray(), writer);
        } catch (IOException ex) {
            Logger.getLogger(GenericDAOJSon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String add(T element) {
        ArrayList<T> elements = getAll();
        if (elements.add(element)) {
            writeJson(elements);
            return "agregado con exito.";
        }
        return "malo, malo, mao";
    }

    public int search(T element) {
        ArrayList<T> elements = getAll();
        for (int index = 0; index < elements.size(); index++) {
            System.out.println("valor de element :" + element + "\n index :" + index);
            if (elements.get(index).equals(element)) {
                System.out.println("SearchDao = index");
                return index;
            }
        }
        System.out.println("SearchDao = -1");
        return -1;
    }

    public String edit(T element) {
        ArrayList<T> elements = getAll();
        int index = search(element);
        elements.set(index, element);
        writeJson(elements);
        return "Los datos se han modificado con exito";
    }

    public String delete(T element) {
        ArrayList<T> elements = getAll();
        System.out.println(elements);
        int index = search(element);
        System.out.println(index + " " + element);
        if (index == -1) {
            return "Ese elemento no se encuentra registrado.";
        } else {
            elements.remove(index);
            writeJson(elements);
        }
        return "El elemento fue borrado";
    }
}
