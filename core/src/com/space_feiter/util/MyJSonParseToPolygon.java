package com.space_feiter.util;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;



public class MyJSonParseToPolygon {
    Polygon polygon;


    public Polygon getPolygon() {
        return polygon;
    }

    public boolean parseJson(String myJson) {
        if (myJson != null) {
            JsonValue map = new JsonReader().parse(myJson);
            JsonValue bodyElem = map.getChild("rigidBodies");
            polygon = new Polygon(parseVertices(bodyElem));
            return true;
        }else
            return false;

    }

    public boolean parseJson(FileHandle myJson) {
        if (myJson != null) {
            JsonValue map = new JsonReader().parse(myJson.readString());
            JsonValue bodyElem = map.getChild("rigidBodies");
            polygon = new Polygon(parseVertices(bodyElem));
            return true;
        }else
            return false;

    }

    private float[] parseVertices(JsonValue bodyElem) {
            float[] res=null;
        JsonValue polygonsElem = bodyElem.getChild("shapes");

        JsonValue vertices = polygonsElem.getChild("vertices");
        int j =0;
        for (; vertices != null; vertices = vertices.next()) {
                      j+=2;
        }
        System.out.println(j);
        res = new float[j];
        for (int i =0; vertices != null; vertices = vertices.next()) {
                float x = vertices.getFloat("x");
                float y = vertices.getFloat("y");
                res [i] = x;
                res[i+1] = y;
                i+=2;

        }
        return res;
    }
}
