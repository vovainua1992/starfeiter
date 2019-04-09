package com.space_feiter.util;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;



public class MyJSonParseToPolygon {
    float[] vertices;


    public float[] getPolygon() {
        return vertices;
    }

    public static float[] parseJsonToVertices(FileHandle myJson) {
        if (myJson != null) {
            JsonValue map = new JsonReader().parse(myJson.readString());
            JsonValue bodyElem = map.getChild("rigidBodies");
            return parseVertices(bodyElem);
        }else
            return null;

    }

    public boolean parseJson(FileHandle myJson) {
        if (myJson != null) {
            JsonValue map = new JsonReader().parse(myJson.readString());
            JsonValue bodyElem = map.getChild("rigidBodies");
            vertices = parseVertices(bodyElem);
            return true;
        }else
            return false;

    }

    private static float[] parseVertices(JsonValue bodyElem) {
            float[] res=null;
        JsonValue polygonsElem = bodyElem.getChild("shapes");

        JsonValue vertices = polygonsElem.getChild("vertices");
        int j =0;
        for (; vertices != null; vertices = vertices.next()) {
                      j+=2;
        }
            vertices = polygonsElem.getChild("vertices");
        System.out.println(j);
        res = new float[j];
        for (int i =0; vertices != null; vertices = vertices.next()) {
                float x = vertices.getFloat("x");
                float y = vertices.getFloat("y");
                res [i] = x;
                res[i+1] = y;
                i+=2;

        }
        System.out.println(res[2]+res[3]);
        return res;
    }
}
