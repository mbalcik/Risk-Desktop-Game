package ui.app.views;

import ui.app.controllers.BuildMapController;
import ui.app.router.Route;
import ui.app.router.View;
import ui.app.router.ViewPanel;
import ui.assets.Assets;
import ui.assets.Fonts;
import ui.components.core.ImageButton;
import ui.components.maps.ClassicMapBoard;
import ui.service.MapController;

import javax.swing.*;
import java.awt.*;


@View(at = Route.BuildMap)
public class BuildMapView extends ViewPanel<BuildMapController> {

    public BuildMapView() {
        setLayout(null);
    }

    @Override
    public void preload() {
        Assets.Background.loadAsset("map");
        Assets.ButtonLg.loadAsset("continue");
    }

    public void initialize() {

        // Set Background
        setViewBackground(Assets.Background.getAsset("map"));

        ClassicMapBoard map = new ClassicMapBoard(MapController.Mode.Build);
        map.setBounds(
                (getWidth() - map.getWidth())/2,
                15,
                map.getWidth(),
                map.getHeight()
        );
        MapController.get().selectAll();
        add(map);

        JLabel label = new JLabel("BUILD MAP");
        label.setFont(Fonts.GilroyExtraBold.deriveFont(32f));
        label.setBounds(30, 20, 400, 44);
        label.setForeground(Color.WHITE);
        add(label);

        ImageButton continueBtn = new ImageButton(Assets.ButtonLg.getAsset("continue").getImageIcon(), 40, 40);
        continueBtn.addActionListener(e -> getController().nextStep());
        continueBtn.setBounds(
                (getContainerWidth() - continueBtn.getPreferredSize().width) / 2,
                getContainerHeight() - continueBtn.getPreferredSize().height - 20,
                continueBtn.getPreferredSize().width,
                continueBtn.getPreferredSize().height
        );
        add(continueBtn);


        setComponentZOrder(map, 2);
        setComponentZOrder(label, 1);
        setComponentZOrder(continueBtn, 0);

    }

}
