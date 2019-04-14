import Display.Display;
import Display.EditorFrame;

public final class GraphicEditor {
    public static void main(String[] args) {
        new GraphicEditor();
    }

    private GraphicEditor() {
        @SuppressWarnings("unused")
        EditorFrame frame = new EditorFrame(1000, 800);
    }
}
