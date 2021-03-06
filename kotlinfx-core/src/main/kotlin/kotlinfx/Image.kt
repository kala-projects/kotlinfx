@file:Suppress("NOTHING_TO_INLINE")

package kotlinfx

import java.io.InputStream

typealias Image = javafx.scene.image.Image
typealias WritableImage = javafx.scene.image.WritableImage

typealias PixelFormat<T> = javafx.scene.image.PixelFormat<T>
typealias WritablePixelFormat<T> = javafx.scene.image.WritablePixelFormat<T>
typealias PixelReader = javafx.scene.image.PixelReader
typealias PixelWriter = javafx.scene.image.PixelWriter

typealias ImageView = javafx.scene.image.ImageView


inline fun Image.createView(): ImageView = ImageView(this)

inline fun image(
        url: String,
        requestedWidth: Double = 0.0,
        requestedHeight: Double = 0.0,
        preserveRatio: Boolean = false,
        smooth: Boolean = false,
        backgroundLoading: Boolean = false,
        initializer: Image.() -> Unit = {}): Image {
    return Image(url, requestedWidth, requestedHeight, preserveRatio, smooth, backgroundLoading).apply(initializer)
}

inline fun image(
        input: InputStream,
        requestedWidth: Double = 0.0,
        requestedHeight: Double = 0.0,
        preserveRatio: Boolean = false,
        smooth: Boolean = false,
        initializer: Image.() -> Unit = {}): Image {
    return Image(input, requestedWidth, requestedHeight, preserveRatio, smooth).apply(initializer)
}

inline fun writeableImage(width: Int, height: Int, initializer: WritableImage.() -> Unit = {}): WritableImage {
    return WritableImage(width, height).apply(initializer)
}

inline fun writeableImage(reader: PixelReader, width: Int, height: Int, initializer: WritableImage.() -> Unit = {}): WritableImage {
    return WritableImage(reader, width, height).apply(initializer)
}

inline fun writeableImage(reader: PixelReader, x: Int, y: Int, width: Int, height: Int, initializer: WritableImage.() -> Unit = {}): WritableImage {
    return WritableImage(reader, x, y, width, height).apply(initializer)
}

inline fun imageView(initializer: ImageView.() -> Unit = {}): ImageView {
    return ImageView().apply(initializer)
}

inline fun imageView(url: String, initializer: ImageView.() -> Unit = {}): ImageView {
    return ImageView(url).apply(initializer)
}

inline fun imageView(image: Image, initializer: ImageView.() -> Unit = {}): ImageView {
    return ImageView(image).apply(initializer)
}
