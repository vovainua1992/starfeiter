package com.space_feiter.viev;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector3;
import com.space_feiter.model.Corvet;
import com.space_feiter.model.StaticObject;
import com.space_feiter.util.MyJSonParseToPolygon;

public class TestScreen implements Screen {
    Corvet staticObject;
    SpriteBatch batch;
    OrthographicCamera camera;
    ShapeRenderer shapeRenderer;
    @Override
    public void show() {
        staticObject = new Corvet(new Texture(Gdx.files.internal("Ship.png")),MyJSonParseToPolygon.parseJsonToVertices(Gdx.files.internal("test")),0,0,2f,2f);
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        staticObject.draw(batch);
        batch.end();
        //staticObject.setScale(2f,1.5f);
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.polygon(staticObject.getVertices());
        shapeRenderer.end();
    }

    @Override
    public void resize(int width, int height) {
        camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        camera.zoom = 0.02f;
        camera.position.set(0f,0f,10f);
        camera.update();

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
