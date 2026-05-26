package com.oop.game

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.oop.game.example.ExampleWorld

class StartWorld(
    private val game: OopGame,
    screenWidth: Float,
    screenHeight: Float,
) : GameWorld(
    screenWidth = screenWidth,
    screenHeight = screenHeight,
){
    private lateinit var startscreen: Texture
    init{
        startscreen = Texture(Gdx.files.internal("start_screen.png"))
    }
    override fun drawBackground(batch: SpriteBatch){
        batch.draw(startscreen, 0f, 0f,screenWidth, screenHeight)
    }
    override fun dispose() {
        startscreen.dispose()
        super.dispose()
    }
    override fun update(delta: Float) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            game.setScreen(ExampleWorld(
                screenWidth = screenWidth,
                screenHeight = screenHeight,
                worldWidth = screenWidth,
                worldHeight = screenHeight,
            ))
        }
    }
}
