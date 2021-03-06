/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaeaenergy.listener;

import com.gaeaenergy.database.UsuarioDAO;
import com.gaeaenergy.stream.WriteToFile;
import com.gaeaenergy.visual.DesktopPane;
import com.gaeaenergy.visual.FrmLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author Jean
 */
public class EvtLogin implements ActionListener {

    private UsuarioDAO db = new UsuarioDAO();
    private FrmLogin login;

    public EvtLogin(FrmLogin login) {
        this.login = login;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        JRadioButton check = (JRadioButton) login.getjRadioLembrar();
        if ("Logar".equals(ae.getActionCommand())) {
            try {

                if (db.Login(login.getjTxtLogin().getText()) > 0) {
                    DesktopPane init = new DesktopPane();
                    login.dispose();
                    init.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(login, "Usuario incorreto");
                    WriteToFile file = new WriteToFile();
                    file.limparLog();
                }
            } catch (SQLException e) {

            }

            if (check.isSelected()) {
                WriteToFile escrever = new WriteToFile();
                System.out.println("ARQUIVO DE LOGS GERADO NA RAIZ DO SISTEMA");

                try {
                    escrever.escrever(login.getjTxtLogin().getText(), "login.txt");

                    escrever.geraLog(">>>>Usuario logou no sistema");

                } catch (IOException ex) {
                    Logger.getLogger(EvtLogin.class.getName()).log(Level.SEVERE, null, ex);

                }
            }
        }
    }
}
