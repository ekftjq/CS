package TextGame;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Moon on 4/8/2016.
 * Flowchart of the game
 * Contains information about the text, image and music of the game at certain points.
 * FlowChart is a tree-like structure with a collection of Nodes
 * Each Flowchart contains a txt file path for Text, a png file path for image, and a mp3 file path for music
 * Once all the lines have been read from the txt file, we move on to the next Flowchart
 */

/*
psudo code:
read image, text and music from flowchart.
if last line is read from the txt file:
    ask for user's input/choice
    move to the next flowchart depending on the users input/choice
repeat until there are no more children
 */
public class FlowChart {
    Path TextPath;
    Path ImagePath;
    Path MusicPath;
    FlowChart parent;
    List<FlowChart> children = new ArrayList<>();

    public FlowChart(Path t, Path i, Path m) {
        TextPath = t;
        ImagePath = i;
        MusicPath = m;
    }

    public FlowChart(Path t, Path i, Path m, FlowChart p) {
        TextPath = t;
        ImagePath = i;
        MusicPath = m;
        parent = p;
    }

    public List<FlowChart> getChildren() {
        return children;
    }

    public void setParent(FlowChart p) {
        parent = p;
    }

    public void addChild(FlowChart f) {
        f.setParent(this);
        this.children.add(f);
    }

    public void addChild(Path t, Path i, Path m) {
        FlowChart child = new FlowChart(t, i, m);
        child.setParent(this);
        this.children.add(child);
    }

    public Path getTextPath() {
        return TextPath;
    }

    public Path getImagePath() {
        return ImagePath;
    }

    public Path getMusicPath() {
        return MusicPath;
    }

    public boolean hasChildren() {
        return this.children.size() > 0;
    }

    public void setImagePath(Path imagePath) {
        ImagePath = imagePath;
    }

    public void setMusicPath(Path musicPath) {
        MusicPath = musicPath;
    }

    public void setTextPath(Path textPath) {
        TextPath = textPath;
    }
}
