/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connections;

import java.awt.Window;
import java.awt.event.WindowEvent;

/**
 *
 * @author vborotis
 */
public class MyWindowEvent extends WindowEvent{
    public boolean exitAndSave;
    
    public MyWindowEvent(Window source, int id, boolean exitAndSave) {
      super(source, id);
      System.out.println(" source = "+ source + " and id = " + id);
      this.exitAndSave = exitAndSave;
    }
    
}
