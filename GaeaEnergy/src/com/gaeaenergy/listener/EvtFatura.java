/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaeaenergy.listener;

import com.gaeaenergy.visual.FrmFatura;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author comp8
 */
public class EvtFatura implements ActionListener {

    private FrmFatura fatura;

    public EvtFatura(FrmFatura fatura) {
        this.fatura = fatura;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
