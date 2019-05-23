import Display.EditorFrame;

public final class GraphicEditor {
    public static void main(String[] args) {
        new GraphicEditor();
    }

    private GraphicEditor() {
        @SuppressWarnings("unused")
        final EditorFrame frame = new EditorFrame(1000, 800);
    }
}
