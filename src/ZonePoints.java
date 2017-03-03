import geometry.Algorithms;
import geometry.Segment;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/** La classe ZoneSaisirPointsAfficherSegments. */
class ZonePoints extends JPanel  {

    private CanvasSaisirPointsAfficherSegments canvas;

    /** Creation de la zone d'affichage. */
    ZonePoints(){
        canvas = new CanvasSaisirPointsAfficherSegments();

        // Panel des boutons
        JPanel panelBoutons = new JPanel();

        final JTextField textNombreSegments = new JTextField("5");
        textNombreSegments.setColumns(5);

        JButton rand = new JButton("Rand Segments");
        rand.addActionListener(e -> doRandomSegments(Integer.parseInt(textNombreSegments.getText())));

        JButton enveloppe = new JButton("Create convex");
        enveloppe.addActionListener(e -> makeConvex());

        JButton effacer = new JButton("Effacer");
        effacer.addActionListener(evt -> clearScreen());

        panelBoutons.add(effacer);
        panelBoutons.add(rand);
        panelBoutons.add(textNombreSegments);
        panelBoutons.add(enveloppe);
        setLayout(new BorderLayout());

        add(canvas, BorderLayout.CENTER);

        add(panelBoutons, BorderLayout.SOUTH);
    }

    private void doRandomSegments(int nbSegments){
        canvas.points.removeAllElements();
        canvas.segments.removeAllElements();
        Random random = new Random();
        for(int i = 0; i < nbSegments * 2; ++i){
            canvas.points.add(new geometry.Point(2 + random.nextDouble() * (canvas.getWidth() - 5), 2 + random.nextDouble() * (canvas.getHeight() - 5)));
        }
        for(int i = 0; i < canvas.points.size(); i+=2){
            canvas.segments.add(new Segment(canvas.points.get(i), canvas.points.get(i + 1)));
        }
        canvas.repaint();
    }

    private void clearScreen(){
        canvas.points.removeAllElements();
        canvas.segments.removeAllElements();
        canvas.repaint();
    }

    private void makeConvex() {
        Algorithms.printIntersectionPossibility(canvas.segments);
    }
}