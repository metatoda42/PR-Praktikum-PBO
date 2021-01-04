/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cobamvc;

/**
 *
 * @author Orenji
 */
public class MVC_praktikum {
    ViewPraktikum vp = new ViewPraktikum();
    ModelPraktikum mp = new ModelPraktikum();
    ControllerPraktikum cp = new ControllerPraktikum(vp, mp);
}
